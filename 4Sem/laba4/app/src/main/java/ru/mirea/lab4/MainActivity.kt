package ru.mirea.lab4

import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.mirea.lab4.service.WidgetService
import ru.mirea.lab4.widget.DateWidget
import ru.mirea.lab4.widget.WidgetRepo
import java.util.*

class MainActivity : AppCompatActivity() {

    private var repository: WidgetRepo? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        repository = WidgetRepo.createInstance(applicationContext)
        btnSetDate.setOnClickListener {
            val calendar: Calendar = GregorianCalendar(
                datePicker.year,
                datePicker.month,
                datePicker.dayOfMonth
            )
            val date = calendar.time
            repository?.insertDate(date)
            stopService(Intent(this@MainActivity, WidgetService::class.java))
            startForegroundService(Intent(this@MainActivity, WidgetService::class.java))
            val intent = Intent(this@MainActivity, DateWidget::class.java)
            intent.action = AppWidgetManager.ACTION_APPWIDGET_UPDATE
            val ids = AppWidgetManager.getInstance(application)
                .getAppWidgetIds(ComponentName(application, DateWidget::class.java))
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids)
            sendBroadcast(intent)
        }
    }
}
