package com.example.g7s21miguellp13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.g7s21miguellp13.databinding.ActivityMenuBinding


class menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnListar.setOnClickListener {}


        binding.btnInsertar.setOnClickListener {}


        binding.btnActualizar.setOnClickListener {}


        binding.btnEliminar.setOnClickListener {}


        binding.btnSalir.setOnClickListener {}






    }
}