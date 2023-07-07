package com.mr.nemo.composibility.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.mr.nemo.composibility.ui.theme.color.composibilityColorScheme
import com.mr.nemo.composibility.ui.theme.shape.ComposibilityShapes
import com.mr.nemo.composibility.ui.theme.typography.Typography

private val ColorScheme = composibilityColorScheme()

@Composable
fun ComposibilityTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val shapes = ComposibilityShapes(
        default = RoundedCornerShape(size = 12.dp),
    )
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = ColorScheme.highlightDarkest.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }
    CompositionLocalProvider(
        LocalComposibilityTypography provides Typography,
        LocalComposibilityColorScheme provides ColorScheme,
        LocalComposibilityShapes provides shapes,
        content = content
    )
}

