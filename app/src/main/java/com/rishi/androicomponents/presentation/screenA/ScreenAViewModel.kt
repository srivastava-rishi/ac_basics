package com.rishi.androicomponents.presentation.screenA

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel

class ScreenAViewModel : ViewModel() {

    var uiState by mutableStateOf(ScreenAUiState())
        private set


    var uiSideEffect by mutableStateOf<ScreenASideEffect>(ScreenASideEffect.None)
        private set


    fun onEvent(event: ScreenAUiEvent) {
        when (event) {
            is ScreenAUiEvent.OnAgeChange -> {
                uiState = uiState.copy(age = event.age)
            }

            is ScreenAUiEvent.OnGenderChange -> {
                uiState = uiState.copy(gender = event.gender)
            }

            is ScreenAUiEvent.OnNameChange -> {
                uiState = uiState.copy(name = event.name)
            }

            ScreenAUiEvent.OnDone -> {
                uiSideEffect = ScreenASideEffect.OpenScreenB(
                    uiState.name.text,
                    uiState.age.text.toIntOrNull() ?: 0,
                    uiState.gender.text
                )
            }
        }
    }

    fun resetUiSideEffect() {
        uiSideEffect = ScreenASideEffect.None
    }
}

data class ScreenAUiState(
    var name: TextFieldValue = TextFieldValue(),
    var age: TextFieldValue = TextFieldValue(),
    var gender: TextFieldValue = TextFieldValue()
)

sealed class ScreenAUiEvent {
    data class OnNameChange(val name: TextFieldValue) :
        ScreenAUiEvent()

    data class OnAgeChange(val age: TextFieldValue) :
        ScreenAUiEvent()

    data class OnGenderChange(val gender: TextFieldValue) :
        ScreenAUiEvent()

    data object OnDone : ScreenAUiEvent()
}

sealed class ScreenASideEffect {
    data object None : ScreenASideEffect()
    data class OpenScreenB(val name: String, val age: Int, val gender: String) :
        ScreenASideEffect()
}

