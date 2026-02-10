package com.example.kmpproject1.presentation.navigation.general

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kmpproject1.presentation.screens.counterscreen.CounterScreen
import com.example.kmpproject1.presentation.screens.homescreen.HomeScreen
import com.example.kmpproject1.presentation.screens.peoplescreen.PeopleScreen

@Composable
fun GeneralNavGraph() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.White,
    ) {
        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = GeneralDestinations.HomeScreen
        ) {
            composable<GeneralDestinations.HomeScreen> {
                HomeScreen(onNavigateTo = { navController.navigate(it) })
            }

            composable<GeneralDestinations.CounterScreen> {
                CounterScreen(onNavigateToResult = { navController.navigate(it) },
                    onNavigateToHome = { navController.navigate(it) {
                        popUpTo(GeneralDestinations.HomeScreen) { inclusive = true }
                    } }
                )
            }

            composable<GeneralDestinations.PeopleScreen> {
                PeopleScreen(onNavigateToCounter = { navController.navigate(it) },
                    onNavigateToHome = { navController.navigate(it) {
                    popUpTo(GeneralDestinations.HomeScreen) { inclusive = true }
                } })
            }
        }
    }
}