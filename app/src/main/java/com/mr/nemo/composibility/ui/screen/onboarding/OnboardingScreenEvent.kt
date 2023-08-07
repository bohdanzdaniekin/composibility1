package com.mr.nemo.composibility.ui.screen.onboarding

import com.mr.nemo.composibility.ui.core.UiEvent

sealed interface OnboardingScreenEvent : UiEvent {

    object OnScrollForward : OnboardingScreenEvent

    object OnScrollBackward : OnboardingScreenEvent

    data class OnCurrentPageUpdated(val page: Int) : OnboardingScreenEvent
}
