package com.github.rexfilius.cocktailzuri.api

import com.squareup.moshi.Json

data class Drink(
    @Json(name = "strDrink")
    val drinkName: String,

    @Json(name = "strDrinkThumb")
    val drinkThumb: String,

    @Json(name = "idDrink")
    val drinkId: String
)

data class DrinkResponse(val drinks: List<Drink>)

data class DrinkDetail(
    @Json(name = "strDrink")
    val drinkName: String,

    @Json(name = "strDrinkThumb")
    val drinkThumb: String,

    @Json(name = "idDrink")
    val drinkId: String,

    @Json(name = "strInstructions")
    val instruction: String
)

data class DrinkDetailResponse(val drinks: List<DrinkDetail>)