@file:OptIn(ExperimentalMaterial3Api::class)

package com.mr.nemo.composibility.ui.component.textfield

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import com.mr.nemo.composibility.ui.theme.ComposibilityTheme

@Composable
fun ComposibilityTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = ComposibilityTheme.typography.bodyM,
    shape: Shape = ComposibilityTheme.shapes.default,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = ComposibilityTheme.colors.highlightDarkest,
        unfocusedBorderColor = ComposibilityTheme.colors.neutralLightDarkest,
    ),
    placeholder: String? = null,
    placeholderTextColor: Color = ComposibilityTheme.colors.neutralDarkLightest,
    placeholderTextStyle: TextStyle = textStyle,
    label: String? = null,
    labelTextColor: Color = ComposibilityTheme.colors.neutralDarkLightest,
    labelTextStyle: TextStyle = textStyle,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    singleLine: Boolean = true,
    maxLines: Int = 1,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        textStyle = textStyle,
        shape = shape,
        placeholder = if (!placeholder.isNullOrBlank()) {
            Placeholder(placeholder, placeholderTextColor, placeholderTextStyle)
        } else {
            null
        },
        label = if (!label.isNullOrBlank()) {
            Placeholder(label, labelTextColor, labelTextStyle)
        } else {
            null
        },
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        singleLine = singleLine,
        maxLines = maxLines,
        colors = colors,
        isError = isError,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions
    )
}

@Composable
private fun Placeholder(
    text: String,
    color: Color,
    style: TextStyle = LocalTextStyle.current
): @Composable () -> Unit = {
    Text(
        text = text,
        color = color,
        style = style
    )
}
