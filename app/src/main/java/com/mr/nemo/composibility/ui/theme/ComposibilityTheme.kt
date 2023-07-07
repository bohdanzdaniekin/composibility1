package com.mr.nemo.composibility.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.mr.nemo.composibility.ui.theme.color.ComposibilityColorScheme
import com.mr.nemo.composibility.ui.theme.shape.ComposibilityShapes
import com.mr.nemo.composibility.ui.theme.typography.ComposibilityTypography

object ComposibilityTheme {
    val colors: ComposibilityColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalComposibilityColorScheme.current
    val typography: ComposibilityTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalComposibilityTypography.current
    val shapes: ComposibilityShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalComposibilityShapes.current
}
