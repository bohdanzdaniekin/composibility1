package com.mr.nemo.composibility.ui.component.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.mr.nemo.composibility.R
import com.mr.nemo.composibility.ui.theme.ComposibilityTheme

@Composable
fun PasswordTextField(
    password: String,
    onPasswordValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = stringResource(R.string.hint_password),
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Password
    )
) {

    var isPasswordVisible by remember { mutableStateOf(false) }
    val passwordIcon = if (isPasswordVisible) {
        Icons.Default.Visibility
    } else {
        Icons.Default.VisibilityOff
    }
    ComposibilityTextField(
        value = password,
        onValueChange = onPasswordValueChange,
        modifier = modifier.fillMaxWidth(),
        textStyle = ComposibilityTheme.typography.bodyM,
        trailingIcon = {
            IconButton(
                onClick = {
                    isPasswordVisible = !isPasswordVisible
                }
            ) {
                Icon(
                    imageVector = passwordIcon,
                    contentDescription = null,
                    tint = ComposibilityTheme.colors.neutralDarkLightest
                )
            }
        },
        visualTransformation = if (isPasswordVisible) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        keyboardOptions = keyboardOptions.copy(
            keyboardType = KeyboardType.Password
        ),
        placeholder = placeholder,
        shape = ComposibilityTheme.shapes.default,
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = ComposibilityTheme.colors.neutralLightDarkest,
        )
    )
}

@Preview(showBackground = true)
@Composable
fun PasswordTextFieldPreview() {
    ComposibilityTheme {
        PasswordTextField(
            password = "some_password",
            onPasswordValueChange = {}
        )
    }
}
