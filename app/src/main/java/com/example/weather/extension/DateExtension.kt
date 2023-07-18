package com.example.weather.extension

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Long.convertLongToTime(): String {
    val date = Date(this)
    val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return format.format(date)
}