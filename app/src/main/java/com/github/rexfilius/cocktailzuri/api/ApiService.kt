package com.github.rexfilius.cocktailzuri.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// https://www.thecocktaildb.com/api/json/v1/1/filter.php?a=Alcoholic
// https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=11007
private val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/"

interface ApiService {

    @GET("1/filter.php")
    suspend fun getDrinks(@Query("a") drink: String): DrinkResponse

    @GET("1/lookup.php")
    suspend fun getDrinkDetails(@Query("i") drinkId: String): DrinkDetailResponse
}

val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL).build()

object Api {
    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}