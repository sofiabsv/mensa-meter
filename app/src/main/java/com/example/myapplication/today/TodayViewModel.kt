package com.example.myapplication.today

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/** Kleiner UI-State für die Heute-Ansicht */
data class TodayUiState(val isLoading: Boolean = true, val items: List<TodayItem> = emptyList())

class TodayViewModel(private val repository: TodayRepository = TodayRepository()) : ViewModel() {
    private val _uiState = MutableStateFlow(TodayUiState())
    val uiState: StateFlow<TodayUiState> = _uiState

    init {
        viewModelScope.launch {
            val items = repository.fetchTodayItems()
            _uiState.value = TodayUiState(isLoading = false, items = items)
        }
    }
}
