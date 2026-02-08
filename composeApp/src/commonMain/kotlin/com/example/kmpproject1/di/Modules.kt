package com.example.kmpproject1.di

import com.example.kmpproject1.presentation.CounterViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    viewModelOf(::CounterViewModel)
}