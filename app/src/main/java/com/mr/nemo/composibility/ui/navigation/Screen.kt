package com.mr.nemo.composibility.ui.navigation

sealed interface Screen {

    val route: String

    object AuthGraph : Screen {

        override val route: String
            get() = Login.route

        object Login : Screen {

            override val route: String
                get() = "login"
        }

        object SignUp : Screen {

            override val route: String
                get() = "sign_up"
        }

        object SmsCode : Screen {

            const val ARGUMENT_EMAIL = "email"

            override val route: String
                get() = "sms_code/{$ARGUMENT_EMAIL}"

            fun route(email: String) = route.replaceFirst("{$ARGUMENT_EMAIL}", email)
        }
    }
}
