package com.rishi.androicomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.rishi.androicomponents.navigation.AppNavigationActions
import com.rishi.androicomponents.ui.theme.AndroidComponentsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidComponentsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationNewWayApp(
                        onFinish = {
                            finish()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun NavigationNewWayApp(
    onFinish: () -> Unit
) {
    val navController = rememberNavController()
    val navActions = remember(navController) {
        AppNavigationActions(navController, onFinish)
    }
    AppNavGraph(
        navController = navController,
        navActions = navActions
    )
}
