package com.eriku.testproject.data

import retrofit2.http.GET

interface CompendiumService {
    @GET("all")
    suspend fun fetchAllEntries(): CompendiumAllEntries
}
