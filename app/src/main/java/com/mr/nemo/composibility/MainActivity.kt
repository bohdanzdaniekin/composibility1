@file:OptIn(ExperimentalMaterial3Api::class)

package com.mr.nemo.composibility

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mr.nemo.composibility.ui.component.PasswordTextField
import com.mr.nemo.composibility.ui.theme.ComposibilityTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposibilityTheme {
                var email by rememberSaveable {
                    mutableStateOf("")
                }
                var password by rememberSaveable {
                    mutableStateOf("")
                }
                LoginScreen(
                    email = email,
                    onEmailValueChange = { email = it },
                    password = password,
                    onPasswordValueChange = { password = it }
                )
            }
        }
    }
}

@Composable
fun LoginScreen(
    email: String,
    onEmailValueChange: (String) -> Unit,
    password: String,
    onPasswordValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    Surface(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        color = ComposibilityTheme.colors.neutralLightLightest,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.bg_login_page),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp),
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Welcome!",
                style = ComposibilityTheme.typography.heading1
            )
            Spacer(Modifier.height(24.dp))
            OutlinedTextField(
                value = email,
                onValueChange = onEmailValueChange,
                modifier = Modifier.fillMaxWidth(),
                textStyle = ComposibilityTheme.typography.bodyM,
                shape = ComposibilityTheme.shapes.default,
                placeholder = {
                    Text(
                        text = "Email Address",
                        color = ComposibilityTheme.colors.neutralDarkLightest
                    )
                },
                singleLine = true,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = ComposibilityTheme.colors.neutralLightDarkest
                )
            )
            Spacer(Modifier.height(16.dp))
            PasswordTextField(
                password = password,
                onPasswordValueChange = onPasswordValueChange
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = "Forgot password?",
                style = ComposibilityTheme.typography.actionM,
                color = ComposibilityTheme.colors.highlightDarkest
            )
            Spacer(modifier = Modifier.height(24.dp))
            TextButton(
                colors = ButtonDefaults.buttonColors(
                    containerColor = ComposibilityTheme.colors.highlightDarkest
                ),
                onClick = { /*TODO*/ },
                shape = ComposibilityTheme.shapes.default,
                modifier = Modifier
                    .requiredHeight(48.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Login")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { },
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Not a member? ",
                    style = ComposibilityTheme.typography.bodyS,
                    color = ComposibilityTheme.colors.neutralDarkLight
                )
                Text(
                    text = "Register now",
                    style = ComposibilityTheme.typography.actionM,
                    color = ComposibilityTheme.colors.highlightDarkest
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            Divider()
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Or continue with",
                    style = ComposibilityTheme.typography.bodyS,
                    color = ComposibilityTheme.colors.neutralDarkLight
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_button_google),
                        tint = Color.Unspecified,
                        contentDescription = "Google"
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_button_apple),
                        tint = Color.Unspecified,
                        contentDescription = "Apple"
                    )
                }
                IconButton(
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_button_facebook),
                        tint = Color.Unspecified,
                        contentDescription = "Facebook"
                    )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    ComposibilityTheme {
        LoginScreen(
            email = "",
            onEmailValueChange = {},
            password = "",
            onPasswordValueChange = {}
        )
    }
}
