package com.mr.nemo.composibility

import android.os.Bundle
import androidx.activity.compose.setContent
import com.bumble.appyx.navigation.integration.NodeHost
import com.bumble.appyx.navigation.integrationpoint.NodeComponentActivity
import com.mr.nemo.composibility.ui.navigation.RootNode
import com.mr.nemo.composibility.ui.theme.ComposibilityTheme

class MainActivity : NodeComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposibilityTheme {
                NodeHost(integrationPoint = appyxV2IntegrationPoint) { buildContext ->
                    RootNode(buildContext)
                }
            }
        }
    }
}

