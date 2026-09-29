package dev.johnoreilly.peopleinspace.glance

import android.content.Context
import android.content.Intent
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver

class PeopleInSpaceWidgetReceiver: GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = PeopleInSpaceWidget()

    override fun onReceive(context: Context, intent: Intent) {
        // Validate the intent action. Only process expected system actions.
        // For App Widgets, the primary action is APPWIDGET_UPDATE.
        // Other actions like APPWIDGET_DELETED, APPWIDGET_ENABLED are also system-generated.
        when (intent.action) {
            "android.appwidget.action.APPWIDGET_UPDATE",
            "android.appwidget.action.APPWIDGET_DELETED",
            "android.appwidget.action.APPWIDGET_ENABLED",
            "android.appwidget.action.APPWIDGET_DISABLED",
            "android.appwidget.action.APPWIDGET_RESTORED" -> {
                // For these system actions, proceed to super.onReceive()
                // The Glance framework will handle the specific widget lifecycle events.
                // If any custom extras are expected, they should be explicitly validated here.
                // Example: val customData = intent.getStringExtra("custom_key")?.trim() ?: return
                super.onReceive(context, intent)
            }
            else -> {
                // Log or ignore unexpected actions from external sources
                // Do NOT call super.onReceive() for unexpected actions
                // Log.w("WidgetReceiver", "Received unexpected action: ${intent.action}")
                return
            }
        }
    }
}