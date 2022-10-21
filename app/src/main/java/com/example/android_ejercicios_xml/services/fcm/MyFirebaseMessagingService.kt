package com.example.android_ejercicios_xml.services.fcm

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.example.android_ejercicios_xml.R
import com.example.android_ejercicios_xml.presentation.activities.notification.NotificationActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService:FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        print("el token es ${token}")
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.d(TAG, "From: ${remoteMessage.from}")

        if (remoteMessage.data.isNotEmpty()) {
            Log.d(TAG, "Message data payload: ${remoteMessage.data}")
        }

        remoteMessage.notification?.let {
            Log.d(TAG, "Message Notification Body: ${it.body}")
            createNotification(it.title!!, it.body!!)
        }
    }

    private fun createNotification(title: String, body: String) {

        // intent para viajar a la sigueinte actividad cuando toquemos la notification
        val intent = Intent(this, NotificationActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)

        // pending intent que sera ejecutado por el sistema cuando llegue la notificacion
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_ONE_SHOT
        )

        // usamos al builder para configurar la notification

        val notificationBuilder = createNotificationDefault(title, body, pendingIntent)

        // invocamos la notificacion
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(
                createChannelDefault(
                    "default_id",
                    "canal",
                    "canal de prueba"
                )
            )
        }

        notificationManager.notify(0, notificationBuilder.build())

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createChannelDefault(
        channelId: String,
        name: String,
        description: String
    ): NotificationChannel {
        return NotificationChannel(
            channelId,
            name,
            NotificationManager.IMPORTANCE_DEFAULT
        ).apply {
            this.description = description
        }
    }

    private fun createNotificationDefault(title: String, body: String, pendingIntent: PendingIntent): NotificationCompat.Builder {
        val notificationBuiler = NotificationCompat
            .Builder(this, "default_id")

        notificationBuiler.setSmallIcon(R.drawable.ic_launcher_foreground)
        notificationBuiler.setContentTitle(title)
        notificationBuiler.setContentText(body)
        notificationBuiler.setStyle(NotificationCompat.BigTextStyle().bigText(body))
        notificationBuiler.setAutoCancel(true)
        notificationBuiler.setContentIntent(pendingIntent)
        notificationBuiler.priority = NotificationCompat.PRIORITY_DEFAULT
        return notificationBuiler
    }

}