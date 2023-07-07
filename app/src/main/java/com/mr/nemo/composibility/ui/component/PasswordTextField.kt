@file:OptIn(ExperimentalMaterial3Api::class)

package com.mr.nemo.composibility.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.mr.nemo.composibility.R
import com.mr.nemo.composibility.ui.theme.ComposibilityTheme

@Composable
fun PasswordTextField(
    password: String,
    onPasswordValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var isPasswordVisible by remember { mutableStateOf(false) }
    val passwordIcon = if (isPasswordVisible) {
        painterResource(id = R.drawable.ic_visibility)
    } else {
        painterResource(id = R.drawable.ic_visibility_off)
    }
    OutlinedTextField(
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
                    painter = passwordIcon,
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
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        placeholder = {
            Text(
                text = "Password",
                color = ComposibilityTheme.colors.neutralDarkLightest
            )
        },
        label = {
            Text(
                text = "Password",
                color = ComposibilityTheme.colors.neutralDarkLightest
            )
        },
        shape = ComposibilityTheme.shapes.default,
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = ComposibilityTheme.colors.neutralLightDarkest
        )
    )
}
