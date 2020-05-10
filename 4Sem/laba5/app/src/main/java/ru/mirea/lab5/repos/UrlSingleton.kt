package ru.mirea.lab5.repos

import android.os.AsyncTask
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.OkHttpClient
import okhttp3.Request
import ru.mirea.lab5.model.ItemModel
import ru.mirea.lab5.model.UrlJsonModel
import java.util.*
import java.util.function.Consumer

class UrlSingleton private constructor(breedId: String) {
    private val items: MutableList<ItemModel>
    private val breedId: String

    var notify: () -> Unit = {}

    val urls: List<String>
        get() {
            val urls: MutableList<String> =
                LinkedList()
            for (item in items) {
                item.url?.let { urls.add(it) }
            }
            return urls
        }

    fun addUrls(urls: List<String?>) {
        items.addAll(urls.map { ItemModel(url = it) })
    }

    fun setLiked(url: String?) {
        for (item in items) {
            if (item.url === url) {
                item.liked = 1
            }
        }
    }

    fun setDisliked(url: String?) {
        for (item in items) {
            if (item.url === url) {
                item.liked = -1
            }
        }
    }

    fun getLiked(url: String?): Int {
        for (item in items) {
            if (item.url === url) {
                return item.liked
            }
        }
        return 0
    }

    fun load() {
        val httpHandler = HttpHandler()
        httpHandler.execute(breedId)
    }

    inner class HttpHandler :
        AsyncTask<String?, Void?, List<String?>>() {
        override fun onPostExecute(strings: List<String?>) {
            super.onPostExecute(strings)
            instance!!.addUrls(strings)
            notify.invoke()
        }


        override fun doInBackground(vararg strings: String?): List<String?> {
            val breedId = strings[0]
            val urls: MutableList<String?> =
                ArrayList()
            val client = OkHttpClient()
            val request = Request.Builder()
                .addHeader("x-api-key", "8b399562-7d23-44ba-a61a-316c1fa086fe")
                .url("https://api.thecatapi.com/v1/images/search?limit=9&order=Random&breed_ids=$breedId")
                .build()
            try {
                client.newCall(request).execute().use { response ->
                    val body = response.body!!.string()
                    val mapper = ObjectMapper()
                    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                    val urlList: List<UrlJsonModel> = mapper.readValue(body, object : TypeReference<List<UrlJsonModel>>(){})
                    for (url in urlList) {
                        urls.add(url.url)
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return urls
        }
    }

    companion object {
        var instance: UrlSingleton? = null
            private set

        fun createInstance(breedId: String?): UrlSingleton? {
            if (instance == null) {
                instance = breedId?.let { UrlSingleton(it) }
            }
            if (instance != null && instance!!.breedId !== breedId) {
                instance = breedId?.let { UrlSingleton(it) }
            }
            return instance
        }

    }

    init {
        items = ArrayList()
        this.breedId = breedId
    }
}
