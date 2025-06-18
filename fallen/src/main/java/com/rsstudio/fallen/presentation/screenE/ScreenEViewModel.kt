package com.rsstudio.fallen.presentation.screenE

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.rsstudio.fallen.navigation.FallenScreen

class ScreenEViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val navData = savedStateHandle.toRoute<FallenScreen.ScreenERoute>()

    var uiState by mutableStateOf(ScreenEUiState())
        private set

    var uiSideEffect by mutableStateOf<ScreenESideEffect>(ScreenESideEffect.None)

    init {
        Log.d("lion666", "route :- $navData")
        uiState = uiState.copy(
            id = "11",
        )
    }


    fun onEvent(event: ScreenEUiEvent) {
        when (event) {
            ScreenEUiEvent.GoBack -> {
            }
        }
    }

    fun resetUiSideEffect() {
        uiSideEffect = ScreenESideEffect.None
    }
}

data class ScreenEUiState(
    var id: String = "",
)

sealed class ScreenEUiEvent {
    data object GoBack : ScreenEUiEvent()
}

sealed class ScreenESideEffect {
    data object None : ScreenESideEffect()
    data class BackToScreenC(val id: String, val name: String) : ScreenESideEffect()
}

