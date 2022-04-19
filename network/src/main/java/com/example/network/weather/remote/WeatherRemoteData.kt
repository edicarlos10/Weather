package com.example.network.weather.remote

import com.example.domain.weather.model.Weather
import com.example.network.weather.remote.api.IWeatherApiClient
import io.reactivex.Single

class WeatherRemoteData (private val apiWeatherClient: IWeatherApiClient) : IWeatherRemoteData{

    override fun getWeather(): Single<Weather> {
        return apiWeatherClient.getWeather()
            .map {
                it.body()?.toWeather() ?: throw Exception(it.errorBody()?.string())
            }
    }
}