package com.mr.nemo.composibility.ui.navigation

sealed interface Screen {

    val route: String

    object Login : Screen {

        override val route: String
            get() = "login"
    }

    object SignUp : Screen {

        override val route: String
            get() = "sign_up"
    }

    object SmsCode : Screen {

        const val EMAIL = "email"

        override val route: String
            get() = "sms_code/{email}"

        fun route(email: String) = route.replaceFirst("{email}", email)
    }
}
