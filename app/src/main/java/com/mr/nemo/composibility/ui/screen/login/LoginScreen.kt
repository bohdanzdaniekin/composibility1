package com.mr.nemo.composibility.ui.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.mr.nemo.composibility.R
import com.mr.nemo.composibility.ui.component.ShapeableIconButton
import com.mr.nemo.composibility.ui.component.text.ComposibilityClickableText
import com.mr.nemo.composibility.ui.component.text.TitleText
import com.mr.nemo.composibility.ui.component.textfield.ComposibilityTextField
import com.mr.nemo.composibility.ui.component.textfield.PasswordTextField
import com.mr.nemo.composibility.ui.screen.signup.SignUpScreen
import com.mr.nemo.composibility.ui.screen.smscode.SmsCodeScreen
import com.mr.nemo.composibility.ui.theme.ComposibilityTheme

class LoginScreen : AndroidScreen() {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = viewModel<LoginViewModel>()
        val state by viewModel.state.collectAsStateWithLifecycle()
        LoginScreen(
            state = state,
            onEvent = viewModel::onEvent,
            onSignUpClick = {
                navigator.push(SignUpScreen())
            },
            onLoginClick = {
                navigator.push(SmsCodeScreen(state.email))
            },
            onForgotPasswordClick = { }
        )
    }
}

@Composable
private fun LoginScreen(
    state: LoginScreenState,
    onEvent: (LoginScreenEvent) -> Unit,
    onSignUpClick: () -> Unit,
    onLoginClick: () -> Unit,
    onForgotPasswordClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        modifier = modifier,
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        containerColor = ComposibilityTheme.colors.neutralLightLightest
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(scrollState)
        ) {
            Image(
                painter = painterResource(id = R.drawable.bg_login_page),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                TitleText(
                    text = R.string.welcome
                )

                Spacer(Modifier.height(24.dp))
                ComposibilityTextField(
                    value = state.email,
                    onValueChange = { value ->
                        onEvent(LoginScreenEvent.OnEmailUpdate(value))
                    },
                    modifier = Modifier.fillMaxWidth(),
                    textStyle = ComposibilityTheme.typography.bodyM,
                    placeholder = stringResource(R.string.email_address),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                )

                Spacer(Modifier.height(16.dp))
                PasswordTextField(
                    password = state.password,
                    onPasswordValueChange = { value ->
                        onEvent(LoginScreenEvent.OnPasswordUpdate(value))
                    }
                )

                Spacer(Modifier.height(16.dp))
                ComposibilityClickableText(
                    text = R.string.forgot_password,
                    style = ComposibilityTheme.typography.actionM,
                    onClick = onForgotPasswordClick
                )

                Spacer(modifier = Modifier.height(24.dp))
                TextButton(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = ComposibilityTheme.colors.highlightDarkest
                    ),
                    onClick = { onLoginClick() },
                    shape = ComposibilityTheme.shapes.default,
                    modifier = Modifier
                        .fillMaxWidth()
                        .requiredHeight(48.dp)
                ) {
                    Text(text = stringResource(R.string.login))
                }

                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(R.string.not_a_member),
                        style = ComposibilityTheme.typography.bodyS,
                        color = ComposibilityTheme.colors.neutralDarkLight
                    )
                    ComposibilityClickableText(
                        text = R.string.register_now,
                        style = ComposibilityTheme.typography.actionM,
                        onClick = onSignUpClick
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))
                Divider(color = ComposibilityTheme.colors.neutralLightDark)

                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(R.string.or_continue_with),
                        style = ComposibilityTheme.typography.bodyS,
                        color = ComposibilityTheme.colors.neutralDarkLight
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterHorizontally)
                ) {
                    ShapeableIconButton(
                        painter = painterResource(id = R.drawable.ic_button_google),
                        shape = ComposibilityTheme.shapes.round,
                        contentDescription = "Google",
                        onClick = { /*TODO*/ }
                    )
                    ShapeableIconButton(
                        painter = painterResource(id = R.drawable.ic_button_apple),
                        shape = ComposibilityTheme.shapes.round,
                        contentDescription = "Apple",
                        onClick = { /*TODO*/ }
                    )
                    ShapeableIconButton(
                        painter = painterResource(id = R.drawable.ic_button_facebook),
                        shape = ComposibilityTheme.shapes.round,
                        contentDescription = "Facebook",
                        onClick = { /*TODO*/ }
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LoginScreenPreview() {
    ComposibilityTheme {
        LoginScreen(
            onSignUpClick = {},
            onForgotPasswordClick = {},
            onLoginClick = {},
            state = LoginScreenState(),
            onEvent = {}
        )
    }
}
