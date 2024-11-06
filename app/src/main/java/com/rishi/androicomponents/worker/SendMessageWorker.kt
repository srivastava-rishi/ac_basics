package com.rishi.androicomponents.worker

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.delay

class SendMessageWorker(
    appContext: Context,
    workerParameters: WorkerParameters
) : CoroutineWorker(appContext, workerParameters) {
    override suspend fun doWork(): Result {
        delay(3000)
        Log.d("lion", "doWork: Message was sent")
        return Result.success()
    }
}


/*
#This will run on worker thread

class SendMessageWorker(
    appContext: Context,
    workerParameters: WorkerParameters
): Worker(appContext, workerParameters) {

    override fun doWork(): Result {
        TODO("Not yet implemented")
    }
}
 */