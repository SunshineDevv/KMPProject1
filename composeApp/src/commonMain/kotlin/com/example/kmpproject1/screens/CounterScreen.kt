package com.example.kmpproject1.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kmpproject1.navigation.general.GeneralDestinations
import com.example.kmpproject1.presentation.CounterEvent
import com.example.kmpproject1.presentation.CounterViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CounterScreen(
    onNavigateTo: (GeneralDestinations) -> Unit,
    vm: CounterViewModel = koinViewModel()
) {
    val state by vm.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Count: ${state.count}",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Button(onClick = { vm.onEvent(CounterEvent.IncrementClicked) }) {
                Text("Increment")
            }

            OutlinedButton(onClick = { vm.onEvent(CounterEvent.ResetClicked) }) {
                Text("Reset")
            }
        }

        Spacer(Modifier.height(16.dp))

        Button(onClick = { onNavigateTo(GeneralDestinations.HomeScreen) }) {
            Text("Go to home")
        }
    }
}
