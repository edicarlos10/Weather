package com.example.network.weather.search.remote.response

import com.example.domain.weather.search.model.Weather

data class WeatherResponse(var city: String?){

    fun toWeather(): Weather = Weather()

}
