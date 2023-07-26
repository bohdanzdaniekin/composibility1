package com.mr.nemo.composibility.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bumble.appyx.components.backstack.BackStack
import com.bumble.appyx.components.backstack.BackStackModel
import com.bumble.appyx.components.backstack.ui.fader.BackStackFader
import com.bumble.appyx.navigation.composable.AppyxComponent
import com.bumble.appyx.navigation.modality.BuildContext
import com.bumble.appyx.navigation.node.Node
import com.bumble.appyx.navigation.node.ParentNode
import com.mr.nemo.composibility.ui.screen.login.LoginNode
import com.mr.nemo.composibility.ui.screen.signup.SignUpNode
import com.mr.nemo.composibility.ui.screen.smscode.SmsCodeNode

class RootNode(
    buildContext: BuildContext,
    private val backStack: BackStack<ScreenNode> = BackStack(
        model = BackStackModel(
            initialTarget = ScreenNode.Login,
            savedStateMap = buildContext.savedStateMap,
        ),
        motionController = {
            BackStackFader(it)
        }
    )
) : ParentNode<ScreenNode>(
    appyxComponent = backStack,
    buildContext = buildContext
) {

    @Composable
    override fun View(modifier: Modifier) {
        AppyxComponent(
            modifier = modifier.fillMaxSize(),
            appyxComponent = backStack
        )
    }

    override fun resolve(interactionTarget: ScreenNode, buildContext: BuildContext): Node {
        return when (interactionTarget) {
            ScreenNode.Login -> {
                LoginNode(buildContext, backStack)
            }
            ScreenNode.SignUp -> {
                SignUpNode(buildContext, backStack)
            }
            is ScreenNode.SmsCode -> {
                SmsCodeNode(buildContext, backStack, interactionTarget.email)
            }
        }
    }
}
