package com.mr.nemo.composibility.ui.screen.login

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bumble.appyx.components.backstack.BackStack
import com.bumble.appyx.components.backstack.operation.push
import com.bumble.appyx.navigation.modality.BuildContext
import com.bumble.appyx.navigation.node.Node
import com.mr.nemo.composibility.ui.navigation.ScreenNode

class LoginNode(
    buildContext: BuildContext,
    private val backStack: BackStack<ScreenNode>
) : Node(buildContext = buildContext) {

    @Composable
    override fun View(modifier: Modifier) {
        LoginScreen(
            onSignUpClick = {
                backStack.push(ScreenNode.SignUp)
            },
            onLoginClick = { email ->
                if (email.isNotBlank()) {
                    backStack.push(ScreenNode.SmsCode(email))
                }
            },
            onForgotPasswordClick = {},
            modifier = modifier
        )
    }
}
