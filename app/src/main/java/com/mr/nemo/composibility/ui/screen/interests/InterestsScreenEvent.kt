package com.mr.nemo.composibility.ui.screen.interests

import com.mr.nemo.composibility.ui.core.UiEvent

sealed interface InterestsScreenEvent : UiEvent {

    data class OnInterestSelected(val item: Interest) : InterestsScreenEvent

    object OnNavigateForward : InterestsScreenEvent
}
