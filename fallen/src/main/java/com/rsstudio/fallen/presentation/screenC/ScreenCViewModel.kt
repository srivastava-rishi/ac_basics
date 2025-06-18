package com.rsstudio.fallen.presentation.screenC

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.rsstudio.fallen.navigation.FallenScreen
import com.rsstudio.fallen.presentation.screenB.ScreenBSideEffect
import com.rsstudio.fallen.presentation.screenB.ScreenBUiEvent
import com.rsstudio.fallen.presentation.screenB.ScreenBUiState

class ScreenCViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val navData = savedStateHandle.toRoute<FallenScreen.ScreenCRoute>()

    // alternative way


    var uiState by mutableStateOf(ScreenCUiState())
        private set

    var uiSideEffect by mutableStateOf<ScreenCSideEffect>(ScreenCSideEffect.None)

    init {
        Log.d("lion223", "ScreenCViewModel: runnned")
        Log.d("lion666", "navData :- $navData")
        Log.d("lion666", "AppScreen.ScreenBRoute :- ${FallenScreen.ScreenBRoute}")
        Log.d("lion666", "savedStateHandle.toRoute :- }")

//        uiState = uiState.copy(
//            name = navData.name, age = navData.age.toString()
//        )
    }


    fun onEvent(event: ScreenCUiEvent) {
        when (event) {

            else -> {}
        }
    }


}

data class ScreenCUiState(
    var name: String = "", var age: String = "", var gender: String = ""
)

sealed class ScreenCUiEvent {}

sealed class ScreenCSideEffect {
    data object None : ScreenCSideEffect()
}

