package com.rishi.androicomponents.data.repository

import com.rishi.androicomponents.data.StudentInfo
import javax.inject.Inject

class StudentRepository @Inject constructor() {
    fun getStudentInfo() = listOf(
        StudentInfo(
            "1",
            "Amit Sharma",
            "22",
            "B.Sc",
            "Delhi",
            "9876543210",
            "amit.sharma@example.com",
            2020,
            false
        ),
        StudentInfo(
            "2",
            "Neha Verma",
            "23",
            "M.A.",
            "Mumbai",
            "8765432109",
            "neha.verma@example.com",
            2019,
            true
        ),
        StudentInfo(
            "3",
            "Rahul Gupta",
            "21",
            "B.Tech",
            "Bangalore",
            "7654321098",
            "rahul.gupta@example.com",
            2021,
            false
        ),
        StudentInfo(
            "4",
            "Priya Singh",
            "24",
            "MBA",
            "Hyderabad",
            "6543210987",
            "priya.singh@example.com",
            2018,
            true
        ),
        StudentInfo(
            "5",
            "Sahil Khan",
            "22",
            "B.Com",
            "Chennai",
            "5432109876",
            "sahil.khan@example.com",
            2020,
            false
        ),
        StudentInfo(
            "6",
            "Anjali Patel",
            "25",
            "M.Sc",
            "Pune",
            "4321098765",
            "anjali.patel@example.com",
            2017,
            true
        ),
        StudentInfo(
            "7",
            "Vikram Desai",
            "23",
            "LLB",
            "Ahmedabad",
            "3210987654",
            "vikram.desai@example.com",
            2019,
            true
        ),
        StudentInfo(
            "8",
            "Sneha Iyer",
            "22",
            "BBA",
            "Kolkata",
            "2109876543",
            "sneha.iyer@example.com",
            2021,
            false
        ),
        StudentInfo(
            "9",
            "Manish Rathi",
            "21",
            "B.Sc",
            "Lucknow",
            "1098765432",
            "manish.rathi@example.com",
            2022,
            false
        ),
        StudentInfo(
            "10",
            "Pooja Mehra",
            "24",
            "M.Tech",
            "Jaipur",
            "9988776655",
            "pooja.mehra@example.com",
            2018,
            true
        )
    )
}