package com.example.myapplication.search.ui

import androidx.lifecycle.*
import com.example.myapplication.search.model.FoodDTO
import com.example.myapplication.search.api.SearchRepository
import com.example.myapplication.utils.mvvm.AbstractViewModel
import com.example.myapplication.utils.mvvm.ViewState
import com.example.myapplication.utils.mvvm.viewModelFactory
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class SearchViewModel(private val repository: SearchRepository) : AbstractViewModel() {
    private val _loadingVisibility = MutableLiveData<Boolean>()
    val loadingData:LiveData<Boolean> get() = _loadingVisibility
    val messageLiveData = MutableLiveData<String>()
    val numberOfRecipes = MutableLiveData<Int>()
    private val _recipesLiveData = MutableLiveData<List<FoodDTO>>()
    val recipesLiveData :LiveData<List<FoodDTO>> get() = _recipesLiveData

    private var job:Job? = null

    fun searchFood(key: String) {

        job?.cancel()
        job = viewModelScope.launch {
            _loadingVisibility.value = true
            val response = repository.getFoodList(key)
            if(response is SearchState.SearchFoodState) {
                _recipesLiveData.postValue(response.foodList)
            }
            if (response is SearchState.ErrorState) {
                // TODO
            }
            _loadingVisibility.value = false
        }
    }

    companion object {
        fun factory() = viewModelFactory {
            val repository = SearchRepository()
            SearchViewModel(repository)
        }
    }
}

sealed class SearchState : ViewState {
    class SearchFoodState(val foodList: List<FoodDTO>) : SearchState()
    class ErrorState(exception: Exception) : SearchState()
}