package com.rsstudio.fallen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import androidx.navigation.navigation
import com.rsstudio.fallen.navigation.AppNavigationActions
import com.rsstudio.fallen.navigation.FallenScreen
import com.rsstudio.fallen.navigation.uriScreenC
import com.rsstudio.fallen.navigation.uriScreenE
import com.rsstudio.fallen.presentation.screenA.ScreenA
import com.rsstudio.fallen.presentation.screenB.ScreenB
import com.rsstudio.fallen.presentation.screenC.ScreenC
import com.rsstudio.fallen.presentation.screenD.ScreenD
import com.rsstudio.fallen.presentation.screenE.ScreenE
import kotlin.reflect.KClass


@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: KClass<out FallenScreen> = FallenScreen.ScreenARoute::class,
    navActions: AppNavigationActions
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        SomeGraph(
            navActions = navActions
        )
        composable<FallenScreen.ScreenARoute>(
            exitTransition = null,
            enterTransition = null,
            popExitTransition = null,
            popEnterTransition = null
        ) {
            ScreenA(
                onAction = navActions::navigateFromScreenA
            )
        }
        composable<FallenScreen.ScreenBRoute> {
            ScreenB(
                onAction = navActions::navigateFromScreenB
            )
        }
        composable<FallenScreen.ScreenCRoute>(
            deepLinks = listOf(
                navDeepLink<FallenScreen.ScreenCRoute>(basePath = uriScreenC)
            ),
            exitTransition = null,
            enterTransition = null,
            popExitTransition = null,
            popEnterTransition = null
        ) {
            ScreenC(
                navController = navController,
                onAction = navActions::navigateFromScreenC
            )
        }
    }
}

/*
  We need to add Serializable dependency
*/


fun NavGraphBuilder.SomeGraph(
    startDestination: KClass<out FallenScreen> = FallenScreen.ScreenDRoute::class,
    navActions: AppNavigationActions
) {
    navigation<FallenScreen.ScreenSubGraph>(
        startDestination = startDestination
    ) {
        composable<FallenScreen.ScreenDRoute> {
            ScreenD(
                onAction = navActions::navigateFromScreenD
            )
        }
        composable<FallenScreen.ScreenERoute>(
            deepLinks = listOf(
                navDeepLink<FallenScreen.ScreenERoute>(basePath = uriScreenE)
            )
        ) {
            ScreenE(
                onAction = navActions::navigateFromScreenE
            )
        }
    }
}