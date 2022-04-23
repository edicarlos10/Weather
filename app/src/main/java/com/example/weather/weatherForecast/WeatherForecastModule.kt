package com.example.weather.weatherForecast

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val weatherForecastModule = module {
    viewModel<WeatherForecastViewModel>()
}