package com.example.myapplication.search.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class FoodDTO (
    @Json(name = "idMeal") val id:String,
    @Json(name = "strMeal") val name:String,
    @Json(name = "strMealThumb") val imageUrl:String,
    @Json(name = "strCategory") val category:String,
    @Json(name = "strArea") val area:String,
    @Json(name = "strTags") val tags:String?
)

/**
 *  "idMeal": "52771",
    "strMeal": "Spicy Arrabiata Penne",
    "strMealThumb": "https:\/\/www.themealdb.com\/images\/media\/meals\/ustsqw1468250014.jpg",
    "strDrinkAlternate": null,
    "strCategory": "Vegetarian",
    "strArea": "Italian",
    "strInstructions": "Bring a large pot of water to a boil. Add kosher salt to the boiling water, then add the pasta. Cook according to the package instructions, about 9 minutes.\r\nIn a large skillet over medium-high heat, add the olive oil and heat until the oil starts to shimmer. Add the garlic and cook, stirring, until fragrant, 1 to 2 minutes. Add the chopped tomatoes, red chile flakes, Italian seasoning and salt and pepper to taste. Bring to a boil and cook for 5 minutes. Remove from the heat and add the chopped basil.\r\nDrain the pasta and add it to the sauce. Garnish with Parmigiano-Reggiano flakes and more basil and serve warm.",
    "strTags": "Pasta,Curry"
 */
