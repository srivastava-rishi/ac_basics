package com.rishi.androicomponents.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rishi.androicomponents.R
import kotlin.random.Random


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NormalList() {
    var data by remember {
        mutableStateOf(
            listOf<Student>(
                Student(
                    id = "1",
                    name = "Rishi",
                    age = 28
                ),
                Student(
                    id = "2",
                    name = "Mango",
                    age = 27
                ),
                Student(
                    id = "3",
                    name = "Kitten",
                    age = 26
                )
            )
        )
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Some Screen",
                        style = MaterialTheme.typography.labelSmall
                    )
                },
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                        contentDescription = "arrow"
                    )
                },

                actions = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_android_black_24dp),
                        contentDescription = "arrow"
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.ic_android_black_24dp),
                        contentDescription = "arrow"
                    )
                }
            )
        }
    ) { innerPadding ->
        NormalListContent(
            modifier = Modifier.padding(innerPadding),
            data = data,
            addData = {
                data = addData(data)
            },
            deleteData = {
                data = deleteData(it,data)
            }
        )
    }
}


@Composable
fun NormalListContent(
    modifier: Modifier,
    data: List<Student>,
    addData: () -> Unit,
    deleteData: (String) -> Unit
) {
    Column(
        modifier = modifier
            .padding(24.dp)
            .fillMaxSize()
    ) {
        LazyColumn {
            items(
                count = data.size,
            ) {
                StudentItem(
                    student = data[it],
                    deleteData = {
                        deleteData.invoke(it)
                    }
                )

                if (data.size - 1 != it) {
                    Spacer(modifier = Modifier.size(12.dp))
                }
            }

            item {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = {
                            addData.invoke()
                        }
                    ) {
                        Text(text = "Add Data")
                    }
                }
            }
        }
    }
}


@Composable
private fun StudentItem(
    student: Student,
    deleteData: (String) -> Unit
) {
    Row {
        Column {
            Text(
                text = "Name: " + student.name,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "age: " + student.age.toString(),
                style = MaterialTheme.typography.labelSmall
            )
        }
        Icon(
            contentDescription = "delete",
            painter = painterResource(id = R.drawable.baseline_delete_24),
            modifier = Modifier.clickable {
                deleteData.invoke(student.id)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShowUi() {
    NormalList()
}


// backed

data class Student(
    val id: String,
    val name: String,
    val age: Int
)

fun getData(): List<Student> {
    return listOf<Student>(
        Student(
            id = "1",
            name = "Rishi",
            age = 28
        ),
        Student(
            id = "2",
            name = "Mango",
            age = 27
        ),
        Student(
            id = "3",
            name = "Kitten",
            age = 26
        )
    )
}

fun addData(existingData: List<Student>): List<Student> {
    val data = mutableListOf<Student>()
    data.addAll(existingData)
    val newData = Student(
        id = System.currentTimeMillis().toString(),
        name = listOf(
            "Hero",
            "Zero",
            "Joker"
        ).random(),
        age = Random.nextInt(18, 100)
    )
    return data.plus(newData)
}

fun deleteData(id: String, data: List<Student>): List<Student> {
    return data.filter {it.id != id}
}

