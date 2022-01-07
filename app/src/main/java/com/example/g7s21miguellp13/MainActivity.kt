package com.example.g7s21miguellp13

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        abrir()

    }
    private fun abrir(){
        val thread= Thread(Runnable{
            Thread.sleep(10000)
            runOnUiThread {
                val menu = Intent(this, menu::class.java)
                menu.putExtra("id",-1)
                startActivity(menu)
            }
        })

        thread.start()


    }
}