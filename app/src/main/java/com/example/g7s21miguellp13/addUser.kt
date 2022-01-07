package com.example.g7s21miguellp13

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.g7s21miguellp13.databinding.ActivityAddUserBinding


class addUser : AppCompatActivity() {
   //lateinit var dbUsers: AdminSQLiteOpenHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAddUserBinding.inflate(layoutInflater)
        val id = intent.getIntExtra("id",-1)
        setContentView(binding.root)
        val dbUsers = AdminSQLiteOpenHelper(this)

        binding.button.setOnClickListener {
            if(binding.ageText.text.isNotBlank() && binding.nameText.text.isNotBlank() && binding.mailText.text.isNotBlank()){

                dbUsers.addDate(binding.nameText.text.toString(), binding.ageText.text.toString().toInt(), binding.mailText.text.toString())
                binding.ageText.text.clear()
                binding.nameText.text.clear()
                binding.mailText.text.clear()

                Toast.makeText(this,"Nuevo usuario agregado",Toast.LENGTH_LONG).show()
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
}