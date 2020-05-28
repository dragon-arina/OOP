package ru.mirea.lab3.repos

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import ru.mirea.lab3.DbHelper
import ru.mirea.lab3.model.Student

class StudentRepo(context: Context) {

    private var database: SQLiteDatabase
    var students = mutableListOf<Student>()

    private var helper: DbHelper = DbHelper(context)

    fun notifyDBChanged() {
        students.clear()
        database = helper.writableDatabase
        val order = "ID ASC"
        val cursor =
            database.query("Students", null, null, null, null, null, order, null)
        if (cursor.moveToFirst()) {
            val idColumn = cursor.getColumnIndex("ID")
            val nameColumn = cursor.getColumnIndex("FullName")
            val dateColumn = cursor.getColumnIndex("AddingDate")
            do {
                students.add(Student(
                    id = cursor.getInt(idColumn),
                    fullName = cursor.getString(nameColumn),
                    addingDate = cursor.getString(dateColumn)
                ))
            } while (cursor.moveToNext())
        }
        helper.close()
    }


    init {
        database = helper.writableDatabase
        val order = "ID ASC"
        val cursor =
            database.query("Students", null, null, null, null, null, order, null)
        if (cursor.moveToFirst()) {
            val idColumn = cursor.getColumnIndex("ID")
            val nameColumn = cursor.getColumnIndex("FullName")
            val dateColumn = cursor.getColumnIndex("AddingDate")
            do { students.add(Student(
                    id = cursor.getInt(idColumn),
                    fullName = cursor.getString(nameColumn),
                    addingDate = cursor.getString(dateColumn)
                ))
            } while (cursor.moveToNext())
        }
        helper.close()
    }
}
