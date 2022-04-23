package com.example.network.weather.weatherForecast.remote.response

import com.example.domain.weather.weatherForecast.model.Coord
import java.math.BigDecimal

data class CoordResponse(
    val lat: BigDecimal? = null,
    val long: BigDecimal? = null
) {
    fun toCoord(): Coord = Coord(
        lat,
        long
    )
}
