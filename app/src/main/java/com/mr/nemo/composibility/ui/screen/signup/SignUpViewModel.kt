package com.mr.nemo.composibility.ui.screen.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel() {

    private val _state = MutableStateFlow(SignUpScreenState())
    val state = _state.asStateFlow()

    fun onEvent(event: SignUpScreenEvent) {
        when (event) {
            is SignUpScreenEvent.OnNameUpdate -> {
                updateName(event.value)
            }
            is SignUpScreenEvent.OnEmailUpdate -> {
                updateEmail(event.value)
            }
            is SignUpScreenEvent.OnPasswordUpdate -> {
                updatePassword(event.value)
            }
            is SignUpScreenEvent.OnConfirmPasswordUpdate -> {
                updateConfirmPassword(event.value)
            }
            is SignUpScreenEvent.OnTermsChecked -> {
                updateTermsChecked(event.value)
            }
        }
    }

    private fun updateName(name: String) {
        viewModelScope.launch {
            _state.update { state ->
                state.copy(name = name)
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

    private fun updateConfirmPassword(password: String) {
        viewModelScope.launch {
            _state.update { state ->
                state.copy(confirmPassword = password)
            }
        }
    }

    private fun updateTermsChecked(isChecked: Boolean) {
        viewModelScope.launch {
            _state.update { state ->
                state.copy(isTermsChecked = isChecked)
            }
        }
    }
}
