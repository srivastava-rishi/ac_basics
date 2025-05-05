package com.rishi.androicomponents.presentation.shareDataUsingViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OnBoardingViewModel : ViewModel() {
    private val _uiState = MutableLiveData(OnBoardingInfo())
    var uiState: LiveData<OnBoardingInfo> = _uiState


    fun updateUiState(dataType: OnBoardingData, data: String) {
        when (dataType) {
            OnBoardingData.NAME -> _uiState.value = _uiState.value?.copy(name = data)
            OnBoardingData.AGE -> _uiState.value = _uiState.value?.copy(age = data)
            OnBoardingData.FATHERS_NAME -> _uiState.value = _uiState.value?.copy(fathersName = data)
            OnBoardingData.MOTHERS_NAME -> _uiState.value = _uiState.value?.copy(mothersName = data)
        }
    }

    /*
    fun updateName(data: String) {
        _uiState.value = _uiState.value?.copy(name = data)
    }
    fun updateAge(data: String) {
        _uiState.value = _uiState.value?.copy(age = data)
    }
    fun updateFatherName(data: String) {
        _uiState.value = _uiState.value?.copy(fathersName = data)
    }
    fun updateMotherName(data: String) {
        _uiState.value = _uiState.value?.copy(mothersName = data)
    }
     */
}


data class OnBoardingInfo(
    val name: String = "",
    val age: String = "",
    val fathersName: String = "",
    val mothersName: String = ""
)

enum class OnBoardingData {
    NAME,
    AGE,
    FATHERS_NAME,
    MOTHERS_NAME
}