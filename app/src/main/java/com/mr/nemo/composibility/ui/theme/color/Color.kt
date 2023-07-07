package com.mr.nemo.composibility.ui.theme.color

import androidx.compose.ui.graphics.Color

fun composibilityColorScheme(
    highlightDarkest: Color = Color(0xFF006FFD),
    highlightDark: Color = Color(0xFF2897FF),
    highlightMedium: Color = Color(0xFF6FBAFF),
    highlightLight: Color = Color(0xFFB4DBFF),
    highlightLightest: Color = Color(0xFFEAF2FF),
    neutralLightDarkest: Color = Color(0xFFC5C6CC),
    neutralLightDark: Color = Color(0xFFD4D6DD),
    neutralLightMedium: Color = Color(0xFFE8E9F1),
    neutralLightLight: Color = Color(0xFFF8F9FE),
    neutralLightLightest: Color = Color(0xFFFFFFFF),
    neutralDarkDarkest: Color = Color(0xFF1F2024),
    neutralDarkDark: Color = Color(0xFF2F3036),
    neutralDarkMedium: Color = Color(0xFF494A50),
    neutralDarkLight: Color = Color(0xFF71727A),
    neutralDarkLightest: Color = Color(0xFF8F9098)
): ComposibilityColorScheme {
    return ComposibilityColorScheme(
        highlightDarkest = highlightDarkest,
        highlightDark = highlightDark,
        highlightMedium = highlightMedium,
        highlightLight = highlightLight,
        highlightLightest = highlightLightest,
        neutralLightDarkest = neutralLightDarkest,
        neutralLightDark = neutralLightDark,
        neutralLightMedium = neutralLightMedium,
        neutralLightLight = neutralLightLight,
        neutralLightLightest = neutralLightLightest,
        neutralDarkDarkest = neutralDarkDarkest,
        neutralDarkDark = neutralDarkDark,
        neutralDarkMedium = neutralDarkMedium,
        neutralDarkLight = neutralDarkLight,
        neutralDarkLightest = neutralDarkLightest
    )
}
