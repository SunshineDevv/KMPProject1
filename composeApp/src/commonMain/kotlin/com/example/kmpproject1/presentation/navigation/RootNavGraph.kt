package com.example.kmpproject1.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kmpproject1.presentation.navigation.general.GeneralNavGraph

@Composable
fun RootNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = RootDestinations.General
    ) {
        composable<RootDestinations.General> {
            GeneralNavGraph()
        }
    }
}

