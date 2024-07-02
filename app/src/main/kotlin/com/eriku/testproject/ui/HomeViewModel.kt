package com.eriku.testproject.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eriku.testproject.data.CompendiumRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: CompendiumRepository,
) : ViewModel() {

    var uiState by mutableStateOf(HomeUiState())
        private set

    private var fetchJob: Job? = null

    init {
        getAllEntries()
    }

    fun getAllEntries() {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                val entries = repository.getAllEntries()

                uiState = uiState.copy(entries = entries)
            } catch (ioe: IOException) {
                // TODO: Implement error case
            }
        }
    }
}
