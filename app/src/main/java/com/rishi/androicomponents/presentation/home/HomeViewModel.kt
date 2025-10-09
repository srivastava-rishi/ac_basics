package com.rishi.androicomponents.presentation.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    var uiState by mutableStateOf(HomeUiState())
        private set

    private var job: Job? = null

    fun onEvents(events: HomeScreenEvents) {
        when (events) {
            HomeScreenEvents.StartCounter -> {
                if (!uiState.counterStarted) {
                    onStartCounter()
                } else {
                    job?.cancel()
                }
                uiState = uiState.copy(
                    counterStarted = !uiState.counterStarted
                )
            }
        }
    }

    private fun onStartCounter() {
        job = viewModelScope.launch {
            var minute = 0
            var second = 0
            while (isActive) {
                delay(1000)
                second += 1
                if (second == 60) {
                    second = 0
                    minute++
                }
                /*

                Without Locale (your code):String.format("%d:%02d", minute, second)
                1. On an English device → 1:05
                2. On an Arabic/Hindi device → digits may localize → ١:٠٥ / १:०५
                3. For %f you’d also see , vs . as decimal separator depending on locale.

              With a fixed Locale (stable ASCII digits):
              1. String.format(java.util.Locale.US, "%d:%02d", minute, second)
              2. // always "1:05" regardless of device language

                 */
                uiState = uiState.copy(
                    text = String.format(
                        java.util.Locale.US,
                        "%d:%02d",
                        minute,
                        second
                    )
                )
            }
        }
    }
}

data class HomeUiState(
    val counterStarted: Boolean = false,
    val text: String = "0:00"
)

sealed class HomeScreenEvents {
    data object StartCounter : HomeScreenEvents()
}