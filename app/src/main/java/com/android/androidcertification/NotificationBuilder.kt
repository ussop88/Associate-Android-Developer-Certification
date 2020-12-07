package com.android.androidcertification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.RemoteInput

const val CHANNEL_ID = "channel ID"

class NotificationBuilder(private val context: Context) {

    private val notificationId = 3232
    private val textContent = "this is my content"
    private val textTitle = "this is my title"
    val intent = Intent(context, MainActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }

    // Build a PendingIntent for the reply action to trigger.
    var replyPendingIntent: PendingIntent =
        PendingIntent.getBroadcast(
            context,
            23243,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

    private val KEY_TEXT_REPLY = "key_text_reply"
    var replyLabel: String = context.resources.getString(R.string.reply_label)
    var remoteInput: RemoteInput = RemoteInput.Builder(KEY_TEXT_REPLY).run {
        setLabel(replyLabel)
        build()
    }
    val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
    var action: NotificationCompat.Action =
        NotificationCompat.Action.Builder(
            R.drawable.ic_happy_icon,
            context.getString(R.string.label), replyPendingIntent
        )
            .addRemoteInput(remoteInput)
            .build()

    fun build() = NotificationCompat.Builder(context, CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_sad_icon)
        .setContentTitle(textTitle)
        .setContentText(textContent)
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)

    fun buildWithActionTap() = NotificationCompat.Builder(context, CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_sad_icon)
        .setContentTitle(textTitle)
        .setContentText(textContent)
        .setContentIntent(pendingIntent)
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)

    fun buildWithActionReply() = NotificationCompat.Builder(context, CHANNEL_ID)
        .setSmallIcon(R.drawable.ic_sad_icon)
        .setContentTitle(textTitle)
        .setContentText(textContent)
        .addAction(action)
        .setContentIntent(pendingIntent)
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)

    fun createNotificationChannel() = context.apply {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    fun show() {
        with(NotificationManagerCompat.from(context)) {
            // notificationId is a unique int for each notification that you must define
            notify(notificationId, buildWithActionReply().build())
        }
    }
}