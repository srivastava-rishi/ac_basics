package com.rishi.androicomponents.screenA

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rishi.androicomponents.domain.StudentDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScreenAViewModel @Inject constructor(
    private val studentDataUseCase: StudentDataUseCase
) : ViewModel() {

    var uiState by mutableStateOf(ScreenAUiState())
        private set

    init {
        Log.d("lion12", "ScreenAViewModel line no 23 $studentDataUseCase")
        viewModelScope.launch {
            uiState = uiState.copy(
                data = studentDataUseCase.invoke().map {
                    StudentSmallData(
                        id = it.id,
                        name = it.name,
                        age = it.age
                    )
                }
            )
        }
    }
}

data class ScreenAUiState(
    val data: List<StudentSmallData> = emptyList()
)

data class StudentSmallData(
    val id: String = "",
    val name: String = "",
    val age: String = ""
)