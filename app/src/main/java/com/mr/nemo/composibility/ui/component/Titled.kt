package com.mr.nemo.composibility.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.mr.nemo.composibility.ui.theme.ComposibilityTheme

@Composable
fun Titled(
    title: String,
    modifier: Modifier = Modifier,
    titleStyle: TextStyle = ComposibilityTheme.typography.heading5,
    titleColor: Color = ComposibilityTheme.colors.neutralDarkDark,
    content: @Composable () -> Unit
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = titleStyle,
            color = titleColor
        )
        Spacer(modifier = Modifier.height(8.dp))
        content()
    }
}
