package com.example.network.weather.weatherForecast.remote.response

import com.example.domain.weather.weatherForecast.model.Clouds

data class CloudsResponse(
    val all: Int? = null
) {
    fun toClouds(): Clouds = Clouds(
        all
    )
}
