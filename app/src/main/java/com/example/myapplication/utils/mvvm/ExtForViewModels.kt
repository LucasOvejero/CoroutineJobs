package com.example.myapplication.utils.mvvm

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Extension to create lazy viewModel for Activities
 */

inline fun <reified T : ViewModel> AppCompatActivity.viewModel(factory: ViewModelProvider.Factory): Lazy<T> =
    lazy {
        ViewModelProvider(this, factory).get(T::class.java)
    }

/**
 * Extension to create viewModel for Activities
 */

inline fun <reified T : ViewModel> AppCompatActivity.makeViewModel(factory: ViewModelProvider.Factory): T =
    ViewModelProvider(this, factory).get(T::class.java)

/**
 * Extension to create lazy ViewModel for Fragments
 */


inline fun <reified T : ViewModel> Fragment.makeViewModel(factory: ViewModelProvider.Factory): T =
    ViewModelProvider(this, factory).get(T::class.java)


inline fun <reified T : ViewModel> Fragment.viewModel(
    factory: ViewModelProvider.Factory
): Lazy<T> =
    lazy {
        ViewModelProvider(this, factory).get(T::class.java)
    }

/**
*   Extension to create a factory for viewModel
 */
@Suppress("UNCHECKED_CAST")
inline fun <viewModel : ViewModel> viewModelFactory(
    crossinline block: () -> viewModel
) = object : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return block() as T
    }

}