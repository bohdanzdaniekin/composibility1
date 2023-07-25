package com.mr.nemo.composibility.ui.screen.signup

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.mr.nemo.composibility.ui.component.checkbox.ComposibilityCheckbox
import com.mr.nemo.composibility.ui.component.Titled
import com.mr.nemo.composibility.ui.component.text.TermsAndPolicy
import com.mr.nemo.composibility.ui.component.text.TitleText
import com.mr.nemo.composibility.ui.component.textfield.PasswordTextField
import com.mr.nemo.composibility.ui.component.textfield.TitledTextField
import com.mr.nemo.composibility.ui.screen.smscode.SmsCodeScreen
import com.mr.nemo.composibility.ui.theme.ComposibilityTheme

class SignUpScreen : AndroidScreen() {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = viewModel<SignUpViewModel>()
        val state by viewModel.state.collectAsStateWithLifecycle()
        SignUpScreen(
            state = state,
            onEvent = viewModel::onEvent,
            onBackClicked = {
                navigator.pop()
            },
            onContinueClicked = {
                navigator.push(SmsCodeScreen(state.email))
            },
        )
    }
}

@Composable
private fun SignUpScreen(
    state: SignUpScreenState,
    onEvent: (SignUpScreenEvent) -> Unit,
    onBackClicked: () -> Unit,
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(start = 24.dp, end = 24.dp, top = 24.dp)
        ) {

            TitleText(
                text = stringResource(R.string.sign_up),
                style = ComposibilityTheme.typography.heading3
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(R.string.create_an_account_to_get_started),
                style = ComposibilityTheme.typography.bodyS,
                color = ComposibilityTheme.colors.neutralDarkLight
            )

            Spacer(modifier = Modifier.height(24.dp))
            TitledTextField(
                title = stringResource(R.string.name),
                value = state.name,
                placeholder = stringResource(R.string.placeholder_name),
                onValueChange = { value ->
                    onEvent(SignUpScreenEvent.OnNameUpdate(value))
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )

            Spacer(modifier = Modifier.height(16.dp))
            TitledTextField(
                title = stringResource(id = R.string.email_address),
                value = state.email,
                placeholder = stringResource(R.string.placehlder_email),
                onValueChange = { value ->
                    onEvent(SignUpScreenEvent.OnEmailUpdate(value))
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
                    password = state.password,
                    onPasswordValueChange = { value ->
                        onEvent(SignUpScreenEvent.OnPasswordUpdate(value))
                    },
                    placeholder = stringResource(R.string.create_a_password),
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                PasswordTextField(
                    password = state.confirmPassword,
                    onPasswordValueChange = { value ->
                        onEvent(SignUpScreenEvent.OnConfirmPasswordUpdate(value))
                    },
                    placeholder = stringResource(R.string.confirm_password),
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done
                    )
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                ComposibilityCheckbox(
                    isChecked = state.isTermsChecked,
                    onCheckedChange = { isChecked ->
                        onEvent(SignUpScreenEvent.OnTermsChecked(isChecked))
                    },
                    modifier = Modifier.size(24.dp)
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
                        onClick = onContinueClicked,
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpScreenPreview() {
    ComposibilityTheme {
        SignUpScreen(
            onBackClicked = {},
            onContinueClicked = {},
            state = SignUpScreenState(),
            onEvent = {}
        )
    }
}
