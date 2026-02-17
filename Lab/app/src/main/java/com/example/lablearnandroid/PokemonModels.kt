package com.example.lablearnandroid

data class PokemonResponse(
    val pokemon_entries: List<PokemonEntry>
)

data class PokemonEntry(
    val entry_number: Int,
    val pokemon_species: PokemonSpecies
)

data class PokemonSpecies(
    val name: String
)
