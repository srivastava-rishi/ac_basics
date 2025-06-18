package com.rishi.androicomponents

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rishi.androicomponents.navigation.AppArgs
import com.rishi.androicomponents.navigation.AppNavigationActions
import com.rishi.androicomponents.navigation.AppScreen
import com.rishi.androicomponents.presentation.screenA.ScreenA
import com.rishi.androicomponents.presentation.screenB.ScreenB
import com.rishi.androicomponents.presentation.screenC.ScreenC
import com.rishi.androicomponents.presentation.screenD.ScreenD
import com.rishi.androicomponents.presentation.screenE.ScreenE
import kotlin.reflect.KClass


@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: KClass<out AppScreen> = AppScreen.ScreenARoute::class,
    navActions: AppNavigationActions
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable<AppScreen.ScreenARoute> {
            ScreenA(
                onAction = navActions::navigateFromScreenA
            )
        }
        composable<AppScreen.ScreenBRoute> {
            ScreenB(
                onAction = navActions::navigateFromScreenB
            )
        }
        composable<AppScreen.ScreenCRoute> {
            val id = it.savedStateHandle.get<String>(AppArgs.ARG_ID)
            val name = it.savedStateHandle.get<String>(AppArgs.ARG_NAME)
            ScreenC(
                onAction = navActions::navigateFromScreenC,
                id = id,
                name = name
            )
            //reset
            LaunchedEffect(key1 = id) {
                if (id != "") {
                    it.savedStateHandle[AppArgs.ARG_ID] = ""
                    it.savedStateHandle[AppArgs.ARG_NAME] = ""
                }
            }
        }
        composable<AppScreen.ScreenDRoute> {
            ScreenD(
                onAction = navActions::navigateFromScreenD
            )
        }
        composable<AppScreen.ScreenERoute> {
            ScreenE(
                onAction = navActions::navigateFromScreenE
            )
        }
    }
}

/*

  We need to add Serializable dependency


 */