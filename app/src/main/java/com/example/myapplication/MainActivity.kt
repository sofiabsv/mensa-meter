@file:Suppress("UNUSED_VALUE", "UNUSED_VARIABLE")
package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.today.TodayScreen
import com.example.myapplication.ui.theme.MyApplicationTheme

sealed class Screen {
    object Heute : Screen()
    object Favoriten : Screen()
    object Menu : Screen()
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                var currentScreen by remember { mutableStateOf<Screen>(Screen.Heute) }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomNavigationBar(current = currentScreen) { selected ->
                            currentScreen = selected
                        }
                    }
                ) { innerPadding ->
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding), contentAlignment = Alignment.Center) {
                        when (currentScreen) {
                            is Screen.Heute -> TodayScreen()
                            is Screen.Favoriten -> FavoritesScreen()
                            is Screen.Menu -> MenuScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar(current: Screen, onSelect: (Screen) -> Unit) {
    NavigationBar {
        // Home icon shown but navigates to "Heute"
        NavigationBarItem(
            selected = current is Screen.Heute,
            onClick = { onSelect(Screen.Heute) },
            icon = { Icon(Icons.Default.Home, contentDescription = "Heute") },
            label = { Text("Heute") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                selectedTextColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                unselectedTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
        )
        NavigationBarItem(
            selected = current is Screen.Favoriten,
            onClick = { onSelect(Screen.Favoriten) },
            icon = { Icon(Icons.Default.Favorite, contentDescription = "Favoriten") },
            label = { Text("Favoriten") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                selectedTextColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                unselectedTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
        )
        NavigationBarItem(
            selected = current is Screen.Menu,
            onClick = { onSelect(Screen.Menu) },
            icon = { Icon(Icons.Default.Menu, contentDescription = "Menü") },
            label = { Text("Menü") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                selectedTextColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                unselectedTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
        )
    }
}


@Composable
fun FavoritesScreen() {
    Text(text = "Favoriten", style = MaterialTheme.typography.headlineMedium)
}

@Composable
fun MenuScreen() {
    Text(text = "Menü", style = MaterialTheme.typography.headlineMedium)
}

@Preview(showBackground = true)
@Composable
fun PreviewMain() {
    MyApplicationTheme {
        var current by remember { mutableStateOf<Screen>(Screen.Heute) }
        Scaffold(bottomBar = { BottomNavigationBar(current = current) {} }) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                TodayScreen()
            }
        }
    }
}