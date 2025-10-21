package com.rishi.androicomponents.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.DelicateCoroutinesApi


@OptIn(DelicateCoroutinesApi::class)
class MainViewModel : ViewModel() {

    /*
     What is a Backing Property in Kotlin? (Easy Explanation)
     🔹 Definition: - A backing property is a private variable used behind a public property to control how it gets or sets its value.
     It’s like saying: - "I want to expose this property, but I’ll keep the real value hidden and safe."

     * Why use it?
      1. To hide the actual data from outside classes.
      2. To control access (e.g. make it read-only outside but writable inside).
      3. To add logic when getting or setting a value.

      📦 Example:
      private var _name = "John" // backing property (private)
      val name: String
          get() = _name
     */

    /*
     Version 1 – Using a custom getter:
     private val _uiState = MutableLiveData(MainUiState())
     val uiState: LiveData<MainUiState> get() = _uiState -> Custom getter, evaluated every time uiState is accessed.

     Version 2 – Using direct assignment:
      private val _uiState = MutableLiveData(MainUiState())
      val uiState: LiveData<MainUiState> = _uiState  -> One-time value assignment at initialization.
     */

    private var _uiState = MutableLiveData(MainUiState())
    val uiState: LiveData<MainUiState> get() = _uiState

    var uiState2 by mutableStateOf(MainUiState())
        private set


    init {
      //  _uiState.value = MainUiState(text = "liom") // _uiState.value?.copy(text = "yy")
       // uiState.value = MainUiState(text = "liom")
    }
}

data class MainUiState(
    val text: String = "",
    val age: String = ""
)