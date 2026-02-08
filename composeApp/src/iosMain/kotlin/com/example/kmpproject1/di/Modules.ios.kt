package com.example.kmpproject1.di

import com.example.kmpproject1.database.providePeopleDatabase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val platformModule = module {
    singleOf(::providePeopleDatabase)
}