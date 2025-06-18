package com.rishi.androicomponents.presentation.screenE

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rishi.androicomponents.R
import com.rishi.androicomponents.navigation.ScreenEActions
import com.rsstudio.fallen.presentation.screenE.ScreenESideEffect
import com.rsstudio.fallen.presentation.screenE.ScreenEUiEvent
import com.rsstudio.fallen.presentation.screenE.ScreenEUiState
import com.rsstudio.fallen.presentation.screenE.ScreenEViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenE(
    viewModel: ScreenEViewModel = hiltViewModel(),
    onAction: (ScreenEActions) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(horizontal = 16.dp),
                title = {},
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow),
                        contentDescription = "backArrow",
                        modifier = Modifier.clickable {
                        }
                    )
                },
                actions = {

                }
            )
        }
    ) { paddingValues ->
        ScreenDContent(
            modifier = Modifier.padding(paddingValues),
            uiState = viewModel.uiState,
            onEvent = viewModel::onEvent
        )
    }

    LaunchedEffect(key1 = viewModel.uiSideEffect) {
        handleSideEffects(
            effect = viewModel.uiSideEffect,
            onAction = onAction,
        )
        viewModel.resetUiSideEffect()
    }
}

@Composable
fun ScreenDContent(
    modifier: Modifier = Modifier,
    uiState: ScreenEUiState,
    onEvent: (ScreenEUiEvent) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 24.dp, start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "YO! I am Screen E",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.size(24.dp))
        Button(onClick = {
            onEvent(ScreenEUiEvent.GoBack)
        }) {
            Text("Go Back to Screen C")
        }
    }
}

private fun handleSideEffects(
    effect: ScreenESideEffect,
    onAction: (actions: ScreenEActions) -> Unit,
) {
    when (effect) {
        is ScreenESideEffect.BackToScreenC -> {
        }

        ScreenESideEffect.None -> {
            // stub
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ScreenDPreview() {
    ScreenDContent(
        uiState = ScreenEUiState(),
        onEvent = {}
    )
}



