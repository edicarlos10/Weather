package com.example.network.weather.weatherForecast.remote.response

import com.example.domain.weather.weatherForecast.model.Wind
import java.math.BigDecimal

data class WindResponse(
    val deg: Int? = null,
    val speed: BigDecimal? = null
) {
    fun toWind(): Wind = Wind(
        deg,
        speed
    )
}
