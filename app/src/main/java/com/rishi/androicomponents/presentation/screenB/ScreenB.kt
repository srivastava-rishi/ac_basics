package com.rishi.androicomponents.presentation.screenB

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rishi.androicomponents.R
import com.rishi.androicomponents.navigation.ScreenBActions


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenB(
    viewModel: ScreenBViewModel = hiltViewModel(),
    onAction: (ScreenBActions) -> Unit
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
                            onAction(ScreenBActions.OnBack)
                        }
                    )
                },
                actions = {

                }
            )
        }
    ) { paddingValues ->
        ScreenBContent(
            modifier = Modifier.padding(paddingValues),
            uiState = viewModel.uiState,
            onEvent = viewModel::onEvent
        )
    }
}

@Composable
fun ScreenBContent(
    modifier: Modifier = Modifier,
    uiState: ScreenBUiState,
    onEvent: (ScreenBUiEvent) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 24.dp, start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Name - ${uiState.name}"
        )

        Text(
            text = "Age - ${uiState.age}"
        )
        Text(
            text = "Gender - ${uiState.gender}"
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ScreenBPreview() {
    ScreenBContent(
        uiState = ScreenBUiState(),
        onEvent = {}
    )
}

