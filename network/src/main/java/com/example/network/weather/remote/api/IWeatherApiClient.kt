package com.example.network.weather.remote.api

import com.example.network.weather.remote.response.WeatherResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface IWeatherApiClient {
    @GET("api/")
    fun getWeather(): Single<Response<WeatherResponse>>
}