package com.nahum.androidcurso1.Pokedex

import com.google.gson.annotations.SerializedName

data class PokemonsDataResponse(
    @SerializedName("results") val results: List<PokemonResult>
)

data class PokemonResult(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url:String
)


//data class PokemonDetailsResponse(
//    @SerializedName("id") val id: Int,
//    @SerializedName("name")  val name: String,
//    @SerializedName("sprites") val sprites: PokemonSprites
//)
//
//data class PokemonSprites(
//    @SerializedName("front_default")
//    val frontDefault: String
//)