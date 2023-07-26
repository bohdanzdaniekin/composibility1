package com.mr.nemo.composibility.ui.navigation

import com.bumble.appyx.interactions.Parcelable
import kotlinx.parcelize.Parcelize

sealed class ScreenNode : Parcelable {
    @Parcelize
    object Login : ScreenNode()

    @Parcelize
    object SignUp : ScreenNode()

    @Parcelize
    data class SmsCode(val email: String) : ScreenNode()
}
