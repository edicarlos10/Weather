package com.example.domain.weather.weatherForecast.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Parcelize
data class Main(
    val humidity: Int? = 0, // 81
    val pressure: Int? = 0, // 1012
    val temp: BigDecimal? = 0.toBigDecimal(), // 280.32
    val temp_max: BigDecimal? = 0.toBigDecimal(), // 281.15
    val temp_min: BigDecimal? = 0.toBigDecimal() // 279.15
): Parcelable