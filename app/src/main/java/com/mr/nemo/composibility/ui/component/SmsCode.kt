package com.mr.nemo.composibility.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.mr.nemo.composibility.ui.component.state.SmsCodeState
import com.mr.nemo.composibility.ui.component.textfield.ComposibilityTextField
import com.mr.nemo.composibility.ui.ext.onBackPressed
import com.mr.nemo.composibility.ui.theme.ComposibilityTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SmsCode(
    state: SmsCodeState,
    onStateChanged: (SmsCodeState) -> Unit,
    modifier: Modifier = Modifier,
) {
    val typography = ComposibilityTheme.typography.bodyM.copy(
        textAlign = TextAlign.Center
    )

    val keyboardManager = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
    ) {
        val (firstDigitFocus, secondDigitFocus, thirdDigitFocus, fourthDigitFocus) = remember {
            FocusRequester.createRefs()
        }
        val fieldModifier = Modifier
            .height(48.dp)
            .aspectRatio(1f)

        ComposibilityTextField(
            value = state.firstDigit,
            onValueChange = { value ->
                handleValueChange(
                    previousFocus = null,
                    nextFocus = secondDigitFocus,
                    currentFocus = firstDigitFocus,
                    value = value,
                    keyboardManager
                ) { changed ->
                    onStateChanged(state.copy(firstDigit = changed))
                }
            },
            modifier = fieldModifier
                .focusProperties {
                    start = FocusRequester.Cancel
                    previous = FocusRequester.Cancel
                }
                .focusRequester(firstDigitFocus),
            textStyle = typography,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            )
        )
        ComposibilityTextField(
            value = state.secondDigit,
            onValueChange = { value ->
                handleValueChange(
                    previousFocus = firstDigitFocus,
                    nextFocus = thirdDigitFocus,
                    currentFocus = secondDigitFocus,
                    value = value,
                    keyboardManager
                ) { changed ->
                    onStateChanged(state.copy(secondDigit = changed))
                }
            },
            modifier = fieldModifier
                .focusProperties {

                    previous = firstDigitFocus
                }
                .focusRequester(secondDigitFocus),
            textStyle = typography,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            )
        )
        ComposibilityTextField(
            value = state.thirdDigit,
            onValueChange = { value ->
                handleValueChange(
                    previousFocus = secondDigitFocus,
                    nextFocus = fourthDigitFocus,
                    currentFocus = thirdDigitFocus,
                    value = value,
                    keyboardManager
                ) { changed ->
                    onStateChanged(state.copy(thirdDigit = changed))
                }
            },
            modifier = fieldModifier
                .focusProperties {
                    previous = secondDigitFocus
                }
                .focusRequester(thirdDigitFocus),
            textStyle = typography,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            )
        )
        ComposibilityTextField(
            value = state.fourthDigit,
            onValueChange = { value ->
                handleValueChange(
                    previousFocus = thirdDigitFocus,
                    nextFocus = null,
                    currentFocus = fourthDigitFocus,
                    value = value,
                    keyboardManager
                ) { changed ->
                    onStateChanged(state.copy(fourthDigit = changed))
                }
            },
            modifier = fieldModifier
                .focusProperties {
                    previous = thirdDigitFocus
                    next = FocusRequester.Cancel
                }
                .focusRequester(fourthDigitFocus),
            textStyle = typography,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            )
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
private fun handleValueChange(
    previousFocus: FocusRequester? = null,
    nextFocus: FocusRequester? = null,
    currentFocus: FocusRequester,
    value: String,
    keyboardManager: SoftwareKeyboardController?,
    onValueChanged: (String) -> Unit
) {
    if (value.isDigitsOnly()) {
        if (value.length > 1) {
            onValueChanged(value.last().toString())
            nextFocus?.requestFocus() ?: keyboardManager?.hide()
            return
        }
        if (currentFocus.freeFocus()) {
            onValueChanged(value)
            if (value.isBlank() && previousFocus != null) {
                previousFocus.requestFocus()
            } else if (value.isNotBlank()) {
                nextFocus?.requestFocus() ?: keyboardManager?.hide()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SmsCodePreview() {
    ComposibilityTheme {
        SmsCode(
            state = SmsCodeState(),
            onStateChanged = {}
        )
    }
}
