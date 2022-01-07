package com.example.g7s21miguellp13

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory


class AdminSQLiteOpenHelper (context: Context,) : SQLiteOpenHelper(context, "Usuarios.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table users(id INTEGER primary key autoincrement, Name text, Age int, Email text)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }



    fun addDate(Name: String, Age: Int, Email: String){
        val dates= ContentValues()
        dates.put("name",Name)
        dates.put("age",Age)
        dates.put("email",Email)


        val db = this.writableDatabase
        db.insert("users",null,dates)
        db.close()

    }
    fun delDate(id: Int) : Int{
        val dates= arrayOf(id.toString())

        val db = this.writableDatabase
        val deletes=db.delete("users","id = ?",dates)
        db.close()
        return deletes
    }


    fun modifyDate(id: Int, Name: String, Age: Int, Email: String){
        val args=arrayOf(id.toString())

        val dates= ContentValues()
        dates.put("name",Name)
        dates.put("age",Age)
        dates.put("email",Email)


        val db = this.writableDatabase
        db.update("users",dates,"id = ?",args)
        db.close()

    }
}

