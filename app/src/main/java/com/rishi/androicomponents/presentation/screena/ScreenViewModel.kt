package com.rishi.androicomponents.presentation.screena

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScreenAViewModel @Inject constructor() : ViewModel() {

    var uiState by mutableStateOf(ScreenAUiState())
        private set

    fun onEvent(event: ScreenAEvent) {
        when (event) {
            is ScreenAEvent.FirstNameTextChanged -> {
                uiState = uiState.copy(firstName = event.firstName)
            }
        }
    }
}

data class ScreenAUiState(
    val firstName: TextFieldValue = TextFieldValue()
)

sealed class ScreenAEvent {
    data class FirstNameTextChanged(val firstName: TextFieldValue) : ScreenAEvent()
}