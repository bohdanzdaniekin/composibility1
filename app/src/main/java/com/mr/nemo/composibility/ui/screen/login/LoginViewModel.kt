package com.mr.nemo.composibility.ui.screen.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _state = MutableStateFlow(LoginScreenState())
    val state = _state.asStateFlow()

    fun onEvent(event: LoginScreenEvent) {
        when (event) {
            is LoginScreenEvent.OnEmailUpdate -> {
                updateEmail(event.value)
            }
            is LoginScreenEvent.OnPasswordUpdate -> {
                updatePassword(event.value)
            }
        }
    }

    private fun updateEmail(email: String) {
        viewModelScope.launch {
            _state.update { state ->
                state.copy(email = email)
            }
        }
    }

    private fun updatePassword(password: String) {
        viewModelScope.launch {
            _state.update { state ->
                state.copy(password = password)
            }
        }
    }
}
