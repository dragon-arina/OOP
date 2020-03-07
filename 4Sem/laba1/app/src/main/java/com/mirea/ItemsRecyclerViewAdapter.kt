package com.mirea

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_rv.view.*

class ItemsRecyclerViewAdapter(private val items: List<Int>):
    RecyclerView.Adapter<ItemsRecyclerViewAdapter.ItemsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder =
        ItemsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) = holder.onBind(position)

    inner class ItemsViewHolder(view: View): RecyclerView.ViewHolder(view) {

        @SuppressLint("SetTextI18n")
        fun onBind(position: Int) {
            itemView.apply {
                tv_item.text = "${position + 1}"
                if (position % 2 == 0) setBackgroundColor(ContextCompat.getColor(context, R.color.white))
                else setBackgroundColor(ContextCompat.getColor(context, R.color.grey))
            }
        }
    }
}