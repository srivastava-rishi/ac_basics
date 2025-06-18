package com.rsstudio.fallen.presentation.screenD

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.rsstudio.fallen.navigation.FallenScreen

class ScreenDViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val navData = savedStateHandle.toRoute<FallenScreen.ScreenDRoute>()

    var uiState by mutableStateOf(ScreenDUiState())
        private set

    var uiSideEffect by mutableStateOf<ScreenDSideEffect>(ScreenDSideEffect.None)

    init {
        Log.d("lion666", "route :- $navData")
        uiState = uiState.copy(
            id = "11",
        )
    }


    fun onEvent(event: ScreenDUiEvent) {
        when (event) {
            ScreenDUiEvent.GoBack -> {
                uiSideEffect = ScreenDSideEffect.BackToScreenC(
                    id = listOf("1", "2", "3", "4").random(),
                    name = listOf("Rishi", "Suraj", "Sai", "Rajeev", "Hero").random()
                )
            }
        }
    }

    fun resetUiSideEffect() {
        uiSideEffect = ScreenDSideEffect.None
    }
}

data class ScreenDUiState(
    var id: String = "",
)

sealed class ScreenDUiEvent {
    data object GoBack : ScreenDUiEvent()
}

sealed class ScreenDSideEffect {
    data object None : ScreenDSideEffect()
    data class BackToScreenC(val id: String, val name: String) : ScreenDSideEffect()
}

