package com.example.lab3

import android.database.Cursor
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_list_data.*
import java.util.*

class ListDataActivity : AppCompatActivity() {

    private lateinit var dbHelper: DbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_data)
        dbHelper = DbHelper(this)
        createListView()
    }

    private fun createListView() {
        val data: Cursor = dbHelper.getData()
        val listData = mutableListOf<String>()
        while (data.moveToNext()) {
            listData.add(
                "${data.position + 1} | ${data.getString(3)} " +
                    "${ data.getString(1)} ${data.getString(4)} | " +
                    data.getString(2)
            )
        }
        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listData)
    }
}