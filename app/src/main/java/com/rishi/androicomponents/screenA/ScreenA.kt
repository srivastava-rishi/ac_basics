package com.rishi.androicomponents.screenA

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel


@Composable
fun ScreenA(
    viewModel: ScreenAViewModel = hiltViewModel()
) {

    ScreenAContent(
        onAEvent = viewModel::onEvent
    )
}

@Composable
fun ScreenAContent(
    onAEvent: (ScreenAEvent) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                onAEvent(ScreenAEvent.OnClickButton)
            }
        ) {
            Text(
                "Hit Api"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenAPreview() {
    ScreenAContent({})
}

