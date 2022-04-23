package com.example.network.weather.weatherForecast.remote.response

import com.example.domain.weather.weatherForecast.model.Sys
import java.math.BigDecimal

data class SysResponse(
    val country: String? = null, // GB
    val id: Int? = null, // 5091
    val message: BigDecimal? = null, // 0.0103
    val sunrise: Int? = null, // 1485762037
    val sunset: Int? = null, // 1485794875
    val type: Int? = null // 1
) {
    fun toSys(): Sys = Sys(
        country,
        id,
        message,
        sunrise,
        sunset,
        type
    )
}
