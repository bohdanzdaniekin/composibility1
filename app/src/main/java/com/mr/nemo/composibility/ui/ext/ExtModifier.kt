package com.mr.nemo.composibility.ui.ext

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type

@OptIn(ExperimentalComposeUiApi::class)
fun Modifier.onBackPressed(
    isHandled: Boolean = false,
    onKeyEvent: () -> Unit,
): Modifier = onKeyEvent { keyEvent ->
    if (keyEvent.type == KeyEventType.KeyUp) {
        if (keyEvent.key == Key.Backspace) {
            onKeyEvent()
        }
    }
    isHandled
}
