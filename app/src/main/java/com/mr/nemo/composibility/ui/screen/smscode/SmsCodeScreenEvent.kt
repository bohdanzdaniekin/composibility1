package com.mr.nemo.composibility.ui.screen.smscode

import com.mr.nemo.composibility.ui.component.state.SmsCodeState
import com.mr.nemo.composibility.ui.core.UiEvent

sealed interface SmsCodeScreenEvent : UiEvent {

    data class OnSmsCodeUpdated(val value: SmsCodeState) : SmsCodeScreenEvent
}
