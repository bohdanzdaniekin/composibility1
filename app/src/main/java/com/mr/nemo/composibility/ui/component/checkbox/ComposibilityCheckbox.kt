package com.mr.nemo.composibility.ui.component.checkbox

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.IconToggleButtonColors
import androidx.compose.material3.OutlinedIconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mr.nemo.composibility.ui.theme.ComposibilityTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ComposibilityCheckbox(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: IconToggleButtonColors = IconButtonDefaults.outlinedIconToggleButtonColors(
        containerColor = ComposibilityTheme.colors.neutralLightLightest,
        contentColor = ComposibilityTheme.colors.neutralLightLightest,
        checkedContainerColor = ComposibilityTheme.colors.highlightDarkest,
        checkedContentColor = ComposibilityTheme.colors.neutralLightLightest
    ),
    shape: Shape = ComposibilityTheme.shapes.checkbox,
    border: BorderStroke? = rememberCheckboxBorderColor(enabled = enabled, isChecked = isChecked),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    OutlinedIconToggleButton(
        checked = isChecked,
        onCheckedChange = onCheckedChange,
        modifier = modifier,
        shape = shape,
        border = border,
        colors = colors,
        interactionSource = interactionSource
    ) {
        AnimatedVisibility(
            visible = isChecked,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp)
            )
        }
    }
}

@Composable
fun rememberCheckboxBorderColor(
    enabled: Boolean,
    isChecked: Boolean,
    color: Color = ComposibilityTheme.colors.neutralLightDarkest,
    width: Dp = 1.dp,
    disabledOpacity: Float = 0.12f
): BorderStroke? {
    if (isChecked) {
        return null
    }
    return rememberCheckboxBorderColor(enabled, color, width, disabledOpacity)
}

@Composable
fun rememberCheckboxBorderColor(
    enabled: Boolean,
    color: Color = ComposibilityTheme.colors.neutralLightDarkest,
    width: Dp = 1.dp,
    disabledOpacity: Float = 0.12f
): BorderStroke {
    val borderColor: Color = if (enabled) {
        color
    } else {
        color.copy(alpha = disabledOpacity)
    }
    return remember(borderColor) {
        BorderStroke(width, borderColor)
    }
}

@Preview(showBackground = true)
@Composable
fun ComposibilityCheckboxPreviewChecked() {
    ComposibilityTheme {
        ComposibilityCheckbox(
            isChecked = true,
            onCheckedChange = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComposibilityCheckboxPreviewNotChecked() {
    ComposibilityTheme {
        ComposibilityCheckbox(
            isChecked = false,
            onCheckedChange = {}
        )
    }
}
