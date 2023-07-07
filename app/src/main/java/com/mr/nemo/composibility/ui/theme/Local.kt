package com.mr.nemo.composibility.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import com.mr.nemo.composibility.ui.theme.color.composibilityColorScheme
import com.mr.nemo.composibility.ui.theme.shape.ComposibilityShapes
import com.mr.nemo.composibility.ui.theme.typography.ComposibilityTypography

val LocalComposibilityTypography = staticCompositionLocalOf {
    ComposibilityTypography(
        heading1 = TextStyle.Default,
        heading2 = TextStyle.Default,
        heading3 = TextStyle.Default,
        heading4 = TextStyle.Default,
        heading5 = TextStyle.Default,
        bodyXL = TextStyle.Default,
        bodyL = TextStyle.Default,
        bodyM = TextStyle.Default,
        bodyS = TextStyle.Default,
        bodyXS = TextStyle.Default,
        actionL = TextStyle.Default,
        actionM = TextStyle.Default,
        actionS = TextStyle.Default,
        captionM = TextStyle.Default
    )
}

val LocalComposibilityColorScheme = staticCompositionLocalOf { composibilityColorScheme() }

val LocalComposibilityShapes = staticCompositionLocalOf {
    ComposibilityShapes(
        default = RoundedCornerShape(ZeroCornerSize)
    )
}
