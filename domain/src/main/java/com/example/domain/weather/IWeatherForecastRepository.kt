package com.example.domain.weather

import com.example.domain.weather.weatherForecast.model.WeatherForecast
import io.reactivex.Single

interface IWeatherForecastRepository {
    fun getWeatherForecast(q: String, appid: String): Single<WeatherForecast>
}