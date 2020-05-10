package ru.mirea.lab4.widget

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import ru.mirea.lab4.db.DBHelper
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class WidgetRepo private constructor(context: Context) {

    companion object {
        var instance: WidgetRepo? = null
            private set

        fun createInstance(context: Context): WidgetRepo? {
            if (instance == null) {
                instance = WidgetRepo(context)
            }
            return instance
        }

    }
    
    var helper: DBHelper = DBHelper(context)
    private var database: SQLiteDatabase
    private var format: SimpleDateFormat

    init {
        database = helper.writableDatabase
        format = SimpleDateFormat("dd/MM/yyyy hh", Locale.getDefault())
    }


    fun insertDate(date: Date?) {
        var receivedDate = date
        database.delete("INFO", null, null)
        val calendar: Calendar = GregorianCalendar()
        calendar.time = receivedDate
        calendar[Calendar.HOUR_OF_DAY] = 9
        receivedDate = calendar.time
        val values = ContentValues()
        values.put("DATE", format.format(receivedDate))
        database.insert("INFO", null, values)
    }

    val date: Date?
        get() {
            val cursor =
                database.query("INFO", null, null, null, null, null, null)
            if (cursor.moveToFirst()) {
                val dateColumn = cursor.getColumnIndex("DATE")
                val result = cursor.getString(dateColumn)
                return try {
                    format.parse(result)
                } catch (e: ParseException) {
                    e.printStackTrace()
                    null
                }
            }
            return null
        }
    
    
}
