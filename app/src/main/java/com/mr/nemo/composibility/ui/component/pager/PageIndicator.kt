package com.mr.nemo.composibility.ui.component.pager

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mr.nemo.composibility.ui.theme.ComposibilityTheme

@Composable
fun PageIndicator(
    pageCount: Int,
    currentPage: Int,
    modifier: Modifier = Modifier,
    size: Dp = 8.dp,
    colors: PageIndicatorColors = PageIndicatorDefaults.pageIndicatorColors(),
    shape: Shape = ComposibilityTheme.shapes.round,
    arrangement: Arrangement.Horizontal = Arrangement.Center
) {
    Row(
        modifier = modifier,
        horizontalArrangement = arrangement
    ) {
        repeat(pageCount) { iteration ->
            val color = if (currentPage == iteration) {
                colors.indicatorActive
            } else {
                colors.indicatorInactive
            }
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(shape)
                    .background(color)
                    .size(size)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PageIndicatorRoundPreview() {
    ComposibilityTheme {
        PageIndicator(
            pageCount = 7,
            currentPage = 3,
            shape = ComposibilityTheme.shapes.round
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PageIndicatorSquarePreview() {
    ComposibilityTheme {
        PageIndicator(
            pageCount = 7,
            currentPage = 6,
            shape = CutCornerShape(15),
            arrangement = Arrangement.spacedBy(
                space = 16.dp,
                alignment = Alignment.CenterHorizontally
            )
        )
    }
}
