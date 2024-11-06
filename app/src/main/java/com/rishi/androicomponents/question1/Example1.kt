package com.rishi.androicomponents.question1

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.rishi.androicomponents.networkutility.ConnectionState
import com.rishi.androicomponents.networkutility.connectivityState
import com.rishi.androicomponents.service.BService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun Example1() {
    val context = LocalContext.current

    val connectionLost = connectivityState(context).value === ConnectionState.Unavailable

    var hasCamPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        )
    }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { granted ->
            hasCamPermission = granted
            if (!granted) {
                Log.d("lion22", "Example1: ")
            }
        }
    )

    LaunchedEffect(key1 = true) {
        if (!hasCamPermission) {
            launcher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                Intent(context, BService::class.java).also {
                    it.action = BService.ServiceAction.START.name
                    context.startService(it)
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            )
        ) {
            Text(
                text = "Start Service",
                fontSize = 14.sp
            )
        }
        //
        Button(
            onClick = {
                Intent(context, BService::class.java).also {
                    it.action = BService.ServiceAction.STOP.name
                    context.startService(it)
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            )
        ) {
            Text(
                text = "Stop Service",
                fontSize = 14.sp
            )
        }
    }
}


class TestViewModel() {
    suspend fun mockApiCall() {
        delay(2000)
        Log.d("servicesTesting", "mockApiCall: API CALLED SUCCESSFULLY")
    }
}