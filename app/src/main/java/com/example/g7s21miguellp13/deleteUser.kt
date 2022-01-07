package com.example.g7s21miguellp13

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.g7s21miguellp13.databinding.ActivityDeleteUserBinding


class deleteUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDeleteUserBinding.inflate(layoutInflater)
        var id = intent.getIntExtra("id",-1)
        setContentView(binding.root)
        binding.idText.isEnabled = false
        binding.nameText.isEnabled = false
        binding.ageText.isEnabled = false
        binding.mailText.isEnabled = false
        binding.button.isEnabled = false

        if(id != -1) {
            val dates: MutableList<*> = getDates(id)
            val date= dates[0].toString().split("   ")
            println(date)
            binding.idText.setText(date[0])
            binding.nameText.setText(date[1])
            binding.ageText.setText(date[2])
            binding.mailText.setText(date[3])
            binding.button.isEnabled = true

        }
        else{

            Toast.makeText(this,"No haz seleccionado un id valido", Toast.LENGTH_LONG).show()
        }

         binding.button.setOnClickListener{
             var dbUsers = AdminSQLiteOpenHelper(this)
             var result = dbUsers.delDate(id)
             var ressT= "Eliminidado(s) "+result.toString()+" de la tabla"
             Toast.makeText(this,ressT, Toast.LENGTH_LONG).show()
             id=-1
         }



        binding.retu.setOnClickListener{
            val menu = Intent(this, menu::class.java)
            menu.putExtra("id",id)
            startActivity(menu)

        }

    }

    private fun getDates(id:Int): MutableList<*>{
        val dbUsers = AdminSQLiteOpenHelper(this)
        val dbRead=dbUsers.readableDatabase
        val args= arrayOf(id.toString())

        val cursor=dbRead.rawQuery("select * from users where id =?", args,null)
        val listDates:MutableList<String> = mutableListOf()

        if (cursor.moveToFirst()) {
            do {
                var Text=""
                Text+= cursor.getInt(0).toString()+"   "
                Text+= cursor.getString(1).toString()+"   "
                Text+= cursor.getInt(2).toString()+"   "
                Text+= cursor.getString(3).toString()

                listDates.add(listDates.size,Text)
            }while (cursor.moveToNext())

        }
        cursor.close()

        return listDates
    }
}