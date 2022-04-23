package com.example.domain.weather.weatherForecast.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal

@Parcelize
data class Coord(
    val lat: BigDecimal? = 0.toBigDecimal(), // 51.51
    val lon: BigDecimal? = 0.toBigDecimal() // -0.13
): Parcelable