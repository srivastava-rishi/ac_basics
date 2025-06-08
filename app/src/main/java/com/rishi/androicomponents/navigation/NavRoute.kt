package com.rishi.androicomponents.navigation

import kotlinx.serialization.Serializable


object AppArgs {
    const val ARG_ID = "id"
    const val ARG_NAME = "name"
}

sealed class AppScreen {

    @Serializable
    data object ScreenARoute : AppScreen()

    @Serializable
    data class ScreenBRoute(val name: String, val age: Int, val gender: String) : AppScreen()

    @Serializable
    data object ScreenCRoute : AppScreen()

    @Serializable
    data object ScreenDRoute : AppScreen()
}