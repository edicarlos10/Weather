package com.example.network.weather.weatherForecast.remote.api

import com.example.network.weather.weatherForecast.remote.response.WeatherForecastResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IWeatherForecastApiClient {
    @GET("data/2.5/weather")
    fun getWeatherForecast(
        @Query("q") q: String,
        @Query("appid") appid: String,
        @Query("lang") lang: String = "pt_br",
        @Query("units") units: String = "metric"
    ): Single<Response<WeatherForecastResponse>>
}