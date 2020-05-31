package ru.mirea.lab6.ui.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlinx.android.synthetic.main.item_cart.view.*
import ru.mirea.lab6.R
import ru.mirea.lab6.cart.Cart
import ru.mirea.lab6.item.Item

class CartRvAdapter : RecyclerView.Adapter<CartRvAdapter.CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return CartViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false))
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item: Item = Cart.instance.itemsArray[position]
        holder.name.text = item.name
        holder.price.text = item.price.toString()
        holder.count.text = Cart.instance.getCount(item).toString()
    }

    override fun getItemCount(): Int = Cart.instance.itemsArray.size


    inner class CartViewHolder(itemView: View) : ViewHolder(itemView) {
        val name: TextView = itemView.name_text_recycler_cart
        val price: TextView = itemView.price_text_recycler_cart
        val count: TextView = itemView.count_text_recycler_cart
    }
}
