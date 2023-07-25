package com.mr.nemo.composibility.ui.screen.smscode

import com.mr.nemo.composibility.ui.component.state.SmsCodeState
import com.mr.nemo.composibility.ui.core.UiState

data class SmsCodeScreenState(
    val smsCode: SmsCodeState = SmsCodeState()
) : UiState
