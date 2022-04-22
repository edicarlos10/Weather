package com.example.domain.weather

import com.example.domain.weather.search.model.Weather
import io.reactivex.Single

interface IweatherRepository {
    fun getWeather(): Single<Weather>
}