package com.mr.nemo.composibility.ui.screen.login

import com.mr.nemo.composibility.ui.core.UiState

data class LoginScreenState(
    val email: String = "",
    val password: String = ""
) : UiState
