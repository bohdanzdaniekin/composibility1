package com.mr.nemo.composibility.ui.screen.interests

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.mr.nemo.composibility.R
import com.mr.nemo.composibility.ui.component.text.TitleText
import com.mr.nemo.composibility.ui.theme.ComposibilityTheme
import kotlinx.coroutines.flow.collectLatest

class InterestsScreen : AndroidScreen() {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        val viewModel = viewModel<InterestsViewModel>()
        val state by viewModel.state.collectAsStateWithLifecycle()

        LaunchedEffect(key1 = Unit) {
            viewModel.effect.collectLatest { effect ->
                when (effect) {
                    is InterestsEffect.NavigateForward -> {
                        navigator
                    }
                }
            }
        }

        InterestsScreen(
            state = state,
            onEvent = viewModel::onEvent
        )
    }
}

@Composable
private fun InterestsScreen(
    state: InterestsScreenState,
    onEvent: (InterestsScreenEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = ComposibilityTheme.colors
    val typography = ComposibilityTheme.typography
    Scaffold(
        modifier = modifier
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 24.dp)
        ) {

            Spacer(modifier = Modifier.height(24.dp))

            LinearProgressIndicator(
                progress = state.selectionProgress,
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeight(8.dp),
                color = colors.highlightDarkest,
                trackColor = colors.neutralLightMedium,
                strokeCap = StrokeCap.Round
            )

            Spacer(modifier = Modifier.height(24.dp))

            TitleText(text = stringResource(R.string.personalise_your_experience))

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = stringResource(R.string.choose_your_interests),
                style = typography.bodyM,
                color = colors.neutralDarkLight
            )

            Spacer(modifier = Modifier.height(32.dp))

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
            ) {
                items(items = state.interests, key = Interest::id) { currentItem ->
                    InterestItem(
                        interest = currentItem,
                        onSelectItem = {
                            onEvent(InterestsScreenEvent.OnInterestSelected(currentItem))
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                TextButton(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = ComposibilityTheme.colors.highlightDarkest
                    ),
                    onClick = {
                        onEvent(InterestsScreenEvent.OnNavigateForward)
                    },
                    shape = ComposibilityTheme.shapes.default,
                    modifier = Modifier
                        .fillMaxWidth()
                        .requiredHeight(48.dp)
                ) {
                    Text(text = stringResource(R.string.button_next))
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun InterestItem(
    interest: Interest,
    onSelectItem: () -> Unit,
    modifier: Modifier = Modifier
) {
    val typography = ComposibilityTheme.typography
    val colors = ComposibilityTheme.colors
    val background = if (interest.isSelected) {
        colors.highlightLightest
    } else {
        colors.neutralLightLight
    }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(52.dp)
            .clip(shape = ComposibilityTheme.shapes.default)
            .background(
                color = background,
                shape = ComposibilityTheme.shapes.default
            )
            .clickable { onSelectItem() }
            .then(
                if (interest.isSelected) {
                    Modifier
                } else {
                    Modifier.border(
                        width = 0.5.dp,
                        color = colors.neutralLightDarkest,
                        shape = ComposibilityTheme.shapes.default
                    )
                }
            )
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = interest.title,
            style = typography.bodyM,
            color = colors.neutralDarkDarkest
        )

        if (interest.isSelected) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = null,
                tint = colors.highlightDarkest
            )
        }
    }
}

@Preview
@Composable
fun InterestsScreenPreview() {
    ComposibilityTheme {
        InterestsScreen(
            state = InterestsScreenState(),
            onEvent = {}
        )
    }
}
