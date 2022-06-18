package com.example.domain.weather.weatherForecast.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Parcelize
data class Wind(
    val deg: Int? = 0, // 80
    val speed: BigDecimal? = 0.toBigDecimal() // 4.1
): Parcelable