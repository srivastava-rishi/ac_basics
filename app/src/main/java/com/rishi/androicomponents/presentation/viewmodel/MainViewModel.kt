package com.rishi.androicomponents.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@OptIn(DelicateCoroutinesApi::class)
class MainViewModel: ViewModel() {
   var uiState  by mutableStateOf(MainUiState())
       private set

    init {
        GlobalScope.launch(Dispatchers.IO) {
            for (i in 1..100){
                delay(2000)
                Log.d("learnService", "joker")
                uiState = uiState.copy(text = i.toString())
            }
        }
    }
}

data class MainUiState(
    val text: String = ""
)