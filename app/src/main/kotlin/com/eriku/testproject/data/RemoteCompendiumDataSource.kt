package com.eriku.testproject.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

private const val BASE_URL = "https://botw-compendium.herokuapp.com/api/v3/compendium/"

class RemoteCompendiumDataSource @Inject constructor() {
    private val compendiumService: CompendiumService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        compendiumService = retrofit.create(CompendiumService::class.java)
    }

    suspend fun getAllEntries(): List<CompendiumEntry> = compendiumService.fetchAllEntries().data
}
