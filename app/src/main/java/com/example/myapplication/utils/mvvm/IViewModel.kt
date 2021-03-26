package com.example.myapplication.utils.mvvm

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

interface IViewModel <T : AbstractViewModel> {
    var viewModel: T

    fun onStateChanged(state: ViewState)

    fun setupViewModel(lifecycleOwner: LifecycleOwner) {
        lifecycleOwner.lifecycle.addObserver(viewModel)
        val observer = Observer<ViewState> {
            it?.let(::onStateChanged)
        }
    }
}