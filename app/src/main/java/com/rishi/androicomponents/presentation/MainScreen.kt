package com.rishi.androicomponents.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rishi.androicomponents.presentation.viewmodel.MainUiState
import com.rishi.androicomponents.presentation.viewmodel.MainViewModel


@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel(),
) {
    val context = LocalContext.current
    //val uiState by viewModel.uiState.collectAsStateWithLifecycle()
   // MainScreenContent(text = .text)
}


@Composable
fun MainScreenContent(
    text: String
) {
    Column(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = text,
            color = Color.White,
            style = TextStyle(fontWeight = FontWeight.Bold),
            fontSize = 24.sp
        )
    }
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreenContent("Lion")
}