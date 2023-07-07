package com.mr.nemo.composibility.ui.theme.color

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.graphics.Color

@Stable
class ComposibilityColorScheme(
    highlightDarkest: Color,
    highlightDark: Color,
    highlightMedium: Color,
    highlightLight: Color,
    highlightLightest: Color,
    neutralLightDarkest: Color,
    neutralLightDark: Color,
    neutralLightMedium: Color,
    neutralLightLight: Color,
    neutralLightLightest: Color,
    neutralDarkDarkest: Color,
    neutralDarkDark: Color,
    neutralDarkMedium: Color,
    neutralDarkLight: Color,
    neutralDarkLightest: Color
) {

    var highlightDarkest: Color by mutableStateOf(highlightDarkest, structuralEqualityPolicy())
        private set
    var highlightDark: Color by mutableStateOf(highlightDark, structuralEqualityPolicy())
        private set
    var highlightMedium: Color by mutableStateOf(highlightMedium, structuralEqualityPolicy())
        private set
    var highlightLight: Color by mutableStateOf(highlightLight, structuralEqualityPolicy())
        private set
    var highlightLightest: Color by mutableStateOf(highlightLightest, structuralEqualityPolicy())
        private set

    var neutralLightDarkest: Color by mutableStateOf(
        neutralLightDarkest,
        structuralEqualityPolicy()
    )
        private set
    var neutralLightDark: Color by mutableStateOf(neutralLightDark, structuralEqualityPolicy())
        private set
    var neutralLightMedium: Color by mutableStateOf(neutralLightMedium, structuralEqualityPolicy())
        private set
    var neutralLightLight: Color by mutableStateOf(neutralLightLight, structuralEqualityPolicy())
        private set
    var neutralLightLightest: Color by mutableStateOf(
        neutralLightLightest,
        structuralEqualityPolicy()
    )
        private set

    var neutralDarkDarkest: Color by mutableStateOf(neutralDarkDarkest, structuralEqualityPolicy())
        private set
    var neutralDarkDark: Color by mutableStateOf(neutralDarkDark, structuralEqualityPolicy())
        private set
    var neutralDarkMedium: Color by mutableStateOf(neutralDarkMedium, structuralEqualityPolicy())
        private set
    var neutralDarkLight: Color by mutableStateOf(neutralDarkLight, structuralEqualityPolicy())
        private set
    var neutralDarkLightest: Color by mutableStateOf(
        neutralDarkLightest,
        structuralEqualityPolicy()
    )
        private set

    fun updateColorSchemeFrom(other: ComposibilityColorScheme) {
        this.highlightDarkest = other.highlightDarkest
        this.highlightDark = other.highlightDark
        this.highlightMedium = other.highlightMedium
        this.highlightLight = other.highlightLight
        this.highlightLightest = other.highlightLightest
        this.neutralLightDarkest = other.neutralLightDarkest
        this.neutralLightDark = other.neutralLightDark
        this.neutralLightMedium = other.neutralLightMedium
        this.neutralLightLight = other.neutralLightLight
        this.neutralLightLightest = other.neutralLightLightest
        this.neutralDarkDarkest = other.neutralDarkDarkest
        this.neutralDarkDark = other.neutralDarkDark
        this.neutralDarkMedium = other.neutralDarkMedium
        this.neutralDarkLight = other.neutralDarkLight
        this.neutralDarkLightest = other.neutralDarkLightest
    }

    fun copy(
        highlightDarkest: Color = this.highlightDarkest,
        highlightDark: Color = this.highlightDark,
        highlightMedium: Color = this.highlightMedium,
        highlightLight: Color = this.highlightLight,
        highlightLightest: Color = this.highlightLightest,
        neutralLightDarkest: Color = this.neutralLightDarkest,
        neutralLightDark: Color = this.neutralLightDark,
        neutralLightMedium: Color = this.neutralLightMedium,
        neutralLightLight: Color = this.neutralLightLight,
        neutralLightLightest: Color = this.neutralLightLightest,
        neutralDarkDarkest: Color = this.neutralLightDarkest,
        neutralDarkDark: Color = this.neutralLightDark,
        neutralDarkMedium: Color = this.neutralLightMedium,
        neutralDarkLight: Color = this.neutralLightLight,
        neutralDarkLightest: Color = this.neutralLightLightest
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
}

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
