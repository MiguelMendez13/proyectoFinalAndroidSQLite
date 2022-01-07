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
        val id = intent.getIntExtra("id",-1)

        binding.btnListar.setOnClickListener {
            val add=Intent(this, listElements::class.java)
            add.putExtra("id",id)
            startActivity(add)
        }


        binding.btnInsertar.setOnClickListener {
            val add=Intent(this, addUser::class.java)
            add.putExtra("id",id)
            startActivity(add)
        }


        binding.btnActualizar.setOnClickListener {
            val add=Intent(this, updateUser::class.java)
            add.putExtra("id",id)
            startActivity(add)
        }


        binding.btnEliminar.setOnClickListener {}


        binding.btnSalir.setOnClickListener {}






    }
}