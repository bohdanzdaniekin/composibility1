package com.mr.nemo.composibility.ui.screen.login

import com.mr.nemo.composibility.ui.core.UiEvent

sealed interface LoginScreenEvent : UiEvent {

    data class OnEmailUpdate(val value: String) : LoginScreenEvent

    data class OnPasswordUpdate(val value: String) : LoginScreenEvent
}
