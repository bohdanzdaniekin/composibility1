package com.mr.nemo.composibility.ui.component.text

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.mr.nemo.composibility.R
import com.mr.nemo.composibility.ui.theme.ComposibilityTheme

@Composable
fun TermsAndPolicy(
    onTermsAndConditionClick: () -> Unit,
    onPrivacyPolicyClick: () -> Unit
) {
    val termsAndCondition = stringResource(R.string.terms_and_conditions)
    val privacyPolicy = stringResource(R.string.privacy_policy)
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle()) {
            append("I've read ")
        }
        withStyle(style = SpanStyle(color = ComposibilityTheme.colors.highlightDarkest)) {
            pushStringAnnotation(tag = termsAndCondition, annotation = termsAndCondition)
            append(termsAndCondition)
        }
        append(" and ")
        withStyle(style = SpanStyle(color = ComposibilityTheme.colors.highlightDarkest)) {
            pushStringAnnotation(tag = privacyPolicy, annotation = privacyPolicy)
            append(privacyPolicy)
        }
    }
    ClickableText(
        text = annotatedString,
        onClick = { offset ->
            annotatedString
                .getStringAnnotations(tag = termsAndCondition, start = offset, end = offset)
                .firstOrNull()
                ?.let {
                    onTermsAndConditionClick()
                }

            annotatedString
                .getStringAnnotations(tag = privacyPolicy, start = offset, end = offset)
                .firstOrNull()
                ?.let {
                    onPrivacyPolicyClick()
                }
        }
    )
}
