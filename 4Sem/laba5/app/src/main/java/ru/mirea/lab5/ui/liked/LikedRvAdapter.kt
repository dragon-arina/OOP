package ru.mirea.lab5.ui.liked

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlinx.android.synthetic.main.item_liked.view.*
import ru.mirea.lab5.R
import ru.mirea.lab5.repos.LikedSingleton

class LikedRvAdapter() : RecyclerView.Adapter<LikedRvAdapter.LikedViewHolder>() {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LikedViewHolder {
        return LikedViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_liked, parent, false))
    }

    override fun onBindViewHolder(holder: LikedViewHolder, position: Int) {
        holder.webView.settings.apply {
            displayZoomControls = false
            loadWithOverviewMode = true
            useWideViewPort = true
        }
        holder.webView.loadUrl(LikedSingleton.createInstance()?.urls?.get(position))
    }

    override fun getItemCount(): Int = LikedSingleton.createInstance()?.urls?.size!!

    inner class LikedViewHolder(itemView: View) : ViewHolder(itemView) {
        val webView: WebView = itemView.vWLiked
    }
}
