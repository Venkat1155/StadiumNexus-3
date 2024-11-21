package com.venkat.stadiumnexus.data

import androidx.compose.ui.graphics.vector.ImageVector

data class Item(
    val title: String,
    val description: String,
    val itemId: String,
    val icon: ImageVector
)