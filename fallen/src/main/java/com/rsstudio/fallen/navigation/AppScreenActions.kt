package com.rsstudio.fallen.navigation

/**
 * Add all you app screen actions here ====================================
 */


sealed class ScreenAActions {
    data class OpenScreenB(val id: Int, val age: Int, val gender: String) : ScreenAActions()
    data object OnBack : ScreenAActions()
}

sealed class ScreenBActions {
    data object OnBack : ScreenBActions()
}

sealed class ScreenCActions {
    data object OnBack : ScreenCActions()
}
sealed class ScreenDActions {
    data object OnBack : ScreenDActions()
}
sealed class ScreenEActions {
    data object OnBack : ScreenEActions()
}