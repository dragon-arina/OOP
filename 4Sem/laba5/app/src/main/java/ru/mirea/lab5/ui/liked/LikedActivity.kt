package ru.mirea.lab5.ui.liked

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_liked.*
import ru.mirea.lab5.R

class LikedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liked)
        rvLiked.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = LikedRvAdapter()
        }
    }

}