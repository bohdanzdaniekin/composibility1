package com.mr.nemo.composibility.ui.ext

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState

@OptIn(ExperimentalFoundationApi::class)
fun PagerState.offsetForPage(page: Int): Float {
    return (currentPage - page) + currentPageOffsetFraction
}
