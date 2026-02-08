package com.example.kmpproject1.domain.repository

import com.example.kmpproject1.presentation.model.PersonUI
import kotlinx.coroutines.flow.Flow

interface PeopleRepository {
    suspend fun upsert(person: PersonUI)
    suspend fun delete(person: PersonUI)
    fun getAllPeople(): Flow<List<PersonUI>>
}