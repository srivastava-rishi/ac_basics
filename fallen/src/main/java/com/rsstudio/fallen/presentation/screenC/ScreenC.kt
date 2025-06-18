package com.rsstudio.fallen.presentation.screenC

import android.util.Log
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.rsstudio.fallen.R
import com.rsstudio.fallen.navigation.ScreenCActions


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenC(
    navController: NavController,
    viewModel: ScreenCViewModel = hiltViewModel(),
    onAction: (ScreenCActions) -> Unit
) {

    LaunchedEffect(Unit) {
        Log.d("lion223", "ScreenC:  ${navController.currentBackStackEntry}")
    }

    val backStackEntry by navController.currentBackStackEntryAsState()

    LaunchedEffect(backStackEntry) {
        Log.d("lion223", "ScreenC: previous = ${navController.previousBackStackEntry}")
        Log.d("lion223", "ScreenC: current = ${navController.currentBackStackEntry}")
    }


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
            text = "YO! I am Screen C on Fallen Module",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ScreenBPreview() {
    ScreenCContent(
        uiState = ScreenCUiState(),
        onEvent = {}
    )
}

