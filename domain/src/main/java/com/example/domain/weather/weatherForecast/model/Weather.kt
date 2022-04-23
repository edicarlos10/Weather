package com.example.domain.weather.weatherForecast.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Weather(
    val description: String? = "", // light intensity drizzle
    val icon: String? = "", // 09d
    val id: Int? = 0, // 300
    val main: String? = "" // Drizzle
): Parcelable