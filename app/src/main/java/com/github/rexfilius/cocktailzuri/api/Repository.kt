package com.github.rexfilius.cocktailzuri.api

class Repository(private val apiService: ApiService) {

    suspend fun getDrinks(drink: String) = apiService.getDrinks(drink)

    suspend fun getDrinkDetails(id: String) = apiService.getDrinkDetails(id)

}