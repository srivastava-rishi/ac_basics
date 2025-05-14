package com.rishi.androicomponents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ScreenA(
    opeScreenB: () -> Unit
) {
    Scaffold {
        Column(
            modifier = Modifier.padding(it).fillMaxSize().padding(bottom = 24.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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