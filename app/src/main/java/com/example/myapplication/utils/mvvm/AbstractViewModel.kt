package com.example.myapplication.utils.mvvm

import androidx.lifecycle.*

abstract class AbstractViewModel : ViewModel(), LifecycleObserver {
    val liveDataList = mutableListOf<LiveData<*>>()

    val mediator = MediatorLiveData<ViewState>()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun restoreMediator() {
        liveDataList
            .mapNotNull { it.value }
            .filterIsInstance<ViewState>()
            .forEach { mediator.value = it }
    }
}

fun <T : ViewState> AbstractViewModel.liveData(default: T? = null) =
    MutableLiveData<T>()
        .also {
            mediator.addSource(it) { value ->
                mediator.value = value
            }
        }.also { livedata ->
            default?.let { livedata.postValue(it) }
        }.also {
            liveDataList.add(it)
        }

interface ViewState