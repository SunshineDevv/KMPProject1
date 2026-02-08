package com.example.kmpproject1.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kmpproject1.presentation.navigation.general.GeneralDestinations
import com.example.kmpproject1.presentation.event.CounterEvent
import com.example.kmpproject1.presentation.viewmodel.CounterViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CounterScreen(
    onNavigateTo: (GeneralDestinations) -> Unit,
    viewModel: CounterViewModel = koinViewModel()
) {
    val state by viewModel.uiState.collectAsState()
    var name by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = name,
            onValueChange = { name = it },
            label = { Text("Person name") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                if (name.isNotBlank()) {
                    viewModel.onEvent(
                        CounterEvent.SaveResult(
                            name = name,
                            result = state.count
                        )
                    )
                    viewModel.onEvent(CounterEvent.ResetClicked)
                    name = ""
                }
            }
        ) {
            Text("Add result")
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Count: ${state.count}",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Button(onClick = { viewModel.onEvent(CounterEvent.IncrementClicked) }) {
                Text("Increment")
            }

            OutlinedButton(onClick = { viewModel.onEvent(CounterEvent.ResetClicked) }) {
                Text("Reset")
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { onNavigateTo(GeneralDestinations.PeopleScreen) }
        ) {
            Text("Go to results")
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = { onNavigateTo(GeneralDestinations.HomeScreen) }
        ) {
            Text("Go to home")
        }
    }
}
