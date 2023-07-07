package com.mr.nemo.composibility.ui.theme.typography

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle

@Immutable
data class ComposibilityTypography(
    val heading1: TextStyle,
    val heading2: TextStyle,
    val heading3: TextStyle,
    val heading4: TextStyle,
    val heading5: TextStyle,
    val bodyXL: TextStyle,
    val bodyL: TextStyle,
    val bodyM: TextStyle,
    val bodyS: TextStyle,
    val bodyXS: TextStyle,
    val actionL: TextStyle,
    val actionM: TextStyle,
    val actionS: TextStyle,
    val captionM: TextStyle
)
