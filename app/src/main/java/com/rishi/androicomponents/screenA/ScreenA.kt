package com.rishi.androicomponents.screenA

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import java.util.UUID


@Composable
fun ScreenA(
) {

    ScreenAContent(
    )
}

@Composable
fun ScreenAContent(
) {
    val list = remember {
        mutableStateListOf(
            Student(
                name = "Rishi",
                age = "12"
            ),
            Student(
                name = "Ayesha",
                age = "84"
            ),
            Student(
                name = "Manngo",
                age = "24"
            ),
            Student(
                name = "Boy",
                age = "43"
            ),
            Student(
                name = "Giel",
                age = "11"
            ),
        )
    }
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(
            items = list,
        ) {
            Item(
                student = it,
                onRemove = {
                    list.remove(it)
                }
            )
        }

        item {
            Button(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                onClick = {
                    list.add(
                        Student(
                            id = UUID.randomUUID().toString(),
                            name = listOf("Apple", "Banana", "Lion").random(),
                            age = listOf("123", "66", "88", "12").random()
                        )
                    )
                }
            ) {
                Text("Add")
            }
        }
    }
}


@Composable
fun Item(
    student: Student,
    onRemove: (Student) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 12.dp)
    ) {
        Row {
            Text(
                text = "Name - "
            )
            Text(
                text = student.name
            )
        }

        Row {
            Text(
                text = "Age - "
            )
            Text(
                text = student.age
            )
        }

        Button(
            onClick = {
                onRemove(student)
            }
        ) {
            Text("Remove")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenAPreview() {
    ScreenAContent()
}

// data layer


fun mockData(): List<Student> {
    return listOf(
        Student(
            name = "Rishi",
            age = "12"
        ),
        Student(
            name = "Ayesha",
            age = "84"
        ),
        Student(
            name = "Manngo",
            age = "24"
        ),
        Student(
            name = "Boy",
            age = "43"
        ),
        Student(
            name = "Giel",
            age = "11"
        ),
    )
}

data class Student(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val age: String
)
