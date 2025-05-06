package com.rishi.androicomponents.screenA

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class ScreenAViewModel : ViewModel() {

    var job: Job? = null

    fun onEvent(event: ScreenAEvent) {
        when (event) {
            ScreenAEvent.OnClickButton -> {
                if (job?.isActive == true) {
                    Log.d("lion1122", "ScreenAEvent.OnClickButton: line no 20 ")
                    return
                }
                job = viewModelScope.launch {
                    hitApi()
                }
            }
        }
    }

    private suspend fun hitApi() {
        Log.d("lion1122", "hitApi: start line no 24 ")
        delay(2000)
        Log.d("lion1122", "hitApi: start line no 26 ")
    }
}

sealed class ScreenAEvent {
    data object OnClickButton : ScreenAEvent()
}
