package com.rsstudio.fallen.navigation

import androidx.navigation.NavController


class AppNavigationActions(
    private val navController: NavController,
    private val onFinish: () -> Unit
) {

    private fun back() {
        //navController.popBackStack()
        navController.navigateUp()
    }

    private fun finishActivity() {
        onFinish()
    }


    fun navigateFromScreenA(actions: ScreenAActions) {
        when (actions) {
            is ScreenAActions.OpenScreenB -> {
                navController.navigate(
                    FallenScreen.ScreenBRoute(
                        id = actions.id,
                        age = actions.age,
                        gender = actions.gender
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
        }
    }

    fun navigateFromScreenD(actions: ScreenDActions) {
        when (actions) {
            ScreenDActions.OnBack -> {
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