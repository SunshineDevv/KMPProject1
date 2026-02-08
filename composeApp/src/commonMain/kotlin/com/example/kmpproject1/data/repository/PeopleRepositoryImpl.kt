package com.example.kmpproject1.data.repository

import com.example.kmpproject1.data.local.database.PeopleDao
import com.example.kmpproject1.data.mappers.toEntity
import com.example.kmpproject1.data.mappers.toUI
import com.example.kmpproject1.domain.repository.PeopleRepository
import com.example.kmpproject1.presentation.model.PersonUI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PeopleRepositoryImpl(private val peopleDao: PeopleDao): PeopleRepository {
    override suspend fun upsert(person: PersonUI) {
        peopleDao.upsert(person.toEntity())
    }

    override suspend fun delete(person: PersonUI) {
        peopleDao.delete(person.toEntity())
    }

    override fun getAllPeople(): Flow<List<PersonUI>> {
        return peopleDao.getAllPeople().map { it.toUI() }
    }
}