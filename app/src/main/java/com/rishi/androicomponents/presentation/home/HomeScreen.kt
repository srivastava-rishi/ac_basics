package com.rishi.androicomponents.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    HomeContent(
        viewModel.uiState,
        viewModel::onEvents
    )
}


@Composable
fun HomeContent(
    uiState: HomeUiState,
    onEvents: (HomeScreenEvents) -> Unit
) {
    Column(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = uiState.text,
            color = Color.White,
            style = TextStyle(fontWeight = FontWeight.Bold),
            fontSize = 24.sp
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            ),
            onClick = {
                onEvents(HomeScreenEvents.StartCounter)
            }
        ) {
            Text(
                text = if (uiState.counterStarted) "Stop" else "Start",
                color = Color.Black,
                style = TextStyle(fontWeight = FontWeight.Bold),
                fontSize = 14.sp
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeContent(
        uiState = HomeUiState(

        ),
        onEvents = {

        }
    )
}