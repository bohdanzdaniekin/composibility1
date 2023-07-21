package com.mr.nemo.composibility.ui.component.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.mr.nemo.composibility.ui.component.Titled
import com.mr.nemo.composibility.ui.theme.ComposibilityTheme

@Composable
fun TitledTextField(
    title: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    titleStyle: TextStyle = ComposibilityTheme.typography.heading5,
    titleColor: Color = ComposibilityTheme.colors.neutralDarkDark,
    textStyle: TextStyle = ComposibilityTheme.typography.bodyM,
    shape: Shape = ComposibilityTheme.shapes.default,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = ComposibilityTheme.colors.highlightDarkest,
        unfocusedBorderColor = ComposibilityTheme.colors.neutralLightDarkest,
    ),
    placeholder: String? = null,
    placeholderTextColor: Color = ComposibilityTheme.colors.neutralDarkLightest,
    placeholderTextStyle: TextStyle = textStyle,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    singleLine: Boolean = true,
    maxLines: Int = 1,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default
) {
    Titled(
        title = title,
        modifier = modifier,
        titleStyle = titleStyle,
        titleColor = titleColor
    ) {
        ComposibilityTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            textStyle = textStyle,
            shape = shape,
            placeholder = placeholder,
            placeholderTextColor = placeholderTextColor,
            placeholderTextStyle = placeholderTextStyle,
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
}

@Preview(showBackground = true)
@Composable
fun LabeledTextFieldPreview() {
    ComposibilityTheme {
        TitledTextField(
            title = "Some title",
            value = "Some value",
            onValueChange = {}
        )
    }
}
