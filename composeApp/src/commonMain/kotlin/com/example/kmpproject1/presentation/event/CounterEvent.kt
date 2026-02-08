package com.example.kmpproject1.presentation.event

sealed interface CounterEvent {
    data object IncrementClicked : CounterEvent
    data object ResetClicked : CounterEvent
    data class SaveResult(val name: String, val result: Int) : CounterEvent
}