package com.eriku.testproject.ui

import com.eriku.testproject.data.CompendiumEntry

data class HomeUiState(
    val entries: List<CompendiumEntry> = listOf(),
)
