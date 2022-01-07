package com.example.g7s21miguellp13

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

            binding.idText.setText(date[0].toString())
            binding.nameText.setText(date[1].toString())
            binding.ageText.setText(date[2].toString())
            binding.mailText.setText(date[3].toString())
        }
        else{
            binding.idText.isEnabled = false
            binding.nameText.isEnabled = false
            binding.ageText.isEnabled = false
            binding.mailText.isEnabled = false
            binding.button.isEnabled = false
            Toast.makeText(this,"No haz seleccionado un id valido",Toast.LENGTH_LONG).show()
        }



    }
    fun getDates(id:Int): MutableList<*>{
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