package com.example.myapplication.viewbinding

import com.example.myapplication.search.api.ISearchService
import com.example.myapplication.search.api.IService
import com.example.myapplication.utils.mvvm.ViewState
import com.example.myapplication.utils.network.AbstractRepository

class VBDBRepository: AbstractRepository<ISearchService>(ISearchService::class.java), IService {
    override suspend fun getFoodList(key: String): ViewState {
        TODO("Not yet implemented")
    }

}