package com.mr.nemo.composibility.ui.screen.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class OnboardingViewModel : ViewModel() {

    private val _effect = Channel<OnboardingEffect>()
    val effect = _effect.receiveAsFlow()

    private val _state = MutableStateFlow(OnboardingScreenState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update { state ->
                state.copy(
                    pages = listOf(
                        OnboardingContent(
                            title = "Create a components in just a few minutes",
                            description = "Enjoy these pre-made compose components and worry only about creating the best product ever.",
                            "https://c1.wallpaperflare.com/preview/416/99/712/not-hear-not-see-do-not-speak-funny.jpg"
                        ),
                        OnboardingContent(
                            title = "Abstract your components as much as possible",
                            description = "Use base components and shrink the amount of parameters in composable methods.",
                            "https://c4.wallpaperflare.com/wallpaper/617/645/298/kermit-the-frog-cocaine-1680x1050-animals-frogs-hd-art-wallpaper-preview.jpg"
                        ),
                        OnboardingContent(
                            title = "Say Good Bye to the Android Views",
                            description = "Forget about the pain in the ass while developing beautiful design with Jetpack compose.",
                            "https://c1.wallpaperflare.com/preview/942/622/456/kermit-frog-drink-alcohol.jpg"
                        ),
                    )
                )
            }
        }
    }

    fun onEvent(event: OnboardingScreenEvent) {
        when (event) {
            OnboardingScreenEvent.OnScrollBackward -> {
                viewModelScope.launch {
                    _state.update { state ->
                        if (state.currentPage > 0) {
                            state.copy(
                                currentPage = (state.currentPage - 1).coerceAtLeast(0)
                            )
                        } else {
                            _effect.send(OnboardingEffect.NavigateBackward())
                            state
                        }
                    }
                }
            }
            OnboardingScreenEvent.OnScrollForward -> {
                viewModelScope.launch {
                    _state.update { state ->
                        if (state.currentPage < state.pages.lastIndex) {
                            state.copy(
                                currentPage = state.currentPage + 1
                            )
                        } else {
                            _effect.send(OnboardingEffect.NavigateForward())
                            state
                        }
                    }
                }
            }
            is OnboardingScreenEvent.OnCurrentPageUpdated -> {
                viewModelScope.launch {
                    _state.update { state ->
                        state.copy(currentPage = event.page)
                    }
                }
            }
        }
    }
}
