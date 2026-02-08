package com.example.kmpproject1.data.local.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kmpproject1.data.model.PersonEntity

@Database(
    entities = [PersonEntity::class],
    version = 1
)
@ConstructedBy(PeopleDatabaseConstructor::class)
abstract class PeopleDatabase: RoomDatabase(){
    abstract fun getPeopleDao(): PeopleDao
}

