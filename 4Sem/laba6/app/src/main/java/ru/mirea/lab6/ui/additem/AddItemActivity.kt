package ru.mirea.lab6.ui.additem

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_item.*
import ru.mirea.lab6.R
import ru.mirea.lab6.item.Item
import ru.mirea.lab6.item.ItemService

class AddItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)
        add_btn_add_activity.setOnClickListener {
            if (name_add_activity.text.toString().isNotBlank() && price_add_activity.text.toString().isNotBlank()
                && count_add_activity.text.toString().isNotBlank() && desc_add_activity.text.toString().isNotBlank()
            ) {
                try {
                    val name = name_add_activity.text.toString()
                    val price = price_add_activity.text.toString().toInt()
                    val count = count_add_activity.text.toString().toInt()
                    val description = desc_add_activity.text.toString()
                    val newItem = Item(0, name, price, count, description)
                    ItemService.getInstance()?.addItem(newItem)
                    finish()
                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Неверный ввод", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
