package com.mr.nemo.composibility.ui.component.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable

@Immutable
data class SmsCodeState(
    val firstDigit: String = "",
    val secondDigit: String = "",
    val thirdDigit: String = "",
    val fourthDigit: String = ""
) {

    companion object {

        val Saver = listSaver<SmsCodeState, String>(
            save = { state ->
                listOf(state.firstDigit, state.secondDigit, state.thirdDigit, state.fourthDigit)
            },
            restore = { (firstDigit, secondDigit, thirdDigit, fourthDigit) ->
                SmsCodeState(firstDigit, secondDigit, thirdDigit, fourthDigit)
            }
        )
    }
}

@Composable
fun rememberSmsCodeState() = rememberSaveable(stateSaver = SmsCodeState.Saver) {
    mutableStateOf(SmsCodeState())
}
