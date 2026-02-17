package com.example.lablearnandroid

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PokemonApi {
    @GET("pokedex/2/")
    suspend fun getKantoPokedex(): PokemonResponse
}

object PokemonNetwork {
    private const val BASE_URL = "https://pokeapi.co/api/v2/"

    val api: PokemonApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokemonApi::class.java)
    }
}
