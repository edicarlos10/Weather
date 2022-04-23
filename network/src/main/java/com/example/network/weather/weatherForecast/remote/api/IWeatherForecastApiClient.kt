package com.example.network.weather.weatherForecast.remote.api

import com.example.network.weather.weatherForecast.remote.response.WeatherForecastResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IWeatherForecastApiClient {
    @GET("https://api.openweathermap.org/data/2.5/weather?q={q}&appid={appid}")
    fun getWeatherForecast(
        @Path("q") q: String,
        @Path("appid") appid: String
    ): Single<Response<WeatherForecastResponse>>
}