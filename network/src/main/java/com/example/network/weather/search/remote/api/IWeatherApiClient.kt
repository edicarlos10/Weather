package com.example.network.weather.search.remote.api

import com.example.network.weather.search.remote.response.WeatherResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IWeatherApiClient {
    @GET("https://api.openweathermap.org/data/2.5/weather?q={q}&appid={appid}")
    fun getWeather(
        @Path("q") q: String,
        @Path("appid") appid: String
    ): Single<Response<WeatherResponse>>
}