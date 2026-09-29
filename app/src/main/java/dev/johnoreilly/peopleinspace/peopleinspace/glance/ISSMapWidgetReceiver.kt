package dev.johnoreilly.peopleinspace.glance

import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver

class ISSMapWidgetReceiver: GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = ISSMapWidget()

    override fun onReceive(context: Context, intent: Intent) {
        // Validate the intent action to ensure it's the expected widget update.
        // Any other action should be ignored to prevent unintended behavior.
        if (intent.action == AppWidgetManager.ACTION_APPWIDGET_UPDATE) {
            super.onReceive(context, intent)
        }
        // Intents with unexpected actions are implicitly ignored.
    }
}