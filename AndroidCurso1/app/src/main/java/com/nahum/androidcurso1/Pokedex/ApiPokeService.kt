package com.nahum.androidcurso1.Pokedex

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiPokeService {

    @GET("pokemon")

    suspend fun getPokemon(@Query("limit") limit:Int): Response<PokemonsDataResponse>


    @GET("pokemon/{id}")
    suspend fun getPokemonDetails(@Path("id") pokemonId: String): Response<PokemonDetailsResponse>
}