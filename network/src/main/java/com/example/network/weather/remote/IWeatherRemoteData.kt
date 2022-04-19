package com.example.network.weather.remote

import com.example.domain.weather.model.Weather
import io.reactivex.Single

interface IWeatherRemoteData {
    fun getWeather(): Single<Weather>
}