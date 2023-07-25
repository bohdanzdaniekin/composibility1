package com.mr.nemo.composibility

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.mr.nemo.composibility.ui.navigation.Screen
import com.mr.nemo.composibility.ui.navigation.authGraph
import com.mr.nemo.composibility.ui.theme.ComposibilityTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposibilityTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screen.AuthGraph.route) {
                    authGraph(navController)
                }
            }
        }
    }
}
