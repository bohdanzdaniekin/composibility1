package com.mr.nemo.composibility.ui.component.text

import androidx.annotation.StringRes
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import com.mr.nemo.composibility.ui.theme.ComposibilityTheme

@Composable
fun ComposibilityClickableText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = ComposibilityTheme.typography.actionM,
    color: Color = ComposibilityTheme.colors.highlightDarkest,
    onClick: () -> Unit
) {
    ClickableText(
        text = buildAnnotatedString {
            append(text)
        },
        style = style.copy(color = color),
        modifier = modifier,
        onClick = { onClick() }
    )
}

@Composable
fun ComposibilityClickableText(
    @StringRes text: Int,
    modifier: Modifier = Modifier,
    style: TextStyle = ComposibilityTheme.typography.actionM,
    color: Color = ComposibilityTheme.colors.highlightDarkest,
    onClick: () -> Unit
) {
    ComposibilityClickableText(
        text = stringResource(id = text),
        style = style.copy(color = color),
        modifier = modifier,
        onClick = onClick
    )
}
