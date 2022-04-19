package com.example.network.weather

import com.example.domain.weather.IweatherRepository
import com.example.domain.weather.base.ThrowableBase
import com.example.domain.weather.model.Weather
import com.example.network.weather.remote.IWeatherRemoteData
import io.reactivex.Single

class WeatherRepository (private val remoteData: IWeatherRemoteData) : IweatherRepository {
    override fun getWeather(): Single<Weather> {
        return remoteData.getWeather()
            .onErrorResumeNext { ThrowableBase.parseError(it).toSingleError()}
    }

}