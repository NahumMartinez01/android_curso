package com.nahum.androidcurso1.Pokedex

import com.google.gson.annotations.SerializedName

data class PokemonDetailsResponse(
    val id: Int,
    val sprites: PokemonSprites
)

data class PokemonSprites(
    @SerializedName("front_default")
    val frontDefaultImageUrl: String
)