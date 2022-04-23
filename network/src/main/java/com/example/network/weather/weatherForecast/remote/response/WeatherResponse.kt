package com.example.network.weather.weatherForecast.remote.response

import com.example.domain.weather.weatherForecast.model.Weather

data class WeatherResponse(
    val description: String? = null, // light intensity drizzle
    val icon: String? = null, // 09d
    val id: Int? = null, // 300
    val main: String? = null // Drizzle
) {
    fun toWeather(): Weather = Weather(
        description,
        icon,
        id,
        main
    )
}
