package com.mr.nemo.composibility.ui.screen.smscode

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bumble.appyx.components.backstack.BackStack
import com.bumble.appyx.components.backstack.operation.push
import com.bumble.appyx.navigation.modality.BuildContext
import com.bumble.appyx.navigation.node.Node
import com.mr.nemo.composibility.ui.navigation.ScreenNode

class SmsCodeNode(
    buildContext: BuildContext,
    private val backStack: BackStack<ScreenNode>,
    private val email: String
): Node(buildContext = buildContext) {

    @Composable
    override fun View(modifier: Modifier) {
        SmsCodeScreen(
            email = email,
            onContinueClick = {
                backStack.push(ScreenNode.Login)
            },
            modifier = Modifier
        )
    }
}
