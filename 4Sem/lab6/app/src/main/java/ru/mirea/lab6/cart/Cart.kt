package ru.mirea.lab6.cart

import ru.mirea.lab6.item.Item
import java.util.*

class Cart private constructor() {

    companion object {
        val instance = Cart()
    }

    private val items: MutableMap<Item, Int?>

    fun addItem(item: Item) {
        if (items[item] == null) {
            items[item] = 1
        } else {
            items[item] = items[item]!! + 1
        }
    }

    val itemsArray: Array<Item>
        get() = items.keys.toTypedArray()

    fun getCount(item: Item?): Int {
        return if (items[item] == null) 0 else items[item]!!
    }

    fun deleteItem(item: Item) {
        if (items[item] != null) {
            if (items[item] == 1) {
                items.remove(item)
                return
            }
            items[item] = items[item]!! - 1
        }
    }

    fun updateItem(updatedItem: Item) {
        for (item in items.keys) {
            if (item.id == updatedItem.id) {
                if (items[item] ?: 0 > updatedItem.count) {
                    items.remove(item)
                } else {
                    val count = items[item]
                    items.remove(item)
                    items[updatedItem] = count
                }
            }
        }
    }

    fun clearCart() {
        items.clear()
    }

    fun getItems(): Map<Item, Int?> {
        return items
    }


    init {
        items = HashMap<Item, Int?>()
    }
}
