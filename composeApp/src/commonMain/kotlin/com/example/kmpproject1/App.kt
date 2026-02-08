package com.example.kmpproject1

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.kmpproject1.presentation.navigation.RootNavGraph

@Composable
@Preview
fun App() {
    MaterialTheme {
        RootNavGraph(navController = rememberNavController())
    }
}