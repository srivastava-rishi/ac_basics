package com.rsstudio.fallen.navigation

import kotlinx.serialization.Serializable


object AppArgs {
    const val ARG_ID = "id"
    const val ARG_NAME = "name"
}

const val uri = "mv://fallen/screenB"
const val uriScreenC = "mv://fallen/"
const val uriScreenE = "mv://fallen/YourScreen"

sealed class FallenScreen {

    @Serializable
    data object ScreenARoute : FallenScreen()

    @Serializable
    data class ScreenBRoute(
        val id: Int,
        val age: Int,
        val gender: String
    ) : FallenScreen()


    @Serializable
    data object ScreenCRoute : FallenScreen()

    @Serializable
    data object ScreenSubGraph : FallenScreen()

    @Serializable
    data object ScreenDRoute : FallenScreen()

    @Serializable
    data object ScreenERoute : FallenScreen()
}