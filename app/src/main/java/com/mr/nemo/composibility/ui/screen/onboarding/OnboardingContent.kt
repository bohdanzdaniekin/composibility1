package com.mr.nemo.composibility.ui.screen.onboarding

import androidx.compose.runtime.Immutable

@Immutable
data class OnboardingContent(
    val title: String,
    val description: String,
    val imageUrl: String
)
