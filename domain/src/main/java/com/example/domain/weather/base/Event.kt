package com.example.domain.weather.base

sealed class Event<out T> {
    data class Data<T>(val data: T) : Event<T>()

    data class Error(val type: Enum<*>? = null, val cause: Throwable? = null) : Event<Nothing>()

    object Loading : Event<Nothing>()

    fun isData() = this is Data

    fun isError() = this is Error

    fun isLoading() = this is Loading

    companion object {

        fun <T> data(data: T): Event<T> = Data(data)

        fun <T> error(
            type: Enum<*>,
            cause: Throwable? = null
        ): Event<T> = Error(type, cause)

        fun <T> error(
            cause: Throwable
        ): Event<T> = Error(null, cause)

        fun <T> loading(): Event<T> = Loading
    }
}