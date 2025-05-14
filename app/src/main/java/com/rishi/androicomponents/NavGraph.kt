package com.rishi.androicomponents

import ScreenB
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = "ScreenA",
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable("ScreenA") {
            ScreenA(
                opeScreenB = {
                    navController.navigate("ScreenB")
                }
            )
        }
        composable(
            route = "ScreenB"
        ) {
            ScreenB()
        }
    }
}