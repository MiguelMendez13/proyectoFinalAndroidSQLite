package com.example.g7s21miguellp13

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.g7s21miguellp13.databinding.ActivityMenuBinding


class menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnListar.setOnClickListener {}


        binding.btnInsertar.setOnClickListener {
            val add=Intent(this, addUser::class.java)
            startActivity(add)
        }


        binding.btnActualizar.setOnClickListener {}


        binding.btnEliminar.setOnClickListener {}


        binding.btnSalir.setOnClickListener {}






    }
}