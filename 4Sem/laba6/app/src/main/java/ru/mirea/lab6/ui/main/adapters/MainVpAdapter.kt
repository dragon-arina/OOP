package ru.mirea.lab6.ui.main.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlinx.android.synthetic.main.item_vp_main.view.*
import ru.mirea.lab6.R
import ru.mirea.lab6.cart.Cart
import ru.mirea.lab6.item.Item
import ru.mirea.lab6.item.ItemService

class MainVpAdapter(private val context: Context) : RecyclerView.Adapter<MainVpAdapter.MainVpViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainVpViewHolder {
        return MainVpViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_vp_main, parent, false))
    }

    override fun onBindViewHolder(holder: MainVpViewHolder, position: Int) {
        val item: Item? = ItemService.getInstance()?.getAvailableItems()?.get(position)
        holder.name.text = item?.name
        holder.count.text = item?.count.toString()
        holder.price.text = item?.price.toString()
        holder.description.text = item?.description
        holder.button.setOnClickListener {
            if (Cart.instance.getCount(item) < item?.count ?: 0) item?.let { Cart.instance.addItem(it) }
            else Toast.makeText(context, "Not enough", Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int = ItemService.getInstance()?.getAvailableItems()?.size ?: 0

    inner class MainVpViewHolder(itemView: View) : ViewHolder(itemView) {
        val name: TextView = itemView.name_pager_main
        val price: TextView = itemView.price_pager_main
        val count: TextView = itemView.count_pager_main
        val description: TextView = itemView.desc_pager_main
        val button: AppCompatButton = itemView.viewpager_item_btn
    }

}