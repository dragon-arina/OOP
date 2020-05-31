package ru.mirea.lab6.ui.admin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlinx.android.synthetic.main.item_rv_admin.view.*
import ru.mirea.lab6.R
import ru.mirea.lab6.item.Item
import ru.mirea.lab6.item.ItemService

class AdminRvAdapter(private val onItemClick: (Int) -> Unit) : RecyclerView.Adapter<AdminRvAdapter.AdminViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdminViewHolder {
        return AdminViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv_admin, parent, false))
    }

    override fun onBindViewHolder(holder: AdminViewHolder, position: Int) {
        val item: Item? = ItemService.getInstance()?.getItems()?.get(position)
        holder.name.text = item?.name
        holder.price.text = item?.price.toString()
        holder.count.text = item?.count.toString()
        holder.layout.setOnClickListener { onItemClick.invoke(position) }
    }

    override fun getItemCount(): Int = ItemService.getInstance()?.getItems()?.size ?: 0


    inner class AdminViewHolder(itemView: View) : ViewHolder(itemView) {
        val name: AppCompatTextView = itemView.name_text_recycler_admin
        val price: AppCompatTextView = itemView.price_text_recycler_admin
        val count: AppCompatTextView = itemView.count_text_recycler_admin
        val layout = itemView
    }
}
