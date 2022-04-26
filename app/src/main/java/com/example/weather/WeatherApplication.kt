package com.example.weather

import android.app.Application
import com.example.weather.di.networkModule
import com.example.weather.weatherForecast.weatherForecastModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WeatherApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        initModules()
    }

    private fun initModules(){
        startKoin {
            androidContext(this@WeatherApplication)
            modules(networkModule, weatherForecastModule)
        }
    }
}