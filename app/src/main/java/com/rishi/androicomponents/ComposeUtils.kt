package com.rishi.androicomponents

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf

val LocalAnimatedVisibilityScope = compositionLocalOf<AnimatedVisibilityScope> {
    error("No AnimatedVisibilityScope provided")
}

@Composable
fun AnimatedVisibilityScope.WithAnimatedScopeProvider(
    content: @Composable AnimatedVisibilityScope.() -> Unit,
) {
    CompositionLocalProvider(LocalAnimatedVisibilityScope provides this) {
        content()
    }
}