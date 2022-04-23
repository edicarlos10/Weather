package com.example.domain.weather.weatherForecast.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Clouds(
    val all: Int? = 0 // 90
): Parcelable