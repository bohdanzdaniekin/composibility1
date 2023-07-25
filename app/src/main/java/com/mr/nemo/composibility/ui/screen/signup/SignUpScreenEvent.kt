package com.mr.nemo.composibility.ui.screen.signup

import com.mr.nemo.composibility.ui.core.UiEvent

sealed interface SignUpScreenEvent : UiEvent {

    data class OnNameUpdate(val value: String) : SignUpScreenEvent

    data class OnEmailUpdate(val value: String) : SignUpScreenEvent

    data class OnPasswordUpdate(val value: String) : SignUpScreenEvent

    data class OnConfirmPasswordUpdate(val value: String) : SignUpScreenEvent

    data class OnTermsChecked(val value: Boolean) : SignUpScreenEvent
}
