package com.rishi.androicomponents.presentation.other

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun OtherScreen(
    viewModel: OtherViewModel = hiltViewModel()
) {
    OtherContent()
}

@Composable
fun OtherContent(modifier: Modifier = Modifier) {

}

@Composable
fun OtherPreview(modifier: Modifier = Modifier) {
    OtherContent()
}