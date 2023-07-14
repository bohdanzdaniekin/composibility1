package com.mr.nemo.composibility.ui.component.text

import androidx.annotation.StringRes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.mr.nemo.composibility.ui.theme.ComposibilityTheme

@Composable
fun TitleText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = ComposibilityTheme.typography.heading1
) {
    Text(
        text = text,
        modifier = modifier,
        style = style
    )
}

@Composable
fun TitleText(
    @StringRes text: Int,
    modifier: Modifier = Modifier,
    style: TextStyle = ComposibilityTheme.typography.heading1
) {
    TitleText(
        text = stringResource(id = text),
        modifier = modifier,
        style = style
    )
}

@Preview(showBackground = true)
@Composable
fun TitleTextPreview() {
    ComposibilityTheme {
        TitleText(text = "Preview")
    }
}
