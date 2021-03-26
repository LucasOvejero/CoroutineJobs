package com.example.myapplication.viewbinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class VBDBViewModel : ViewModel() {
    private val _loadingVisibility = MutableLiveData<Boolean>()
    val loadingVisibility: LiveData<Boolean> get() = _loadingVisibility
    private val _titleLiveData = MutableLiveData<String>()
    val titleLiveData: LiveData<String> get() = _titleLiveData
    private val _subTitleLiveData = MutableLiveData<String>()
    val subTitleLiveData: LiveData<String> get() = _subTitleLiveData
    //private val _data = MutableLiveData<PagedList<FoodDTO>>()
    //val data: LiveData<PagedList<FoodDTO>> = //LivePagedListBuilder()

    fun onButtonClicked() {
        viewModelScope.launch {
            _loadingVisibility.postValue(true)
            withContext(Dispatchers.IO) {
                Thread.sleep(2000)
                _titleLiveData.postValue("hola cómo andas?")
                _subTitleLiveData.postValue("que grande esta tarjeta")
            }
            _loadingVisibility.postValue(false)
        }
    }

}