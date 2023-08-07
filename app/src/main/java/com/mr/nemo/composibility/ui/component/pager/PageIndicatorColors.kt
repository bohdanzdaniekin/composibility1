package com.mr.nemo.composibility.ui.component.pager

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.mr.nemo.composibility.ui.theme.ComposibilityTheme

@Immutable
data class PageIndicatorColors(
    val indicatorActive: Color,
    val indicatorInactive: Color
)

object PageIndicatorDefaults {

    @Composable
    fun pageIndicatorColors(
        indicatorActive: Color = ComposibilityTheme.colors.highlightDarkest,
        indicatorInactive: Color = ComposibilityTheme.colors.neutralDarkDarkest.copy(alpha = 0.1f)
    ): PageIndicatorColors {
        return PageIndicatorColors(
            indicatorActive = indicatorActive,
            indicatorInactive = indicatorInactive
        )
    }
}
