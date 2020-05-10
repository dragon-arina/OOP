package ru.mirea.lab4.widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.widget.RemoteViews
import ru.mirea.lab4.R
import java.util.*

class DateWidget : AppWidgetProvider() {

    private var repository: WidgetRepo? = null

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)
        repository = WidgetRepo.createInstance(context)
        val views = RemoteViews(context.packageName, R.layout.layout_widget)
        val date: Date? = repository?.date
        val now =
            Date(Calendar.getInstance().time.time)
        println(now)
        var result = "NO"
        if (date != null) {
            if (now.time < date.time) {
                val differenceBetweenDates = date.time - now.time
                val differenceSeconds = differenceBetweenDates / 1000 % 60
                val differenceMinutes = differenceBetweenDates / (1000 * 60) % 60
                val differenceHours = differenceBetweenDates / (1000 * 60 * 60) % 24
                val differenceDays = differenceBetweenDates / (1000 * 60 * 60 * 24)
                result =
                    (differenceDays.toString() + " дней " + differenceHours + " часов " + differenceMinutes + " минут "
                        + differenceSeconds + "  секунд")
            }
        }
        views.setTextViewText(R.id.tvDate, result)
        val componentName = ComponentName(context, DateWidget::class.java)
        AppWidgetManager.getInstance(context).updateAppWidget(componentName, views)
    }

}
