package com.rsstudio.fallen.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun HexagonBox() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .drawWithCache {
                // 1) compute center & radius
                val r = size.minDimension / 2f
                val cx = size.width / 2f
                val cy = size.height / 2f

                // 2) build a regular 6-point path
                val hexPath = Path().apply {
                    for (i in 0 until 6) {
                        val angleDeg = 90f + i * 60f         // start at top (90°), then every 60°
                        val rad = Math.toRadians(angleDeg.toDouble())
                        val x = (cx + r * cos(rad)).toFloat()
                        val y = (cy + r * sin(rad)).toFloat()
                        if (i == 0) moveTo(x, y) else lineTo(x, y)
                    }
                    close()
                }

                // precalc paint parameters
                val offsetPx = 4.dp.toPx()
                val stroke1 = Stroke(width = 1.dp.toPx())
                val stroke2 = Stroke(width = 2.dp.toPx())
                val fillColor = Color(0xFFFAEAE0)
                val mainStrokeColor = Color(0xFFECB89E)
                val shadowStrokeColor = mainStrokeColor.copy(alpha = 0.4f)

                onDrawBehind {
                    // a) offset "shadow" stroke
                    withTransform({
                        translate(offsetPx, offsetPx)
                    }) {
                        drawPath(hexPath, color = shadowStrokeColor, style = stroke1)
                    }

                    // b) fill
                    drawPath(hexPath, color = fillColor)

                    // c) main stroke
                    drawPath(hexPath, color = mainStrokeColor, style = stroke2)
                }
            }
    ) {
        // Place your icon here, e.g.:

    }
}



@Preview(showBackground = true)
@Composable
fun Rat() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        HexagonBox()
    }
}
