package com.example.kmpproject1.presentation.screens.peoplescreen
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kmpproject1.presentation.navigation.general.GeneralDestinations
import com.example.kmpproject1.presentation.screens.peoplescreen.viewmodel.PeopleViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun PeopleScreen(
    onNavigateToCounter: (GeneralDestinations) -> Unit,
    onNavigateToHome: (GeneralDestinations) -> Unit,
    viewModel: PeopleViewModel = koinViewModel()
) {
    val peopleList by viewModel.people.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "People results",
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(peopleList) { person ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = person.name,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        text = person.result.toString(),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedButton(
                modifier = Modifier.weight(1f),
                onClick = { onNavigateToCounter(GeneralDestinations.CounterScreen) }
            ) {
                Text("Go to counter")
            }

            Button(
                modifier = Modifier.weight(1f),
                onClick = { onNavigateToHome(GeneralDestinations.HomeScreen) }
            ) {
                Text("Go to home")
            }
        }
    }
}