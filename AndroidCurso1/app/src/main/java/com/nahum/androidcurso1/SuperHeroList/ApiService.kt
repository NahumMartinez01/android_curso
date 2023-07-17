package com.nahum.androidcurso1.SuperHeroList

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("api/1995547227473717/search/{name}")

    suspend fun getSuperHeroes(@Path("name") superHeroName: String):Response<SuperHeroDataResponse>

    @GET("api/1995547227473717/{id}")
    suspend fun getDetailsSuperHeroes(@Path("id") superHeroId: String): Response<SuperHeroDetailResponse>
}