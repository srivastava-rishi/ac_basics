package com.rishi.androicomponents.presentation.screenC

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rishi.androicomponents.R
import com.rishi.androicomponents.navigation.ScreenCActions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenC(
    viewModel: ScreenCViewModel = hiltViewModel(),
    onAction: (ScreenCActions) -> Unit,
    id: String? = null,
    name: String? = null
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
                            onAction(ScreenCActions.OnBack)
                        }
                    )
                },
                actions = {

                }
            )
        }
    ) { paddingValues ->
        ScreenCContent(
            modifier = Modifier.padding(paddingValues),
            uiState = viewModel.uiState,
            onEvent = viewModel::onEvent
        )
    }

    LaunchedEffect(id) {
        if (!id.isNullOrBlank() && !name.isNullOrBlank()) {
            viewModel.onEvent(ScreenCUiEvent.StudentDataGotBack(name = name, id = id))
        }
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
fun ScreenCContent(
    modifier: Modifier = Modifier,
    uiState: ScreenCUiState,
    onEvent: (ScreenCUiEvent) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 24.dp, start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello, I am Screen C",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        /*
        When User comes back
         */
        if (uiState.id.isNotBlank() && uiState.name.isNotBlank()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column {
                    Text(
                        text = "Name - ${uiState.name}",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue
                    )
                    Text(
                        text = "Id - ${uiState.id}",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue
                    )
                }

            }
        }

        Spacer(Modifier.size(24.dp))
        Button(onClick = {
            onEvent(ScreenCUiEvent.OnClickButton)
        }) {
            Text("Go to Screen D")
        }
    }
}

private fun handleSideEffects(
    effect: ScreenCSideEffect,
    onAction: (actions: ScreenCActions) -> Unit,
) {
    when (effect) {
        ScreenCSideEffect.None -> {
            // stub
        }

        ScreenCSideEffect.OpenScreenD -> {
            onAction(ScreenCActions.OpenScreenD)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ScreenCPreview() {
    ScreenCContent(
        uiState = ScreenCUiState(),
        onEvent = {}
    )
}



