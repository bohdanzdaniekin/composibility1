package com.mr.nemo.composibility.ui.screen.signup

import com.mr.nemo.composibility.ui.core.UiState

data class SignUpScreenState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val isTermsChecked: Boolean = false
) : UiState
