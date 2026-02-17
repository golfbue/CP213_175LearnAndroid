package com.example.lablearnandroid

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage

class PokedexActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Lifecycle", "PokedexActivity : onCreate")
        enableEdgeToEdge()
        setContent {
            ListScreen()
        }
    }
}

@Composable
fun ListScreen(
    viewModel: PokemonViewModel = viewModel()
) {
    // เรียก API ครั้งแรกตอนเปิดจอ
    LaunchedEffect(Unit) {
        viewModel.fetchPokemon()
    }

    // รับค่าจาก StateFlow (แบบ lifecycle-safe)
    val pokemonList by viewModel.pokemonList.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(
                items = pokemonList,
                key = { it.entry_number }
            ) { item ->

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(text = item.entry_number.toString())

                    Spacer(modifier = Modifier.width(16.dp))

                    Text(text = item.pokemon_species.name)

                    Spacer(modifier = Modifier.width(16.dp))

                    val imageUrl =
                        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${item.entry_number}.png"

                    AsyncImage(
                        model = imageUrl,
                        contentDescription = item.pokemon_species.name,
                        modifier = Modifier.size(64.dp)
                    )
                }
            }
        }
    }
}
