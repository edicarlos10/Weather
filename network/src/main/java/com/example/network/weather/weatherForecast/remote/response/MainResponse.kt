package com.example.network.weather.weatherForecast.remote.response

import com.example.domain.weather.weatherForecast.model.Main
import java.math.BigDecimal

data class MainResponse(
    val humidity: Int? = null, // 81
    val pressure: Int? = null, // 1012
    val temp: BigDecimal? = null, // 280.32
    val temp_max: BigDecimal? = null, // 281.15
    val temp_min: BigDecimal? = null // 279.15
) {
    fun toMain(): Main = Main(
        humidity,
        pressure,
        temp,
        temp_max,
        temp_min
    )
}
