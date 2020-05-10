package ru.mirea.lab5.ui.main

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import okhttp3.Request
import ru.mirea.lab5.R
import ru.mirea.lab5.model.BreedJsonModel
import ru.mirea.lab5.repos.BreedSingleton
import ru.mirea.lab5.repos.LikedSingleton
import ru.mirea.lab5.repos.UrlSingleton
import ru.mirea.lab5.ui.liked.LikedActivity
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner = findViewById<Spinner>(R.id.spinner)
        spinner.dropDownVerticalOffset = 150
        val func: () -> Unit = {
                val singleton: BreedSingleton? = BreedSingleton.instance
                val breeds: List<String>? = singleton?.breedNames
                val arrayAdapter = ArrayAdapter(
                    this@MainActivity,
                    android.R.layout.simple_spinner_dropdown_item,
                    breeds.orEmpty()
                )
                spinner.adapter = arrayAdapter

        }
        val loader = BreedLoader(func)
        loader.execute()
        UrlSingleton.createInstance("")
        LikedSingleton.createInstance()
        val adapter = MainRvAdapter()
        val notifyData = { adapter.notifyDataSetChanged() }
        rvMain.adapter = adapter
        btnStart.setOnClickListener {
            var breedId: String? = ""
            if (spinner.selectedItem != null) {
                breedId = BreedSingleton.instance
                    ?.getBreedId(spinner.selectedItem.toString())
            }
            val urlSingleton: UrlSingleton? = UrlSingleton.createInstance(breedId)
            urlSingleton?.notify = notifyData
            urlSingleton?.load()
        }
        btnLiked.setOnClickListener {
            startActivity(Intent(this@MainActivity, LikedActivity::class.java))
        }
    }

    private inner class BreedLoader(private val func: () -> Unit) :
        AsyncTask<Void?, Void?, Void?>() {
        override fun onPostExecute(aVoid: Void?) {
            super.onPostExecute(aVoid)
            func.invoke()
        }


        override fun doInBackground(vararg params: Void?): Void? {
            val client = OkHttpClient()
            val request = Request.Builder()
                .addHeader("x-api-key", "8b399562-7d23-44ba-a61a-316c1fa086fe")
                .url("https://api.thecatapi.com/v1/breeds")
                .build()
            try {
                client.newCall(request).execute().use { response ->
                    val body = response.body!!.string()
                    val mapper = ObjectMapper()
                    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                    val breeds: List<BreedJsonModel> =
                        mapper.readValue(
                            body, object : TypeReference<List<BreedJsonModel>>() {})
                    BreedSingleton.createInstance(breeds)
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return null
        }

    }
}
