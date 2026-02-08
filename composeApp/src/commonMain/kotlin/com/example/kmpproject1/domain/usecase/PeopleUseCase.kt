package com.example.kmpproject1.domain.usecase

import com.example.kmpproject1.domain.repository.PeopleRepository
import com.example.kmpproject1.presentation.model.PersonUI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PeopleUseCase(
    private val repository: PeopleRepository
) {
    fun getAllPeople(): Flow<List<PersonUI>> {
        val sortedPeople = repository.getAllPeople().map { people ->
            people.sortedByDescending { it.result }
        }
        return sortedPeople
    }

    suspend fun upsert(person: PersonUI) {
        val trimmedName = person.name.trim()
        require(trimmedName.isNotEmpty()) { "Name must not be blank" }
        repository.upsert(person.copy(name = trimmedName))
    }

    suspend fun delete(person: PersonUI) {
        repository.delete(person)
    }
}