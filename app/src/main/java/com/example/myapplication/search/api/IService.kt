package com.example.myapplication.search.api

import com.example.myapplication.utils.mvvm.ViewState

interface IService {
    suspend fun getFoodList(key: String) : ViewState
}