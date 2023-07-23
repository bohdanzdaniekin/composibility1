package com.mr.nemo.composibility

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mr.nemo.composibility.ui.navigation.Screen
import com.mr.nemo.composibility.ui.screen.LoginScreen
import com.mr.nemo.composibility.ui.screen.SignUpScreen
import com.mr.nemo.composibility.ui.screen.SmsCodeScreen
import com.mr.nemo.composibility.ui.theme.ComposibilityTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposibilityTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screen.Login.route) {
                    composable(route = Screen.Login.route) {
                        LoginScreen(
                            onSignUpClick = {
                                navController.navigate(Screen.SignUp.route)
                            },
                            onLoginClick = { email ->
                                if (email.isNotBlank()) {
                                    navController.navigate(
                                        Screen.SmsCode.route(email = email)
                                    )
                                }
                            },
                            onForgotPasswordClick = {}
                        )
                    }
                    composable(route = Screen.SignUp.route) {
                        SignUpScreen(
                            onBackClicked = {
                                navController.navigateUp()
                            },
                            onContinueClicked = { email ->
                                if (email.isNotBlank()) {
                                    navController.navigate(
                                        Screen.SmsCode.route(email = email)
                                    )
                                }
                            }
                        )
                    }
                    composable(route = Screen.SmsCode.route) { backStackEntry ->
                        val email = backStackEntry.arguments?.getString(Screen.SmsCode.EMAIL)
                        if (!email.isNullOrBlank()) {
                            SmsCodeScreen(
                                email = email,
                                onContinueClick = {
                                    navController.navigate(Screen.Login.route)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
