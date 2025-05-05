package com.rishi.androicomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.rishi.androicomponents.ac.presentation.Example2
import com.rishi.androicomponents.ac.presentation.Hen
import com.rishi.androicomponents.question1.Example1
import com.rishi.androicomponents.ui.theme.AndroidComponentsTheme
import com.rishi.androicomponents.ac.worker.SendMessageWorker
import com.rishi.androicomponents.list.NormalList
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {


    val sendMessageWorkRequest = OneTimeWorkRequest.from(SendMessageWorker::class.java)
    val workManger = WorkManager.getInstance(this)


    val sendMessagePeriodicWorkRequest = PeriodicWorkRequest.Builder(
        SendMessageWorker::class.java,
        1,
        TimeUnit.DAYS
    ).build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        workManger.en(
//            "",
//            ExistingPeriodicWorkPolicy.KEEP,
//            sendMessagePeriodicWorkRequest
//        )
        setContent {
            AndroidComponentsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NormalList()
                }
            }
        }
    }
}