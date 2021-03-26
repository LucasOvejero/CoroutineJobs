package com.example.myapplication.search.model

import com.squareup.moshi.Json

class FoodListDTO (
    @Json(name = "meals")val meals:List<FoodDTO>
)