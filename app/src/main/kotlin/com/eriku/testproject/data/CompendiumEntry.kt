package com.eriku.testproject.data

data class CompendiumAllEntries(
    val data: List<CompendiumEntry>,
)

data class CompendiumEntry(
    val id: UInt,
    val name: String,
    val category: String,
    val description: String,
)
