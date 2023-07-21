package com.mr.nemo.composibility.ui.navigation

sealed class Route(open val screenName: String) {
    object Login : Route("login")
    object SignUp : Route("sign_up")
    object SmsCode : Route("sms_code")
}
