package com.example.network.weather.search.remote

import com.example.domain.weather.search.model.Weather
import io.reactivex.Single

interface IWeatherRemoteData {
    fun getWeather(): Single<Weather>
}