package com.example.weather.weatherForecast

import com.example.domain.weather.IWeatherForecastRepository
import com.example.domain.weather.weatherForecast.usecase.GetWeatherForecastUseCase
import com.example.network.weather.weatherForecast.WeatherForecastRepository
import com.example.network.weather.weatherForecast.remote.IWeatherForecastRemoteData
import com.example.network.weather.weatherForecast.remote.WeatherForecastRemoteData
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val weatherForecastModule = module {
    viewModel { WeatherForecastViewModel(scheduler = get(), getWeatherForecastUseCase = get()) }
    factory { GetWeatherForecastUseCase(repository = get()) }
    single<IWeatherForecastRepository> { WeatherForecastRepository(forecastRemoteData =  get()) }
    factory<IWeatherForecastRemoteData> { WeatherForecastRemoteData(apiWeatherForecastClient =  get()) }
}