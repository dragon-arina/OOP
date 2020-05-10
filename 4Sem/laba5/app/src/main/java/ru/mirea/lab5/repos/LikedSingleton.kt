package ru.mirea.lab5.repos

import java.util.*

class LikedSingleton private constructor() {

    val urls: LinkedList<String> = LinkedList()

    fun addUrl(url: String) {
        if (urls.size == 10) {
            urls.pop()
        }
        urls.add(url)
    }

    fun deleteUrl(url: String?) {
        urls.remove(url)
    }

    companion object {
        private var instance: LikedSingleton? = null
        fun createInstance(): LikedSingleton? {
            if (instance == null) {
                instance = LikedSingleton()
            }
            return instance
        }
    }

}