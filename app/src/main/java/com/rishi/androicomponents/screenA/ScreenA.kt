package com.rishi.androicomponents.screenA

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ScreenA(
    viewModel: ScreenAViewModel = hiltViewModel(),
    openBScreen: (String) -> Unit
) {
    ScreenAContent(
        viewModel.uiState,
        openBScreen = openBScreen
    )
}

@Composable
fun ScreenAContent(
    uiState: ScreenAUiState,
    openBScreen: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(uiState.data) { student ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        openBScreen(student.id)
                    }
                    .padding(vertical = 8.dp)
            ) {
                Text(
                    text = "Name: ${student.name}",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Age: ${student.age}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ScreenAPreview() {
    ScreenAContent(
        ScreenAUiState(
            data = emptyList()
        ),
        openBScreen = {}
    )
}
