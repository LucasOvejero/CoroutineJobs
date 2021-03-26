package com.example.myapplication.search.api

import com.example.myapplication.search.ui.SearchState
import com.example.myapplication.utils.mvvm.ViewState
import com.example.myapplication.utils.network.AbstractRepository
import retrofit2.HttpException

class SearchRepository : AbstractRepository<ISearchService>(ISearchService::class.java), IService {

    override suspend fun getFoodList(key: String): ViewState {
        //service.searchByString(key).enqueue()
        return try {
            SearchState.SearchFoodState(service.searchByString(key).meals)
        } catch (exception: HttpException) {
            return SearchState.ErrorState(exception)
        }
    }
}