package com.example.lablearnandroid

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {

    // State เก็บรายการโปเกมอน
    private val _pokemonList = MutableStateFlow<List<PokemonEntry>>(emptyList())
    val pokemonList = _pokemonList.asStateFlow()

    // ฟังก์ชันเรียก API
    fun fetchPokemon() {
        viewModelScope.launch {
            try {
                val response = PokemonNetwork.api.getKantoPokedex()
                _pokemonList.value = response.pokemon_entries
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
