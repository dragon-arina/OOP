package ru.mirea.lab6.ui.admin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlinx.android.synthetic.main.item_admin_vp.view.*
import ru.mirea.lab6.R
import ru.mirea.lab6.item.Item
import ru.mirea.lab6.item.ItemService

class AdminVpAdapter(private val onItemClick: () -> Unit) : RecyclerView.Adapter<AdminVpAdapter.AdminVpViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdminVpViewHolder {
        return AdminVpViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_admin_vp, parent, false))
    }

    override fun onBindViewHolder(holder: AdminVpViewHolder, position: Int) {
        val item: Item? = ItemService.getInstance()?.getItems()?.get(position)
        holder.name.setText(item?.name)
        holder.price.setText(item?.price.toString())
        holder.count.setText(item?.count.toString())
        holder.description.setText(item?.description)
        holder.change.setOnClickListener {
            try {
                val updatedItem = Item(
                    item?.id ?: 0,
                    holder.name.text.toString(),
                    holder.price.text.toString().toInt(),
                    holder.count.text.toString().toInt(),
                    holder.description.text.toString()
                )
                ItemService.getInstance()?.updateItem(updatedItem)
                onItemClick.invoke()
            } catch (e: NumberFormatException) {
                e.printStackTrace()
            }
        }
        holder.delete.setOnClickListener {
            item?.id?.let { id -> ItemService.getInstance()?.deleteItem(id) }
            onItemClick.invoke()
        }
    }

    override fun getItemCount(): Int = ItemService.getInstance()?.getItems()?.size ?: 0

    inner class AdminVpViewHolder(itemView: View) : ViewHolder(itemView) {
        val name: AppCompatEditText = itemView.name_pager_admin
        val price: AppCompatEditText = itemView.price_pager_admin
        val count: AppCompatEditText = itemView.count_pager_admin
        val description: AppCompatEditText = itemView.desc_pager_admin
        val change: AppCompatButton = itemView.viewpager_item_btn_admin
        val delete: AppCompatButton = itemView.viewpager_delete_btn_admin
    }


}
