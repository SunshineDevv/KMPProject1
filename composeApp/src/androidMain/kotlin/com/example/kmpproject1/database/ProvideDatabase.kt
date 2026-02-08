package com.example.kmpproject1.database

import android.content.Context
import com.example.kmpproject1.data.local.builder.buildPeopleDatabase
import com.example.kmpproject1.data.local.database.PeopleDatabase
import com.example.kmpproject1.database.builder.getDatabaseBuilder

fun providePeopleDatabase(context: Context): PeopleDatabase {
    return buildPeopleDatabase(getDatabaseBuilder(context))
}
