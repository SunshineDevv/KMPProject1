package com.example.kmpproject1.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmpproject1.presentation.model.PersonUI
import com.example.kmpproject1.domain.usecase.PeopleUseCase
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
                started = SharingStarted.WhileSubscribed(),
                initialValue = emptyList()
            )
}