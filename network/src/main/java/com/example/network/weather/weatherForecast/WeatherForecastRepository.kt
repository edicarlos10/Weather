package com.example.network.weather.weatherForecast

import com.example.domain.weather.IWeatherForecastRepository
import com.example.domain.weather.base.ThrowableBase
import com.example.domain.weather.weatherForecast.model.WeatherForecast
import com.example.network.weather.weatherForecast.remote.IWeatherForecastRemoteData
import io.reactivex.Single

class WeatherForecastRepository (private val forecastRemoteData: IWeatherForecastRemoteData) : IWeatherForecastRepository {
    override fun getWeatherForecast(q: String, appid: String): Single<WeatherForecast> {
        return forecastRemoteData.getWeatherForecast(q, appid)
            .onErrorResumeNext { ThrowableBase.parseError(it).toSingleError()}
    }

}