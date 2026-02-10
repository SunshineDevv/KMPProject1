package com.example.kmpproject1.presentation.screens.counterscreen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmpproject1.domain.usecase.PeopleUseCase
import com.example.kmpproject1.presentation.event.CounterEvent
import com.example.kmpproject1.presentation.model.CounterUiState
import com.example.kmpproject1.presentation.model.PersonUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CounterViewModel(
    private val peopleUseCase: PeopleUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(CounterUiState())
    val uiState: StateFlow<CounterUiState> = _uiState

    fun onEvent(event: CounterEvent) {
        when (event) {
            is CounterEvent.IncrementClicked -> {
                _uiState.update { it.copy(count = it.count + 1) }
            }

            is CounterEvent.ResetClicked -> {
                _uiState.value = CounterUiState()
            }

            is CounterEvent.SaveResult -> {
                viewModelScope.launch {
                    peopleUseCase.upsert(PersonUI(name = event.name, result = event.result))
                }
            }
        }
    }
}