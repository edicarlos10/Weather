package com.example.network.weather.weatherForecast.remote

import com.example.domain.weather.weatherForecast.model.WeatherForecast
import io.reactivex.Single

interface IWeatherForecastRemoteData {
    fun getWeatherForecast(q: String, appid: String): Single<WeatherForecast>
}