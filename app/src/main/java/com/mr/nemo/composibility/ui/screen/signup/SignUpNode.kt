package com.mr.nemo.composibility.ui.screen.signup

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bumble.appyx.components.backstack.BackStack
import com.bumble.appyx.components.backstack.operation.pop
import com.bumble.appyx.components.backstack.operation.push
import com.bumble.appyx.navigation.modality.BuildContext
import com.bumble.appyx.navigation.node.Node
import com.mr.nemo.composibility.ui.navigation.ScreenNode

class SignUpNode(
    buildContext: BuildContext,
    private val backStack: BackStack<ScreenNode>
) : Node(buildContext = buildContext) {

    @Composable
    override fun View(modifier: Modifier) {
        SignUpScreen(
            onBackClicked = {
                backStack.pop()
            },
            onContinueClicked = { email ->
                if (email.isNotBlank()) {
                    backStack.push(ScreenNode.SmsCode(email))
                }
            }
        )
    }
}
