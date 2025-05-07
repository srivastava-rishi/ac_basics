package com.rishi.androicomponents.domain

import com.rishi.androicomponents.data.StudentInfo
import com.rishi.androicomponents.data.repository.StudentRepository
import com.rishi.androicomponents.screenb.StudentDetailInfo
import javax.inject.Inject

class StudentDataUseCase @Inject constructor(
    private val studentRepository: StudentRepository
) {

    private val list = mutableListOf<StudentDetailInfo>()

    operator fun invoke(): List<StudentInfo> {
        val data = studentRepository.getStudentInfo()
        list.addAll(
            data.map {
                StudentDetailInfo(
                    id = it.id,
                    name = it.name,
                    age = it.age,
                    highestQualification = it.highestQualification
                )
            }
        )
        return data
    }

    fun getStudentDetail(id: String) = list.find { it.id == id }
}



