package com.rishi.androicomponents.data

data class StudentInfo(
    val id: String = "",
    val name: String = "",
    val age: String = "",
    val highestQualification: String = "",
    val address: String = "",
    val phoneNumber: String = "",
    val email: String = "",
    val enrollmentYear: Int = 0,
    val isGraduated: Boolean = false
)
