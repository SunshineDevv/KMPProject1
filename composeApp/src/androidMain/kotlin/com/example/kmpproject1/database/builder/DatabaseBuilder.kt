package com.example.kmpproject1.database.builder

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kmpproject1.data.local.database.PeopleDatabase

fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<PeopleDatabase> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath("people.db")
    return Room.databaseBuilder<PeopleDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}