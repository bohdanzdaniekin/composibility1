package com.mr.nemo.composibility.ui.screen

import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mr.nemo.composibility.R
import com.mr.nemo.composibility.ui.component.SmsCode
import com.mr.nemo.composibility.ui.component.state.rememberSmsCodeState
import com.mr.nemo.composibility.ui.component.text.TitleText
import com.mr.nemo.composibility.ui.theme.ComposibilityTheme

@Composable
fun SmsCodeScreen() {
    val colors = ComposibilityTheme.colors
    val typography = ComposibilityTheme.typography
    Scaffold(
        modifier = Modifier.fillMaxSize()
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
                    text = "Enter confirmation code",
                    style = typography.heading3.copy(
                        color = colors.neutralDarkDarkest
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "A 4-digit code was sent to\nlucasscott3@email.com",
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
                    text = "Resend code",
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
                    onClick = { /*TODO*/ },
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
        SmsCodeScreen()
    }
}
