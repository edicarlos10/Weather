package com.example.network.weather.search.remote

import com.example.domain.weather.search.model.Weather
import com.example.network.weather.search.remote.api.IWeatherApiClient
import io.reactivex.Single

class WeatherRemoteData (private val apiWeatherClient: IWeatherApiClient) : IWeatherRemoteData{

    override fun getWeather(): Single<Weather> {
        return apiWeatherClient.getWeather()
            .map {
                it.body()?.toWeather() ?: throw Exception(it.errorBody()?.string())
            }
    }
}