package com.example.kmpproject1.presentation.navigation

import kotlinx.serialization.Serializable

sealed interface RootDestinations {

    @Serializable
    object General : RootDestinations
}