package com.example.network.weather.weatherForecast.remote.response

import com.example.domain.weather.weatherForecast.model.*

data class WeatherForecastResponse(
    val base: String? = null, // stations
    val clouds: CloudsResponse? = null,
    val cod: Int? = null, // 200
    val coord: CoordResponse? = null,
    val dt: Int? = null, // 1485789600
    val id: Int? = null, // 2643743
    val main: MainResponse? = null,
    val name: String? = null, // London
    val sys: SysResponse? = null,
    val visibility: Int? = null, // 10000
    val weather: List<WeatherResponse>? = null,
    val wind: WindResponse? = null
) {

    fun toWeatherForecast(): WeatherForecast = WeatherForecast(
        base ?: "",
        clouds?.toClouds(),
        cod,
        coord?.toCoord(),
        dt,
        id,
        main?.toMain(),
        name,
        sys?.toSys(),
        visibility,
        weather?.map { it.toWeather()} ?: emptyList(),
        wind?.toWind()
    )

}
