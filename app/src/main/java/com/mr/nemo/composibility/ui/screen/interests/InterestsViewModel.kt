package com.mr.nemo.composibility.ui.screen.interests

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class InterestsViewModel : ViewModel() {

    private val _effect = Channel<InterestsEffect>()
    val effect = _effect.receiveAsFlow()

    private val _state = MutableStateFlow(InterestsScreenState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update { state ->
                state.copy(
                    interests = listOf(
                        Interest(title = "MVVM"),
                        Interest(title = "MVI"),
                        Interest(title = "Jetpack compose"),
                        Interest(title = "RxJava/RxKotlin"),
                        Interest(title = "Kotlin coroutines"),
                        Interest(title = "Room"),
                        Interest(title = "Realm"),
                        Interest(title = "Retrofit"),
                        Interest(title = "Ktor"),
                        Interest(title = "WorkManager"),
                        Interest(title = "Navigation component"),
                        Interest(title = "Android View"),
                        Interest(title = "Data binding"),
                        Interest(title = "Dagger/Hilt"),
                        Interest(title = "Koin")
                    )
                )
            }
        }
    }

    fun onEvent(event: InterestsScreenEvent) {
        when (event) {
            is InterestsScreenEvent.OnInterestSelected -> updateSelectedItems(event.item)
            InterestsScreenEvent.OnNavigateForward -> {
                navigateForward()
            }
        }
    }

    private fun updateSelectedItems(interest: Interest) {
        viewModelScope.launch {
            _state.update { state ->
                val selectedCount = state.interests.count(Interest::isSelected)
                if (selectedCount < MAX_SELECTED_INTEREST || interest.isSelected) {
                    updateSelectedState(state, interest)
                } else {
                    state
                }
            }
        }
    }

    private fun updateSelectedState(
        state: InterestsScreenState,
        interest: Interest
    ): InterestsScreenState {
        val interests = state.interests.map { currentInterest ->
            if (interest.id == currentInterest.id) {
                currentInterest.copy(isSelected = !currentInterest.isSelected)
            } else {
                currentInterest
            }
        }
        return state.copy(
            interests = interests,
            selectionProgress = progress(interests)
        )
    }

    private fun progress(interests: List<Interest>) =
        interests.count(Interest::isSelected).toFloat() / MAX_SELECTED_INTEREST.toFloat()

    private fun navigateForward() {
        viewModelScope.launch {
            _effect.send(InterestsEffect.NavigateForward())
        }
    }

    private companion object {

        const val MAX_SELECTED_INTEREST = 4.0
    }
}
