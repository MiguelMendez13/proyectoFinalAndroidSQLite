package com.example.g7s21miguellp13

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.g7s21miguellp13.databinding.ActivityUpdateUserBinding

class updateUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityUpdateUserBinding.inflate(layoutInflater)
        val id = intent.getIntExtra("id",-1)
        setContentView(binding.root)
        if(id != -1) {
            val dates: MutableList<*> = getDates(id)
            val date= dates[0].toString().split("   ")
            println(date)

            binding.idText.setText(date[0])
            binding.nameText.setText(date[1])
            binding.ageText.setText(date[2])
            binding.mailText.setText(date[3])
        }
        else{
            binding.idText.isEnabled = false
            binding.nameText.isEnabled = false
            binding.ageText.isEnabled = false
            binding.mailText.isEnabled = false
            binding.button.isEnabled = false
            Toast.makeText(this,"No haz seleccionado un id valido",Toast.LENGTH_LONG).show()
        }
        val dbUsers = AdminSQLiteOpenHelper(this)
        binding.button.setOnClickListener{
            if(binding.idText.text.isNotBlank() && binding.ageText.text.isNotBlank() && binding.nameText.text.isNotBlank() && binding.mailText.text.isNotBlank()){

                dbUsers.modifyDate(binding.idText.text.toString().toInt(),binding.nameText.text.toString(), binding.ageText.text.toString().toInt(), binding.mailText.text.toString())
                binding.idText.text.clear()
                binding.ageText.text.clear()
                binding.nameText.text.clear()
                binding.mailText.text.clear()

                Toast.makeText(this,"Usuario actualizado",Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this,"Llena todos los campos",Toast.LENGTH_LONG).show()
            }
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