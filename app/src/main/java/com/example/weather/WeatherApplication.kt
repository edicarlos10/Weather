package com.example.weather

import android.app.Application
import com.example.weather.weatherForecast.weatherForecastModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class WeatherApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        initModules()
    }

    private fun initModules(){
        startKoin {
            androidContext(this@WeatherApplication)
            androidLogger(Level.DEBUG)
            modules(weatherForecastModule)
        }
    }
}