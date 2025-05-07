package com.rishi.androicomponents.screenb

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.rishi.androicomponents.domain.StudentDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ScreenBViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val studentDataUseCase: StudentDataUseCase
) : ViewModel() {
    var uiState by mutableStateOf(ScreenBUiState())
        private set

    private val studentId: String = savedStateHandle["studentId"]!!

    init {
        Log.d("lion12", "ScreenBViewModel line no 25 $studentDataUseCase")
        getStudentData()
    }

    private fun getStudentData() {
        Log.d("lion12", "ScreenBViewModel line no 31:  ${studentDataUseCase.getStudentDetail(id = studentId)}")
        studentDataUseCase.getStudentDetail(id = studentId)?.let {
            uiState = uiState.copy(studentDetail = it)
        }
    }
}

data class ScreenBUiState(
    val studentDetail: StudentDetailInfo = StudentDetailInfo()
)

data class StudentDetailInfo(
    val id: String = "",
    val name: String = "",
    val age: String = "",
    val highestQualification: String = ""
)