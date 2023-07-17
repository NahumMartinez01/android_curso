package com.nahum.androidcurso1.SuperHeroList

import com.google.gson.annotations.SerializedName

data class SuperHeroDetailResponse(
    @SerializedName("response") val response: String,
    @SerializedName("name") val name: String,
    @SerializedName("powerstats") val powerStats: SuperHeroStats,
    @SerializedName("image") val image: SuperHeroImage
)

data class SuperHeroImage(
    @SerializedName("url") val url: String
)


data class SuperHeroStats(
    @SerializedName("intelligence") val intelligence: String,
    @SerializedName("strength") val strength: String,
    @SerializedName("speed") val speed: String,
    @SerializedName("durability") val durability: String,
    @SerializedName("power") val power: String,
    @SerializedName("combat") val combat: String
)
