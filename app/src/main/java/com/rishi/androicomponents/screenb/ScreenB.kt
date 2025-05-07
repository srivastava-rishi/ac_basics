package com.rishi.androicomponents.screenb

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rishi.androicomponents.OtherActivity


@Composable
fun ScreenB(
    viewModel: ScreenBViewModel = hiltViewModel(),
    onFinish: () -> Unit
) {
    val context = LocalContext.current
    ScreenBContent(
        viewModel.uiState,
        openOtherActivity = {
            context.startActivity(Intent(context, OtherActivity::class.java))
            onFinish()
        }
    )
}


@Composable
fun ScreenBContent(
    uiState: ScreenBUiState,
    openOtherActivity: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Student Details",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "ID: ${uiState.studentDetail.id}",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(vertical = 4.dp)
        )

        Text(
            text = "Name: ${uiState.studentDetail.name}",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(vertical = 4.dp)
        )

        Text(
            text = "Age: ${uiState.studentDetail.age}",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(vertical = 4.dp)
        )

        Text(
            text = "Qualification: ${uiState.studentDetail.highestQualification}",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(vertical = 4.dp)
        )

        Button(
            onClick = {
                openOtherActivity()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            Text(
                text = "OpenOther Activity",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}


@Composable
fun PreviewScreenB() {
    ScreenBContent(ScreenBUiState(), {})
}