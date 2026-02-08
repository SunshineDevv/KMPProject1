package com.example.kmpproject1.data.local.builder

import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.example.kmpproject1.data.local.database.PeopleDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

fun buildPeopleDatabase(
    builder: RoomDatabase.Builder<PeopleDatabase>
): PeopleDatabase {
    return builder
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}