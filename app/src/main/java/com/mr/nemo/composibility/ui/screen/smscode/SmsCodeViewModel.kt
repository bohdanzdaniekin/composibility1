package com.mr.nemo.composibility.ui.screen.smscode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mr.nemo.composibility.ui.component.state.SmsCodeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SmsCodeViewModel : ViewModel() {

    private val _state = MutableStateFlow(SmsCodeScreenState())
    val state = _state.asStateFlow()

    fun onEvent(event: SmsCodeScreenEvent) {
        when (event) {
            is SmsCodeScreenEvent.OnSmsCodeUpdated -> {
                updateSmsCode(event.value)
            }
        }
    }

    private fun updateSmsCode(smsCode: SmsCodeState) {
        viewModelScope.launch {
            _state.update { state ->
                state.copy(smsCode = smsCode)
            }
        }
    }
}
