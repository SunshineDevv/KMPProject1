package com.example.kmpproject1.data.local.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.kmpproject1.data.model.PersonEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PeopleDao {

    @Upsert
    suspend fun upsert(personEntity: PersonEntity)

    @Delete
    suspend fun delete(personEntity: PersonEntity)

    @Query("SELECT * FROM people")
    fun getAllPeople(): Flow<List<PersonEntity>>
}