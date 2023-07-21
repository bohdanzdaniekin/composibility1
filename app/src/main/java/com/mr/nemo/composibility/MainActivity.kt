package com.mr.nemo.composibility

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mr.nemo.composibility.ui.navigation.Route
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
                NavHost(navController = navController, startDestination = Route.Login.screenName) {
                    composable(route = Route.Login.screenName) {
                        LoginScreen(
                            onSignUpClick = {
                                navController.navigate(Route.SignUp.screenName)
                            }
                        )
                    }
                    composable(route = Route.SignUp.screenName) {
                        SignUpScreen(
                            onBackClicked = {
                                navController.navigateUp()
                            },
                            onContinueClicked = {
                                navController.navigate(Route.SmsCode.screenName)
                            }
                        )
                    }
                    composable(route = Route.SmsCode.screenName) {
                        SmsCodeScreen()
                    }
                }
            }
        }
    }
}
