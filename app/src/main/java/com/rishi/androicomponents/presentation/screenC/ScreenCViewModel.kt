package com.rishi.androicomponents.presentation.screenC

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.rishi.androicomponents.navigation.AppScreen
import com.rishi.androicomponents.presentation.screenA.ScreenASideEffect

class ScreenCViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val navData = savedStateHandle.toRoute<AppScreen.ScreenCRoute>()

    var uiState by mutableStateOf(ScreenCUiState())
        private set

    var uiSideEffect by mutableStateOf<ScreenCSideEffect>(ScreenCSideEffect.None)

    init {
        uiState = uiState.copy(name = "")
    }


    fun onEvent(event: ScreenCUiEvent) {
        when (event) {
            ScreenCUiEvent.OnClickButton -> {
                uiSideEffect = ScreenCSideEffect.OpenScreenD
            }

            is ScreenCUiEvent.StudentDataGotBack -> {
                uiState = uiState.copy(id = event.id, name = event.name)
            }
        }
    }

    fun resetUiSideEffect() {
        uiSideEffect = ScreenCSideEffect.None
    }
}

data class ScreenCUiState(
    var id: String = "",
    var name: String = ""
)

sealed class ScreenCUiEvent {
    data object OnClickButton : ScreenCUiEvent()
    data class StudentDataGotBack(val name: String, val id: String) : ScreenCUiEvent()
}

sealed class ScreenCSideEffect {
    data object None : ScreenCSideEffect()
    data object OpenScreenD : ScreenCSideEffect()
}

