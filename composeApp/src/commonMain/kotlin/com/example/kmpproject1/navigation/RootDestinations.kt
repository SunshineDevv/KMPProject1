package com.example.kmpproject1.navigation

import kotlinx.serialization.Serializable

sealed interface RootDestinations {

    @Serializable
    object General : RootDestinations
}