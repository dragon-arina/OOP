package com.mirea

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        rv.apply {
            layoutManager = LinearLayoutManager(this@RecyclerViewActivity)
            adapter = ItemsRecyclerViewAdapter(itemsList())
        }
        btn_back.setOnClickListener { onBackPressed() }

    }

    private fun itemsList(): List<Int> {
        val items = mutableListOf<Int>()
        for (i in 0..999999) items.add(i)
        return items
    }

}