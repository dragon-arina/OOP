package com.example.lab3

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context) : SQLiteOpenHelper(context, TABLE_NAME, null, DB_VERSION) {

    companion object {
        private const val TABLE_NAME = "people_table"
        private const val COL2 = "name"
        private const val COL3 = "time"
        private const val COL4 = "surname"
        private const val COL5 = "patronymic"
        private const val DB_VERSION = 27
    }

    var id: Long = 1

    override fun onCreate(db: SQLiteDatabase) {
        val createTable =
            "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 + " TEXT," +
                COL3 + " TEXT," +
                COL4 + " TEXT," +
                COL5 + " TEXT)"
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, i: Int, i1: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addData(
        surname: String?,
        name: String?,
        patronymic: String?,
        time: String?
    ) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL4, surname)
        contentValues.put(COL2, name)
        contentValues.put(COL5, patronymic)
        contentValues.put(COL3, time)
        val result = db.insert(TABLE_NAME, null, contentValues)
        //if date as inserted incorrectly it will return -1
        id = result
    }

    fun replace(
        surname: String?,
        name: String?,
        patronymic: String?
    ): Boolean {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COL4, surname)
        cv.put(COL2, name)
        cv.put(COL5, patronymic)
        db.update(TABLE_NAME, cv, "ID =  $id", null)
        return true
    }

    fun deleteAndUpdate(
        i: Int,
        surname: String?,
        name: String?,
        patronymic: String?,
        time: String?
    ) {
        val db = this.writableDatabase
        if (i == 0) {
            db.delete(TABLE_NAME, null, null)
        }
        val contentValues = ContentValues()
        contentValues.put(COL4, surname)
        contentValues.put(COL2, name)
        contentValues.put(COL5, patronymic)
        contentValues.put(COL3, time)
        val result = db.insert(TABLE_NAME, null, contentValues)
        id = result
        //if date as inserted incorrectly it will return -1
    }

    fun getData(): Cursor {
        val db = this.writableDatabase
        val query = "SELECT * FROM $TABLE_NAME"
        return db.rawQuery(query, null)
    }

}