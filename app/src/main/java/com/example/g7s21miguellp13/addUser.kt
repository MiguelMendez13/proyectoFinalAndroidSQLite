package com.example.g7s21miguellp13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.g7s21miguellp13.databinding.ActivityAddUserBinding
import com.example.g7s21miguellp13.AdminSQLiteOpenHelper

class addUser : AppCompatActivity() {
   //lateinit var dbUsers: AdminSQLiteOpenHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAddUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var dbUsers: AdminSQLiteOpenHelper = AdminSQLiteOpenHelper(this)

        binding.button.setOnClickListener {
            if(binding.ageText.text.isNotBlank() && binding.nameText.text.isNotBlank() && binding.mailText.text.isNotBlank()){

                dbUsers.addDate(binding.nameText.text.toString(), binding.ageText.text.toString().toInt(), binding.mailText.text.toString())
                binding.ageText.text.clear()
                binding.nameText.text.clear()
                binding.mailText.text.clear()

                Toast.makeText(this,"Nuevo usuario agregado",Toast.LENGTH_LONG)
            }
            else{
                Toast.makeText(this,"Llena todos los campos",Toast.LENGTH_LONG)
            }
        }



    }
}