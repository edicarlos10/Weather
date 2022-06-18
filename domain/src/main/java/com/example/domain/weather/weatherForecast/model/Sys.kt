package com.example.domain.weather.weatherForecast.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Parcelize
data class Sys(
    val country: String? = "", // GB
    val id: Int? = 0, // 5091
    val message: BigDecimal? = 0.toBigDecimal(), // 0.0103
    val sunrise: Int? = 0, // 1485762037
    val sunset: Int? = 0, // 1485794875
    val type: Int? = 0 // 1
): Parcelable