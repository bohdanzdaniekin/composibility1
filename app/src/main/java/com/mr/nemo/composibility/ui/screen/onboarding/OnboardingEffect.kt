package com.mr.nemo.composibility.ui.screen.onboarding

import com.mr.nemo.composibility.ui.core.UiEffect
import java.util.UUID

sealed interface OnboardingEffect : UiEffect {

    data class NavigateForward(val id: String = UUID.randomUUID().toString()) : OnboardingEffect

    data class NavigateBackward(val id: String = UUID.randomUUID().toString()) : OnboardingEffect
}
