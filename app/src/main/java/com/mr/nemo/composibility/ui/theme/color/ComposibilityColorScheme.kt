package com.mr.nemo.composibility.ui.theme.color

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class ComposibilityColorScheme(
    val highlightDarkest: Color = Color(0xFF006FFD),
    val highlightDark: Color = Color(0xFF2897FF),
    val highlightMedium: Color = Color(0xFF6FBAFF),
    val highlightLight: Color = Color(0xFFB4DBFF),
    val highlightLightest: Color = Color(0xFFEAF2FF),
    val neutralLightDarkest: Color = Color(0xFFC5C6CC),
    val neutralLightDark: Color = Color(0xFFD4D6DD),
    val neutralLightMedium: Color = Color(0xFFE8E9F1),
    val neutralLightLight: Color = Color(0xFFF8F9FE),
    val neutralLightLightest: Color = Color(0xFFFFFFFF),
    val neutralDarkDarkest: Color = Color(0xFF1F2024),
    val neutralDarkDark: Color = Color(0xFF2F3036),
    val neutralDarkMedium: Color = Color(0xFF494A50),
    val neutralDarkLight: Color = Color(0xFF71727A),
    val neutralDarkLightest: Color = Color(0xFF8F9098)
)
