package com.eriku.testproject.data

import android.util.Log
import java.io.IOException
import javax.inject.Inject

class CompendiumRepository @Inject constructor(
    private val remoteCompendiumDataSource: RemoteCompendiumDataSource
) {
    suspend fun getAllEntries(): List<CompendiumEntry> {
        try {
            return remoteCompendiumDataSource.getAllEntries()
        } catch(e: retrofit2.HttpException) {
            Log.e("CompendiumRepository", "Failed to fetch entries.", e)
            throw IOException()
        }
    }
}
