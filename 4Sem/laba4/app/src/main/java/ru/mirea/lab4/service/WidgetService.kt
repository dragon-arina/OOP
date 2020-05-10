package ru.mirea.lab4.service

import android.annotation.TargetApi
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi
import ru.mirea.lab4.R
import ru.mirea.lab4.widget.WidgetRepo
import java.util.*
import java.util.concurrent.TimeUnit

class WidgetService : Service() {

    var repository: WidgetRepo? = WidgetRepo.instance
    var channelId = "channel_id"
    var manager: NotificationManager? = null
    var thread: Thread = object : Thread() {
        @RequiresApi(Build.VERSION_CODES.O)
        override fun run() {
            val date: Date? = repository?.date
            try {
                val timetoNotify =
                    date!!.time - Calendar.getInstance().time.time
                TimeUnit.MILLISECONDS.sleep(timetoNotify)
                val builder: Notification.Builder =
                    Notification.Builder(this@WidgetService, channelId)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Notification")
                        .setContentText("Notification!")
                val notification = builder.build()
                manager!!.notify(1, notification)
            } catch (e: InterruptedException) {
                return
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        thread.start()
        return super.onStartCommand(intent, flags, startId)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @TargetApi(Build.VERSION_CODES.N)
    override fun onCreate() {
        manager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val name = "chnl"
        val importance = NotificationManager.IMPORTANCE_HIGH
        val channel = NotificationChannel(channelId, name, importance)
        channel.description = "Notifications for service"
        channel.enableLights(true)
        channel.lightColor = Color.BLUE
        channel.enableVibration(true)
        channel.setShowBadge(true)
        manager!!.createNotificationChannel(channel)
        val builder: Notification.Builder =
            Notification.Builder(this, channelId)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Notification")
                .setContentText("Service started")
        val notification = builder.build()
        super.onCreate()
        startForeground(1, notification)
    }

    override fun onDestroy() {
        thread.interrupt()
        super.onDestroy()
    }
}
