@file:OptIn(ExperimentalFoundationApi::class)

package com.mr.nemo.composibility.ui.screen.onboarding

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import coil.compose.rememberAsyncImagePainter
import com.mr.nemo.composibility.ui.ext.offsetForPage
import com.mr.nemo.composibility.ui.screen.interests.InterestsScreen
import com.mr.nemo.composibility.ui.screen.login.LoginScreen
import com.mr.nemo.composibility.ui.theme.ComposibilityTheme
import kotlinx.coroutines.flow.collectLatest
import kotlin.math.absoluteValue

class OnboardingScreen : AndroidScreen() {

    @Composable
    override fun Content() {
        val lifecycle = LocalLifecycleOwner.current.lifecycle
        val navigator = LocalNavigator.currentOrThrow

        val viewModel = viewModel<OnboardingViewModel>()
        val state by viewModel.state.collectAsStateWithLifecycle()

        LaunchedEffect(lifecycle) {
            viewModel.effect.flowWithLifecycle(lifecycle).collectLatest { effect ->
                when (effect) {
                    is OnboardingEffect.NavigateForward -> {
                        navigator.push(InterestsScreen())
                    }
                    is OnboardingEffect.NavigateBackward -> {
                        navigator.popUntil { screen -> screen is LoginScreen }
                    }
                }
            }
        }

        val pagerState = rememberPagerState {
            state.pages.size
        }
        LaunchedEffect(lifecycle) {
            snapshotFlow { state.currentPage }
                .flowWithLifecycle(lifecycle)
                .collectLatest { currentPage ->
                    if (currentPage != pagerState.currentPage) {
                        pagerState.animateScrollToPage(
                            currentPage,
                            pagerState.currentPageOffsetFraction,
                        )
                    }
                }
        }
        LaunchedEffect(lifecycle) {
            snapshotFlow(pagerState::currentPage)
                .flowWithLifecycle(lifecycle)
                .collect { page ->
                    viewModel.onEvent(OnboardingScreenEvent.OnCurrentPageUpdated(page))
                }
        }

        OnboardingScreen(
            state = state,
            pagerState = pagerState,
            onEvent = viewModel::onEvent
        )
    }
}

@Composable
private fun OnboardingScreen(
    state: OnboardingScreenState,
    onEvent: (OnboardingScreenEvent) -> Unit,
    modifier: Modifier = Modifier,
    pagerState: PagerState = rememberPagerState {
        state.pages.size
    }
) {
    BackHandler {
        onEvent(OnboardingScreenEvent.OnScrollBackward)
    }
    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { paddingValues ->
        HorizontalPager(
            modifier = Modifier,
            state = pagerState,
            contentPadding = paddingValues
        ) { page ->
            val content = state.pages[page]
            OnboardingPage(
                title = content.title,
                description = content.description,
                image = rememberAsyncImagePainter(model = content.imageUrl),
                pageCount = state.pages.size,
                currentPage = page,
                onNextClicked = {
                    onEvent(OnboardingScreenEvent.OnScrollForward)
                },
                onBackClicked = {
                    onEvent(OnboardingScreenEvent.OnScrollBackward)
                },
                modifier = Modifier.graphicsLayer {
                    val pageOffset = pagerState.offsetForPage(page)
                    translationX = pageOffset * size.width
                    alpha = 1 - pageOffset.absoluteValue
                }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun OnboardingScreenPreview() {
    ComposibilityTheme {
        OnboardingScreen(
            state = OnboardingScreenState(),
            onEvent = {}
        )
    }
}
