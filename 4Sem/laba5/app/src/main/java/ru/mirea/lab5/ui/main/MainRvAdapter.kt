package ru.mirea.lab5.ui.main

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlinx.android.synthetic.main.item_main.view.*
import ru.mirea.lab5.R
import ru.mirea.lab5.repos.LikedSingleton
import ru.mirea.lab5.repos.UrlSingleton

class MainRvAdapter() : RecyclerView.Adapter<MainRvAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        if (position == UrlSingleton.instance?.urls?.size?.minus(1)) {
            UrlSingleton.instance!!.load()
        }
        holder.like.setBackgroundColor(Color.WHITE)
        holder.dislike.setBackgroundColor(Color.WHITE)
        holder.view.settings.displayZoomControls = false
        holder.view.settings.loadWithOverviewMode = true
        holder.view.settings.useWideViewPort = true
        val url = UrlSingleton.instance?.urls?.get(position)
        when (UrlSingleton.instance?.getLiked(url)) {
            -1 -> {
                holder.like.setBackgroundColor(Color.WHITE)
                holder.dislike.setBackgroundColor(Color.RED)
            }
            0 -> {
                holder.like.setBackgroundColor(Color.WHITE)
                holder.dislike.setBackgroundColor(Color.WHITE)
            }
            1 -> {
                holder.like.setBackgroundColor(Color.GREEN)
                holder.dislike.setBackgroundColor(Color.WHITE)
            }
        }
        holder.view.loadUrl(url)
        holder.like.setOnClickListener {
            holder.like.setBackgroundColor(Color.GREEN)
            holder.dislike.setBackgroundColor(Color.WHITE)
            UrlSingleton.instance?.setLiked(url)
            LikedSingleton.createInstance()?.addUrl(holder.view.url)
        }
        holder.dislike.setOnClickListener {
            holder.dislike.setBackgroundColor(Color.RED)
            holder.like.setBackgroundColor(Color.WHITE)
            UrlSingleton.instance?.setDisliked(url)
            LikedSingleton.createInstance()?.deleteUrl(holder.view.url)
        }
    }

    override fun getItemCount(): Int = UrlSingleton.instance?.urls?.size!!


    inner class MainViewHolder(itemView: View) : ViewHolder(itemView) {
        val view: WebView = itemView.wView
        val like: AppCompatButton = itemView.btnLike
        val dislike: AppCompatButton = itemView.btnDislike

    }
}