package com.mr.nemo.composibility.ui.screen.interests

import com.mr.nemo.composibility.ui.core.UiEffect
import java.util.UUID

sealed interface InterestsEffect : UiEffect {

    data class NavigateForward(
        val id: String = UUID.randomUUID().toString()
    ) : InterestsEffect
}
