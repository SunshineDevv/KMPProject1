package com.example.kmpproject1.presentation.screens.peoplescreen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmpproject1.domain.usecase.PeopleUseCase
import com.example.kmpproject1.presentation.model.PersonUI
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class PeopleViewModel(
    peopleUseCase: PeopleUseCase
): ViewModel() {

    val people: StateFlow<List<PersonUI>> =
        peopleUseCase.getAllPeople()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.Companion.WhileSubscribed(),
                initialValue = emptyList()
            )
}