package com.mr.nemo.composibility.ui.screen.interests

import com.mr.nemo.composibility.ui.core.UiState

data class InterestsScreenState(
    val interests: List<Interest> = emptyList(),
    val selectionProgress: Float = 0.0f
) : UiState
