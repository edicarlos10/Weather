package com.example.domain.weather

import com.example.domain.weather.model.Weather
import io.reactivex.Single

interface IweatherRepository {
    fun getWeather(): Single<Weather>
}