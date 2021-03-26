package com.example.myapplication.utils.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

open class AbstractRepository<T>(service: Class<T>) {
    var service: T = Retrofit
        .Builder()
        .baseUrl(NetworkConstants.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(createMoshi()))
        .build().create(service)

    private fun createMoshi() = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        /* more brilliant adapters */
        .build()
    sealed class RepositoryResult<out T> {
        class Success<out T>(val value: T) : RepositoryResult<T>()
        class Error(val statusCode: Int?) : RepositoryResult<Nothing>()
    }

}