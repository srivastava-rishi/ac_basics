package com.rishi.androicomponents

import ScreenB
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = "ScreenA",
) {
    SharedTransitionLayout {
        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = modifier
        ) {
            composable("ScreenA") {
                WithAnimatedScopeProvider {
                    ScreenA(
                        opeScreenB = {
                            navController.navigate("ScreenB")
                        }
                    )
                }
            }
            composable(
                route = "ScreenB"
            ) {
                WithAnimatedScopeProvider {
                    ScreenB()
                }
            }
        }
    }
}