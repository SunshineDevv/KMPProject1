package com.example.kmpproject1.database

import com.example.kmpproject1.data.local.builder.buildPeopleDatabase
import com.example.kmpproject1.data.local.database.PeopleDatabase
import com.example.kmpproject1.database.builder.getDatabaseBuilder


fun providePeopleDatabase(): PeopleDatabase {
    return buildPeopleDatabase(getDatabaseBuilder())
}