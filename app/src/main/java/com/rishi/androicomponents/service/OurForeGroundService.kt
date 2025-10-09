package com.rishi.androicomponents.service

import android.app.Service
import android.content.Intent
import android.os.IBinder


class OurForeGroundService: Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }
}


/*


Android 8.0 (API level 26)
.
.
.
.
.
Android 16 (API level 36) ... latest
 */