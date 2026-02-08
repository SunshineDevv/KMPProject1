package com.example.kmpproject1.presentation.navigation.general

import kotlinx.serialization.Serializable

sealed interface GeneralDestinations {

    @Serializable
    object HomeScreen : GeneralDestinations

    @Serializable
    object CounterScreen : GeneralDestinations

    @Serializable
    object PeopleScreen : GeneralDestinations
}