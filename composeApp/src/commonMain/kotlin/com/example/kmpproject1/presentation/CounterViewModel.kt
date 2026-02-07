package com.example.kmpproject1.presentation

import androidx.lifecycle.ViewModel
import com.example.kmpproject1.model.CounterUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CounterViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CounterUiState())
    val uiState: StateFlow<CounterUiState> = _uiState

    fun onEvent(event: CounterEvent) {
        when (event) {
            CounterEvent.IncrementClicked -> {
                _uiState.update { it.copy(count = it.count + 1) }
            }
            CounterEvent.ResetClicked -> {
                _uiState.value = CounterUiState()
            }
        }
    }
}