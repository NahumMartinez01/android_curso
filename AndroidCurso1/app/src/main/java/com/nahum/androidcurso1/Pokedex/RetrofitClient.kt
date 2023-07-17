package com.nahum.androidcurso1.Pokedex

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {


        private const val BASE_URL = "https://pokeapi.co/api/v2/"

        private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val pokeApiService: ApiPokeService = retrofit.create(ApiPokeService::class.java)

}