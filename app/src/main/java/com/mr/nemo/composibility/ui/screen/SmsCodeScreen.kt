package com.mr.nemo.composibility.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mr.nemo.composibility.R
import com.mr.nemo.composibility.ui.component.SmsCode
import com.mr.nemo.composibility.ui.component.state.rememberSmsCodeState
import com.mr.nemo.composibility.ui.component.text.TitleText
import com.mr.nemo.composibility.ui.theme.ComposibilityTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SmsCodeScreen(
    email: String,
    onContinueClick: () -> Unit
) {
    val colors = ComposibilityTheme.colors
    val typography = ComposibilityTheme.typography

    val keyboardManager = LocalSoftwareKeyboardController.current

    val interactionSource = remember { MutableInteractionSource() }
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) { keyboardManager?.hide() }
    ) { paddingValues ->
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                var smsCode by rememberSmsCodeState()
                TitleText(
                    text = stringResource(R.string.enter_confirmation_code),
                    style = typography.heading3.copy(
                        color = colors.neutralDarkDarkest
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = stringResource(R.string.digit_code_sent_to_email, email),
                    style = typography.bodyS.copy(
                        color = colors.neutralDarkLight
                    ),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(40.dp))

                SmsCode(
                    state = smsCode,
                    onStateChanged = { state -> smsCode = state }
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                TitleText(
                    text = stringResource(R.string.resend_code),
                    style = typography.actionM.copy(
                        color = colors.highlightDarkest
                    ),
                    modifier = Modifier
                        .clickable {  }
                )

                Spacer(modifier = Modifier.height(24.dp))

                TextButton(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = ComposibilityTheme.colors.highlightDarkest
                    ),
                    onClick = onContinueClick,
                    shape = ComposibilityTheme.shapes.default,
                    modifier = Modifier
                        .fillMaxWidth()
                        .requiredHeight(48.dp)
                ) {
                    Text(text = stringResource(R.string.button_continue))
                }

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SmsCodeScreenPreview() {
    ComposibilityTheme {
        SmsCodeScreen(
            email = "testemail@gmail.com",
            onContinueClick = {}
        )
    }
}
