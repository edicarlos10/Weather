package com.example.weather.weatherForecast.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.weather.databinding.ActivityWeatherForecastBinding
import com.example.weather.extension.viewBinding
import com.example.weather.weatherForecast.fragment.WeatherForecastCityFragment

class WeatherForecastActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityWeatherForecastBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initFragment()
    }

    private fun initFragment() {
        val weatherForecastCityFragment = WeatherForecastCityFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .add(binding.constraintWeatherForecast.id, weatherForecastCityFragment)
            .commit()
    }
}