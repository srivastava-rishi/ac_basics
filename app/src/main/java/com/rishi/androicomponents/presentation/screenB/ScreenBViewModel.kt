package com.rishi.androicomponents.presentation.screenB

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.rishi.androicomponents.navigation.AppScreen

class ScreenBViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val navData = savedStateHandle.toRoute<AppScreen.ScreenBRoute>()

    // alternative way


    var uiState by mutableStateOf(ScreenBUiState())
        private set

    var uiSideEffect by mutableStateOf<ScreenBSideEffect>(ScreenBSideEffect.None)

    init {
        Log.d("lion666", "navData :- $navData")
        Log.d("lion666", "AppScreen.ScreenBRoute :- ${AppScreen.ScreenBRoute}")
        Log.d("lion666", "savedStateHandle.toRoute :- }")

        uiState = uiState.copy(
            name = navData.name, age = navData.age.toString()
        )
    }


    fun onEvent(event: ScreenBUiEvent) {
        when (event) {

            else -> {}
        }
    }


}

data class ScreenBUiState(
    var name: String = "", var age: String = "", var gender: String = ""
)

sealed class ScreenBUiEvent {}

sealed class ScreenBSideEffect {
    data object None : ScreenBSideEffect()
}

