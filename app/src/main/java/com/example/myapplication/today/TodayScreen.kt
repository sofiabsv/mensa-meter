package com.example.myapplication.today

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Composable, das den Status selbst verwaltet und eine Liste anzeigt.
 * Nutzt die Platzhalter-API aus TodayRepository.
 */
@Composable
fun TodayScreen() {
    var isLoading by remember { mutableStateOf(true) }
    var items by remember { mutableStateOf<List<TodayItem>>(emptyList()) }
    val repository = remember { TodayRepository() }

    LaunchedEffect(Unit) {
        items = repository.fetchTodayItems()
        isLoading = false
    }

    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
        return
    }

    Column(modifier = Modifier.fillMaxSize()) {
        // Überschrift
        Box(modifier = Modifier.padding(16.dp)) {
            Text(text = "Heute", style = MaterialTheme.typography.headlineMedium)
        }

        LazyColumn(modifier = Modifier
            .fillMaxSize()) {
            items(items, key = { it.id }) { item ->
                // Jedes Item nimmt die gesamte verbleibende Höhe ein
                Box(modifier = Modifier
                    .fillMaxHeight()
                    .padding(8.dp)) {
                    Card(modifier = Modifier
                        .fillMaxSize()) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(text = item.title, style = MaterialTheme.typography.titleLarge)
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = item.description, style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }
            }
        }
    }
}
