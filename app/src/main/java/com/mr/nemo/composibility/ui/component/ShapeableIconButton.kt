package com.mr.nemo.composibility.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.mr.nemo.composibility.R
import com.mr.nemo.composibility.ui.theme.ComposibilityTheme

@Composable
fun ShapeableIconButton(
    painter: Painter,
    shape: Shape,
    contentDescription: String?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Box(
        modifier = modifier.clip(shape)
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
