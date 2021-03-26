package com.example.myapplication.search.api

import com.example.myapplication.search.model.FoodDTO
import com.example.myapplication.search.model.FoodListDTO
import com.example.myapplication.utils.network.NetworkConstants
import retrofit2.http.GET
import retrofit2.http.Query

interface ISearchService {
    @GET(NetworkConstants.SEARCH_PATH)
    suspend fun searchByString(
        @Query("s") searchKey : String
    ) : FoodListDTO

    @GET(NetworkConstants.FIND_BY_ID_PATH)
    suspend fun findById(
        @Query("i") id : String
    ) : FoodDTO

}