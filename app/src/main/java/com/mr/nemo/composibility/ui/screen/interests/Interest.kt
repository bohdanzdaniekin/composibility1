package com.mr.nemo.composibility.ui.screen.interests

import java.util.UUID

data class Interest(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val isSelected: Boolean = false
)
