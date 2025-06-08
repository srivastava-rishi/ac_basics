package com.rishi.androicomponents.navigation

/**
 * Add all you app screen actions here ====================================
 */


sealed class ScreenAActions {
    data class OpenScreenB(
        val name: String, val age: Int, val gender: String
    ) : ScreenAActions()
}

sealed class ScreenBActions {
    data object OnBack : ScreenBActions()
}

sealed class ScreenCActions {
    data object OnBack : ScreenCActions()
    data object OpenScreenD : ScreenCActions()
}

sealed class ScreenDActions {
    data object OnBack : ScreenDActions()
    data class BackToScreenC(val id: String, val name: String) : ScreenDActions()
}

