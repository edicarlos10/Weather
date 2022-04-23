package com.example.domain.weather.weatherForecast.model

import java.io.Serializable

data class WeatherForecast(
    val base: String? = null, // stations
    val clouds: Clouds? = null,
    val cod: Int? = null, // 200
    val coord: Coord?,
    val dt: Int? = null, // 1485789600
    val id: Int? = null, // 2643743
    val main: Main? = null,
    val name: String? = null, // London
    val sys: Sys? = null,
    val visibility: Int? = null, // 10000
    val weather: List<Weather>? = null,
    val wind: Wind? = null
): Serializable