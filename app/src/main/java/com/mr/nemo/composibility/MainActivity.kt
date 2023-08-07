package com.mr.nemo.composibility

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cafe.adriel.voyager.navigator.Navigator
import com.mr.nemo.composibility.ui.screen.login.LoginScreen
import com.mr.nemo.composibility.ui.screen.onboarding.OnboardingScreen
import com.mr.nemo.composibility.ui.theme.ComposibilityTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposibilityTheme {
                Navigator(
                    screen = LoginScreen(),
                    onBackPressed = { screen ->
                        when (screen) {
                            is OnboardingScreen -> false
                            else -> true
                        }
                    }
                )
            }
        }
    }
}
