package ru.mirea.lab3

import android.content.ContentValues
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ru.mirea.lab3.adapter.StudentRvAdapter
import ru.mirea.lab3.repos.StudentRepo
import java.util.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = StudentRepo(applicationContext)
        val rvAdapter = StudentRvAdapter(repository)
        val database = DbHelper(this).readableDatabase

        database.delete("Students", null, null)

        val random = Random()

        for (i in 0..4) {
            val values = ContentValues()
            values.put("FullName", random.nextInt())
            values.put("AddingDate", Calendar.getInstance().time.toString())
            database!!.insert("Students", null, values)
        }

        recycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = StudentRvAdapter(repository)
        }

        addButton.setOnClickListener {
            database!!.insert("Students", null, ContentValues().apply {
                put("FullName", random.nextInt())
                put("AddingDate", Calendar.getInstance().time.toString())
            })
            repository.notifyDBChanged()
            rvAdapter.notifyDataSetChanged()
        }

        changeButton.setOnClickListener {
            database!!.update("Students", ContentValues().apply {
                put("FullName", "Иванов Иван Иваныч")
            }, "ID = " + repository.students.get(repository.students.size - 1).id, null)
            repository.notifyDBChanged()
            rvAdapter.notifyDataSetChanged()
        }
    }
}
