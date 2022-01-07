package com.example.g7s21miguellp13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.g7s21miguellp13.databinding.ActivityListElementsBinding

class listElements : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val numberSel=-1
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_elements)
        val binding = ActivityListElementsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dbUsers = AdminSQLiteOpenHelper(this)
        val dbRead=dbUsers.readableDatabase
        val cursor=dbRead.rawQuery("select * from users", null)
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
        println(listDates)
        val arrayAdapter:ArrayAdapter<*>
        arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,listDates)
        binding.listView.adapter=arrayAdapter
        var textTemp="id seleccionado: "+numberSel.toString()
        binding.selecText.text=textTemp

        binding.listView.setOnItemClickListener(){parent,view,position,id->
            val textReceived=parent.getItemAtPosition(position).toString().split("   ")

            val numerSel=textReceived[0].toInt()
            var textTemp=numerSel.toString()
            println(numerSel)
            binding.selecText.text="id seleccionado: "+textTemp
        }


    }
}