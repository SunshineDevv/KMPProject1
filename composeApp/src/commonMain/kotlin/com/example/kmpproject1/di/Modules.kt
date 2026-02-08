package com.example.kmpproject1.di

import com.example.kmpproject1.data.local.database.PeopleDao
import com.example.kmpproject1.data.local.database.PeopleDatabase
import com.example.kmpproject1.domain.repository.PeopleRepository
import com.example.kmpproject1.data.repository.PeopleRepositoryImpl
import com.example.kmpproject1.presentation.viewmodel.CounterViewModel
import com.example.kmpproject1.domain.usecase.PeopleUseCase
import com.example.kmpproject1.presentation.viewmodel.PeopleViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single<PeopleDao> { get<PeopleDatabase>().getPeopleDao() }
    singleOf(::PeopleRepositoryImpl) bind PeopleRepository::class
    singleOf(::PeopleUseCase)

    viewModelOf(::CounterViewModel)
    viewModelOf(::PeopleViewModel)
}