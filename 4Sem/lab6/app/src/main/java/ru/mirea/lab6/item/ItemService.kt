package ru.mirea.lab6.item

import ru.mirea.lab6.cart.Cart
import ru.mirea.lab6.util.DataChangedListener
import java.util.*

class ItemService {

    companion object {
        private val instance: ItemService = ItemService().apply { generateItemService() }
        fun getInstance(): ItemService? = instance
    }

    var maxId = 0
    private var items: MutableList<Item>? = null
    private var listeners: MutableList<DataChangedListener>? = null

    fun getAvailableItems(): List<Item>? {
        val availableItems: MutableList<Item> = LinkedList()
        for (item in items!!) {
            if (item.count > 0) availableItems.add(item)
        }
        return availableItems
    }

    fun addDataChangedListener(listener: DataChangedListener) {
        listeners!!.add(listener)
    }

    fun addItem(newItem: Item) {
        newItem.id = maxId + 1
        maxId += 1
        items!!.add(newItem)
        listeners!!.forEach { it.notifyDataChanged() }
    }

    fun deleteItem(id: Int) {
        for (item in items!!) {
            if (item.id == id) items!!.remove(item)
        }
        listeners!!.forEach { it.notifyDataChanged() }
    }

    fun updateItem(updatedItem: Item) {
        for (item in items!!) {
            if (item.id == updatedItem.id) {
                items!![items!!.indexOf(item)] = updatedItem
                Cart.instance.updateItem(updatedItem)
            }
        }
        listeners!!.forEach { it.notifyDataChanged() }

    }

    fun removeListener(listener: DataChangedListener?) {
        listeners!!.remove(listener)
    }

    fun clearListeners() {
        listeners!!.clear()
    }

    fun getItems(): List<Item>? {
        return items
    }

    fun performPurchase(cart: Cart) {
        for (item in cart.itemsArray) {
            item.count = (item.count - cart.getCount(item))
        }
        listeners!!.forEach { it.notifyDataChanged() }
    }

    private fun generateItemService() {
        items = LinkedList()
        listeners = LinkedList()
        addItem(Item(1, "pen", 100, 2, "item"))
        addItem(Item(2, "pencil", 120, 3, "item"))
        addItem(Item(3, "death", 111111, 1, "dyyyyyyyy"))
        addItem(Item(4, "fdajfl", 1212, 0, "flksjf"))
    }
}