package com.example.myapplication.today

import kotlinx.coroutines.delay

/**
 * Platzhalter-Repository, simuliert eine API-Abfrage.
 */

data class TodayItem(val id: Int, val title: String, val description: String)

class TodayRepository {
    suspend fun fetchTodayItems(): List<TodayItem> {
        // Simulierte Netzwerklatenz
        delay(800)
        return listOf(
            TodayItem(1, "Gericht A", "Beschreibung von Gericht A"),
            TodayItem(2, "Gericht B", "Beschreibung von Gericht B"),
            TodayItem(3, "Gericht C", "Beschreibung von Gericht C")
        )
    }
}
