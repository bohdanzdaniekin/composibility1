package com.mr.nemo.composibility.ui.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mr.nemo.composibility.ui.ext.requiredArguments
import com.mr.nemo.composibility.ui.screen.login.LoginScreen
import com.mr.nemo.composibility.ui.screen.signup.SignUpScreen
import com.mr.nemo.composibility.ui.screen.smscode.SmsCodeScreen

fun NavGraphBuilder.authGraph(navController: NavHostController) {
    composable(route = Screen.AuthGraph.Login.route) {
        LoginScreen(
            onSignUpClick = {
                navController.navigate(Screen.AuthGraph.SignUp.route)
            },
            onLoginClick = { email ->
                if (email.isNotBlank()) {
                    navController.navigate(
                        Screen.AuthGraph.SmsCode.route(email = email)
                    )
                }
            },
            onForgotPasswordClick = {}
        )
    }
    composable(route = Screen.AuthGraph.SignUp.route) {
        SignUpScreen(
            onBackClicked = {
                navController.navigateUp()
            },
            onContinueClicked = { email ->
                if (email.isNotBlank()) {
                    navController.navigate(
                        Screen.AuthGraph.SmsCode.route(email = email)
                    )
                }
            }
        )
    }
    composable(
        route = Screen.AuthGraph.SmsCode.route,
        arguments = listOf(
            navArgument(
                name = Screen.AuthGraph.SmsCode.ARGUMENT_EMAIL
            ) {
                type = NavType.StringType
                nullable = false
            }
        )
    ) { backStackEntry ->
        val email = backStackEntry
            .requiredArguments()
            .getString(Screen.AuthGraph.SmsCode.ARGUMENT_EMAIL, "")
        if (!email.isNullOrBlank()) {
            SmsCodeScreen(
                email = email,
                onContinueClick = {
                    navController.navigate(Screen.AuthGraph.Login.route)
                },
                modifier = Modifier
            )
        }
    }
}
