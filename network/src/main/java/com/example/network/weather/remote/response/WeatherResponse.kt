package com.example.network.weather.remote.response

import com.example.domain.weather.model.Weather

data class WeatherResponse(var city: String?){

    fun toWeather(): Weather = Weather()

}
