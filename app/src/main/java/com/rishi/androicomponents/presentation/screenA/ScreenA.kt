package com.rishi.androicomponents.presentation.screenA

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rishi.androicomponents.R
import com.rishi.androicomponents.navigation.ScreenAActions


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenA(
    viewModel: ScreenAViewModel = hiltViewModel(),
    onAction: (ScreenAActions) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(horizontal = 16.dp),
                title = {},
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow),
                        contentDescription = "backArrow"
                    )
                },
                actions = {

                }
            )
        }
    ) { paddingValues ->
        ScreenAContent(
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
fun ScreenAContent(
    modifier: Modifier = Modifier,
    uiState: ScreenAUiState,
    onEvent: (ScreenAUiEvent) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 24.dp, start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = uiState.name,
            onValueChange = {
                onEvent(ScreenAUiEvent.OnNameChange(it))
            },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = uiState.age,
            onValueChange = {
                onEvent(ScreenAUiEvent.OnAgeChange(it))
            },
            label = { Text("Age") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = uiState.gender,
            onValueChange = {
                onEvent(ScreenAUiEvent.OnGenderChange(it))
            },
            label = { Text("Gender") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            onEvent(ScreenAUiEvent.OnDone)
        }) {
            Text("Go to Next Screen")
        }
    }
}

private fun handleSideEffects(
    effect: ScreenASideEffect,
    onAction: (actions: ScreenAActions) -> Unit,
) {
    when (effect) {
        ScreenASideEffect.None -> {
            // stub
        }

        is ScreenASideEffect.OpenScreenB -> {
            onAction(
                ScreenAActions.OpenScreenB(
                    name = effect.name,
                    age = effect.age,
                    gender = effect.gender
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenAPreview() {
    ScreenAContent(
        uiState = ScreenAUiState(),
        onEvent = {}
    )
}
