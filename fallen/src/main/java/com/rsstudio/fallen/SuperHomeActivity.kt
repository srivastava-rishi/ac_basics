package com.rsstudio.fallen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.rsstudio.fallen.navigation.AppNavigationActions
import com.rsstudio.fallen.ui.theme.AndroiComponentsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SuperHomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroiComponentsTheme {
                FallenApp(
                    {
                        finish()
                    }
                )
            }
        }
    }
}

@Composable
fun FallenApp(
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
