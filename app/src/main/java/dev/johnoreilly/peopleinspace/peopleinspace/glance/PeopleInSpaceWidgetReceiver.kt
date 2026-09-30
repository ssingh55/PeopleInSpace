package dev.johnoreilly.peopleinspace.glance

import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver

class PeopleInSpaceWidgetReceiver: GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = PeopleInSpaceWidget()

    override fun onReceive(context: Context, intent: Intent) {
        // Validate the intent action
        when (intent.action) {
            AppWidgetManager.ACTION_APPWIDGET_UPDATE -> {
                // This is the expected action for widget updates.
                // If the widget processes any data from extras, validate it here.
                // For example, if it expects an appWidgetId:
                val appWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID)
                if (appWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
                    // Invalid widget ID, do not proceed with update
                    return
                }
                super.onReceive(context, intent)
            }
            // Add other expected actions if applicable, with their own validation
            else -> {
                // Unexpected action, reject and return immediately to prevent processing
                return
            }
        }
    }
}