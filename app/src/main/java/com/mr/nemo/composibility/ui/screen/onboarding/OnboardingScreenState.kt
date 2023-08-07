package com.mr.nemo.composibility.ui.screen.onboarding

import com.mr.nemo.composibility.ui.core.UiState

data class OnboardingScreenState(
    val currentPage: Int = 0,
    val pages: List<OnboardingContent> = emptyList()
) : UiState
