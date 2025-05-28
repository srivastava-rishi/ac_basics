package com.rishi.androicomponents.presentation.screena

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rishi.androicomponents.R
import dagger.hilt.android.lifecycle.HiltViewModel


@Composable
fun ScreenA(
    viewModel: ScreenAViewModel = hiltViewModel(),
    opeScreenB: () -> Unit
) {
    Scaffold {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val onValueChange = remember {
                { it: TextFieldValue ->
                    viewModel.onEvent(ScreenAEvent.FirstNameTextChanged(it))
                }
            }

            OutlinedTextField(
                value = viewModel.uiState.firstName,
                onValueChange = onValueChange,
                placeholder = { Text("Enter Your Name", fontSize = 16.sp) },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0xFFE0E0E0),
                    focusedBorderColor = MaterialTheme.colorScheme.primary
                )
            )
            Spacer(Modifier.size(24.dp))
            Box(
                modifier = Modifier
                    .width(149.dp)
                    .height(56.dp)
                    .background(Color.Black, RoundedCornerShape(40.dp))
                    .clip(RoundedCornerShape(40.dp))
                    .clickable {
                        opeScreenB()
                    },
                contentAlignment = Alignment.Center
            ) {
                Row {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(R.drawable.ic_scan_and_pay),
                        tint = Color.White,
                        contentDescription = ""
                    )
                    Text(
                        text = "Scan & Pay",
                        fontSize = 14.sp,
                        color = Color.White,
                    )
                }
            }
        }
    }
}