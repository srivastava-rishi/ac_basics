package com.rishi.androicomponents

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rishi.androicomponents.screenA.ScreenA
import com.rishi.androicomponents.screenb.ScreenB
import com.rishi.androicomponents.ui.theme.AndroidComponentsTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class OtherActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComponentsTheme {
                OtherScreen(
                    onFinish = {
                        finish()
                    }
                )
            }
        }
    }
}


@Composable
fun OtherScreen(
    onFinish: () -> Unit
) {
    val context = LocalContext.current
    BackHandler {
        context.startActivity(Intent(context, MainActivity::class.java))
        onFinish()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Hi Guysss, OtherActivity is here",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}