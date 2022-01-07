package com.example.g7s21miguellp13

import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory


class AdminSQLiteOpenHelper (context: Context,) : SQLiteOpenHelper(context, "Usuarios.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table usuarios(id int primary key autoincrement, Nombre text, Edad int, Correo text)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }
}