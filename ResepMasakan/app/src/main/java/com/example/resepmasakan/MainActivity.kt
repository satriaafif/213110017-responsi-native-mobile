package com.example.resepmasakan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.resepmasakan.ui.theme.ResepMasakanTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ResepMasakanTheme {
                // Panggil fungsi komposisi utama di sini
                GreetingsScreen()
            }
        }
    }
}

@Composable
fun GreetingsScreen() {
    val navController = rememberNavController()

    Scaffold(
        topBar = { /* ... */ },
        content = {
            NavHost(navController = navController, startDestination = "recipeList") {
                composable("recipeList") { RecipeList(navController) }
                composable("recipeDetail") { RecipeDetail() }
            }
        }
    )
}

@Composable
fun RecipeList() {
    LazyColumn {
        items(10) { index ->
            RecipeCard(recipeName = "Resep $index")
        }
    }
}


@Composable
fun RecipeCard(recipeName: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = recipeName, style = MaterialTheme.typography.h5)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Deskripsi resep goes here.")
            // Tambahkan elemen UI lainnya sesuai kebutuhan
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingsScreenPreview() {
    ResepMasakanTheme {
        GreetingsScreen()
    }
}
