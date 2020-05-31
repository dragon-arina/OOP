package ru.mirea.lab6.ui.cart

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_cart.*
import ru.mirea.lab6.R
import ru.mirea.lab6.cart.Cart
import ru.mirea.lab6.item.ItemService

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        recycler_cart.layoutManager = LinearLayoutManager(applicationContext)
        recycler_cart.adapter = CartRvAdapter()
        buy_btn_cart.setOnClickListener {
            ItemService.getInstance()?.performPurchase(Cart.instance)
            Cart.instance.clearCart()
            finish()
        }
    }

}