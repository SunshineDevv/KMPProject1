package com.example.kmpproject1.presentation

sealed interface CounterEvent {
    data object IncrementClicked : CounterEvent
    data object ResetClicked : CounterEvent
}