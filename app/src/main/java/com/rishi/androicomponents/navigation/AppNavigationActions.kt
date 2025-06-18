package com.rishi.androicomponents.navigation

import androidx.navigation.NavController


class AppNavigationActions(
    private val navController: NavController,
    private val onFinish: () -> Unit
) {

    private fun back() {
        navController.popBackStack()
    }

    private fun finishActivity() {
        onFinish()
    }


    fun navigateFromScreenA(actions: ScreenAActions) {
        when (actions) {
            is ScreenAActions.OpenScreenB -> {
                navController.navigate(
                    AppScreen.ScreenBRoute(
                        name = actions.name,
                        age = actions.age,
                        gender = null
                    )
                )
            }

            ScreenAActions.OnBack -> {
                finishActivity()
            }
        }
    }

    fun navigateFromScreenB(actions: ScreenBActions) {
        when (actions) {
            ScreenBActions.OnBack -> {
                back()
            }
        }
    }

    fun navigateFromScreenC(actions: ScreenCActions) {
        when (actions) {
            ScreenCActions.OnBack -> {
                back()
            }

            ScreenCActions.OpenScreenD -> {
                navController.navigate(AppScreen.ScreenDRoute)
            }
        }
    }

    fun navigateFromScreenD(actions: ScreenDActions) {
        when (actions) {
            ScreenDActions.OnBack -> {
                back()
            }

            is ScreenDActions.BackToScreenC -> {
                navController.previousBackStackEntry?.savedStateHandle?.apply {
                    set(
                        AppArgs.ARG_ID,
                        actions.id
                    )
                    set(
                        AppArgs.ARG_NAME,
                        actions.name
                    )
                }
                back()
            }
        }
    }

    fun navigateFromScreenE(actions: ScreenEActions) {
        when (actions) {
            ScreenEActions.OnBack -> {
                back()
            }
        }
    }
}