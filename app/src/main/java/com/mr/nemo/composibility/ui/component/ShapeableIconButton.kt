package com.mr.nemo.composibility.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mr.nemo.composibility.R
import com.mr.nemo.composibility.ui.theme.ComposibilityTheme

@Composable
fun ShapeableIconButton(
    painter: Painter,
    contentDescription: String?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = ComposibilityTheme.shapes.default,
    tint: Color = Color.Unspecified,
    border: BorderStroke? = null
) {
    Surface(
        modifier = modifier,
        shape = shape,
        border = border
    ) {
        IconButton(
            onClick = onClick
        ) {
            Icon(
                painter = painter,
                tint = tint,
                contentDescription = contentDescription,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShapeableIconButtonPreview() {
    ComposibilityTheme {
        ShapeableIconButton(
            painter = painterResource(id = R.drawable.ic_button_google),
            shape = ComposibilityTheme.shapes.round,
            contentDescription = "Google",
            onClick = { /*TODO*/ }
        )
    }
}
