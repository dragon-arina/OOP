package ru.mirea.lab6.ui.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_main.view.*
import ru.mirea.lab6.R
import ru.mirea.lab6.item.Item
import ru.mirea.lab6.item.ItemService

class MainRvAdapter(private val onItemClick: (Int) -> Unit) : RecyclerView.Adapter<MainRvAdapter.MainRvViewHolder?>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRvViewHolder {
        return MainRvViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false))
    }

    override fun onBindViewHolder(holder: MainRvViewHolder, position: Int) {
        val item: Item? = ItemService.getInstance()?.getAvailableItems()?.get(position)
        holder.nameView.text = item?.name
        holder.priceView.text = item?.price.toString()
        holder.layout.setOnClickListener { onItemClick.invoke(position) }
    }

    override fun getItemCount(): Int = ItemService.getInstance()?.getAvailableItems()?.size ?: 0

    inner class MainRvViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val nameView: TextView = itemView.name_text_recycler_main
        val priceView: TextView = itemView.price_text_recycler_main
        val layout = itemView
    }

}
