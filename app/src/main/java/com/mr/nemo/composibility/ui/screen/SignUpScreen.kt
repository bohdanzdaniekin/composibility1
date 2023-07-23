package com.mr.nemo.composibility.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mr.nemo.composibility.R
import com.mr.nemo.composibility.ui.component.Titled
import com.mr.nemo.composibility.ui.component.text.TermsAndPolicy
import com.mr.nemo.composibility.ui.component.text.TitleText
import com.mr.nemo.composibility.ui.component.textfield.PasswordTextField
import com.mr.nemo.composibility.ui.component.textfield.TitledTextField
import com.mr.nemo.composibility.ui.theme.ComposibilityTheme

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    onBackClicked: () -> Unit,
    onContinueClicked: (String) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        modifier = modifier,
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        containerColor = ComposibilityTheme.colors.neutralLightLightest
    ) { paddingValues ->
        var name by remember {
            mutableStateOf("")
        }
        var email by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }
        var confirmPassword by remember {
            mutableStateOf("")
        }
        var isTermsChecked by remember {
            mutableStateOf(false)
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(start = 24.dp, end = 24.dp, top = 24.dp)
        ) {

            TitleText(
                text = "Sign up",
                style = ComposibilityTheme.typography.heading3
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Create an account to get started",
                style = ComposibilityTheme.typography.bodyS,
                color = ComposibilityTheme.colors.neutralDarkLight
            )

            Spacer(modifier = Modifier.height(24.dp))
            TitledTextField(
                title = "Name",
                value = name,
                placeholder = "Enter your wonderful name",
                onValueChange = { value ->
                    name = value
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )

            Spacer(modifier = Modifier.height(16.dp))
            TitledTextField(
                title = "Email address",
                value = email,
                placeholder = "name@email.com",
                onValueChange = { value ->
                    email = value
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                )
            )

            Spacer(modifier = Modifier.height(16.dp))
            Titled(
                title = "Password"
            ) {
                PasswordTextField(
                    password = password,
                    onPasswordValueChange = { value -> password = value },
                    placeholder = stringResource(R.string.create_a_password),
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                PasswordTextField(
                    password = confirmPassword,
                    onPasswordValueChange = { value -> confirmPassword = value },
                    placeholder = stringResource(R.string.confirm_password),
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next
                    )
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Checkbox(
                    checked = isTermsChecked,
                    onCheckedChange = { isChecked ->
                        isTermsChecked = isChecked
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = ComposibilityTheme.colors.highlightDark,
                        uncheckedColor = ComposibilityTheme.colors.neutralLightDarkest
                    )
                )
                TermsAndPolicy(
                    onTermsAndConditionClick = {

                    },
                    onPrivacyPolicyClick = {

                    }
                )
            }

            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.BottomCenter
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    IconButton(onClick = onBackClicked) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null
                        )
                    }
                    TextButton(
                        colors = ButtonDefaults.buttonColors(
                            containerColor = ComposibilityTheme.colors.highlightDarkest
                        ),
                        onClick = { onContinueClicked(email) },
                        shape = ComposibilityTheme.shapes.default,
                        modifier = Modifier
                            .fillMaxWidth()
                            .requiredHeight(48.dp)
                    ) {
                        Text(text = stringResource(R.string.button_continue))
                    }
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    ComposibilityTheme {
        SignUpScreen(
            onBackClicked = {},
            onContinueClicked = {}
        )
    }
}
