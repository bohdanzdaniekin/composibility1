package com.mr.nemo.composibility.ui.theme.typography

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mr.nemo.composibility.R

val Typography = ComposibilityTypography(
    heading1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.font_inter)),
        fontWeight = FontWeight(900),
        fontSize = 24.sp,
        letterSpacing = 0.24.sp
    ),
    heading2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.font_inter)),
        fontWeight = FontWeight(900),
        fontSize = 18.sp,
        letterSpacing = 0.09.sp
    ),
    heading3 = TextStyle(
        fontFamily = FontFamily(Font(R.font.font_inter)),
        fontWeight = FontWeight(900),
        fontSize = 16.sp,
        letterSpacing = 0.08.sp
    ),
    heading4 = TextStyle(
        fontFamily = FontFamily(Font(R.font.font_inter)),
        fontWeight = FontWeight(800),
        fontSize = 14.sp
    ),
    heading5 = TextStyle(
        fontFamily = FontFamily(Font(R.font.font_inter)),
        fontWeight = FontWeight(700),
        fontSize = 12.sp
    ),
    bodyXL = TextStyle(
        fontFamily = FontFamily(Font(R.font.font_inter)),
        fontSize = 18.sp
    ),
    bodyL = TextStyle(
        fontFamily = FontFamily(Font(R.font.font_inter)),
        fontSize = 16.sp
    ),
    bodyM = TextStyle(
        fontFamily = FontFamily(Font(R.font.font_inter)),
        fontSize = 14.sp
    ),
    bodyS = TextStyle(
        fontFamily = FontFamily(Font(R.font.font_inter)),
        fontSize = 12.sp,
        letterSpacing = 0.12.sp
    ),
    bodyXS = TextStyle(
        fontFamily = FontFamily(Font(R.font.font_inter)),
        fontSize = 10.sp,
        letterSpacing = 0.15.sp
    ),
    actionL = TextStyle(
        fontFamily = FontFamily(Font(R.font.font_inter)),
        fontWeight = FontWeight(600),
        fontSize = 14.sp
    ),
    actionM = TextStyle(
        fontFamily = FontFamily(Font(R.font.font_inter)),
        fontWeight = FontWeight(600),
        fontSize = 12.sp
    ),
    actionS = TextStyle(
        fontFamily = FontFamily(Font(R.font.font_inter)),
        fontWeight = FontWeight(600),
        fontSize = 10.sp
    ),
    captionM = TextStyle(
        fontFamily = FontFamily(Font(R.font.font_inter)),
        fontWeight = FontWeight(600),
        fontSize = 10.sp,
        letterSpacing = 0.5.sp
    )
)
