package com.example.weather.weatherForecast.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.weather.R
import com.example.weather.databinding.ActivityWeatherForecastBinding
import com.example.weather.extension.viewBinding

class WeatherForecastActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityWeatherForecastBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initFragment()
    }

    private fun initFragment() {
       findNavController(R.id.constraintWeatherForecast).navigate(R.id.frameWeatherForecastCity)
    }
}