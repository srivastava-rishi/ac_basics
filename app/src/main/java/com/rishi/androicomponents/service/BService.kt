package com.rishi.androicomponents.service

import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.rishi.androicomponents.R
import com.rishi.androicomponents.util.MockApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class BService : Service() {

    private val job = Job()
    private val scope = CoroutineScope(Dispatchers.IO + job)
    private val notificationId = 1


    override fun onCreate() {
        super.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            ServiceAction.START.name -> {
                onStart()
                MockApi.hitApi(scope) {
                    displayOrUpdateNotification(notificationId, message = it)
                }
            }

            ServiceAction.STOP.name -> {
                stopSelf()
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    private fun onStart() {
        val notification = NotificationCompat.Builder(this, "foregroundService")
            .setSmallIcon(R.drawable.ic_android_black_24dp)
            .setContentTitle("title")
            .setContentText("The is a description")
            .build()
        startForeground(notificationId, notification)
    }

    private fun displayOrUpdateNotification(
        notificationId: Int,
        title: String = "title",
        message: String
    ) {
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notification = NotificationCompat.Builder(this, "foregroundService")
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        notificationManager.notify(notificationId, notification)
    }


    enum class ServiceAction {
        START,
        STOP
    }
}

