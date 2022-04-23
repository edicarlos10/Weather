package com.example.network.weather.weatherForecast.remote

import com.example.domain.weather.weatherForecast.model.WeatherForecast
import com.example.network.weather.weatherForecast.remote.api.IWeatherForecastApiClient
import io.reactivex.Single

class WeatherForecastRemoteData (private val apiWeatherForecastClient: IWeatherForecastApiClient) : IWeatherForecastRemoteData{

    override fun getWeatherForecast(q: String, appid: String): Single<WeatherForecast> {
        return apiWeatherForecastClient.getWeatherForecast(q, appid)
            .map {
                it.body()?.toWeatherForecast() ?: throw Exception(it.errorBody()?.string())
            }
    }
}