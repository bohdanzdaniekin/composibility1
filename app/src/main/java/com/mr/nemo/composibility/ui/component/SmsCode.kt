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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mr.nemo.composibility.ui.component.state.SmsCodeState
import com.mr.nemo.composibility.ui.component.textfield.ComposibilityTextField
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
        val (secondDigitFocus, thirdDigitFocus, fourthDigitFocus) = remember {
            FocusRequester.createRefs()
        }
        val fieldModifier = Modifier
            .height(48.dp)
            .aspectRatio(1f)

        ComposibilityTextField(
            value = state.firstDigit,
            onValueChange = { value ->
                if (value.length <= 1) {
                    onStateChanged(state.copy(firstDigit = value))
                    secondDigitFocus.requestFocus()
                }
            },
            modifier = fieldModifier,
            textStyle = typography,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            )
        )
        ComposibilityTextField(
            value = state.secondDigit,
            onValueChange = { value ->
                if (value.length <= 1) {
                    onStateChanged(state.copy(secondDigit = value))
                    thirdDigitFocus.requestFocus()
                }
            },
            modifier = fieldModifier
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
                if (value.length <= 1) {
                    onStateChanged(state.copy(thirdDigit = value))
                    fourthDigitFocus.requestFocus()
                }
            },
            modifier = fieldModifier
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
                if (value.length <= 1) {
                    onStateChanged(state.copy(fourthDigit = value))
                    keyboardManager?.hide()
                    focusManager.clearFocus()
                }
            },
            modifier = fieldModifier
                .focusRequester(fourthDigitFocus),
            textStyle = typography,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            )
        )
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
