package com.mr.nemo.composibility.ui.screen.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mr.nemo.composibility.R
import com.mr.nemo.composibility.ui.component.pager.PageIndicator
import com.mr.nemo.composibility.ui.component.text.TitleText
import com.mr.nemo.composibility.ui.theme.ComposibilityTheme

@Composable
fun OnboardingPage(
    title: String,
    description: String,
    image: Painter = painterResource(id = R.drawable.bg_login_page),
    pageCount: Int,
    currentPage: Int,
    onNextClicked: () -> Unit,
    onBackClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val typography = ComposibilityTheme.typography
    val colors = ComposibilityTheme.colors
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(24.dp))

        Column(
            modifier = Modifier
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            PageIndicator(
                pageCount = pageCount,
                currentPage = currentPage,
                arrangement = Arrangement.spacedBy(4.dp, alignment = Alignment.Start)
            )

            Spacer(modifier = Modifier.height(24.dp))

            TitleText(text = title)

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = description,
                style = typography.bodyS,
                color = colors.neutralDarkLight
            )

            Spacer(modifier = Modifier.height(32.dp))


            Row(modifier = Modifier.fillMaxWidth()) {
                if (currentPage > 0) {
                    IconButton(onClick = onBackClicked) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
                TextButton(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = ComposibilityTheme.colors.highlightDarkest
                    ),
                    onClick = onNextClicked,
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OnboardingPagePreview() {
    ComposibilityTheme {
        OnboardingPage(
            title = "Create a prototype in just a few minutes",
            description = "Enjoy these pre-made components and worry only about creating the best product ever.",
            pageCount = 3,
            currentPage = 1,
            onNextClicked = {},
            onBackClicked = {}
        )
    }
}
