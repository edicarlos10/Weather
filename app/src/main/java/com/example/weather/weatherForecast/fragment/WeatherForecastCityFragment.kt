package com.example.weather.weatherForecast.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.domain.weather.base.Event
import com.example.domain.weather.weatherForecast.model.WeatherForecast
import com.example.weather.databinding.FragmentWeatherForecastCityBinding
import com.example.weather.weatherForecast.WeatherForecastViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherForecastCityFragment : Fragment() {
    companion object{
        private const val appid = "58611e500e6bfe3dd41851e99a88a932"   //Weather api key
    }

    private val searchViewModel by viewModel<WeatherForecastViewModel>()
    private var _binding: FragmentWeatherForecastCityBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstance: Bundle?) {
        super.onCreate(savedInstance)
        searchViewModel.weatherForecast.observe(this) { onData(it) }
        searchViewModel.error.observe(this) { onError(it) }
        searchViewModel.loading.observe(this) { onLoding(it) }
    }

    override fun onCreateView(
        inflator: LayoutInflater,
        container: ViewGroup?,
        savedInstance: Bundle?
    ): View {
        _binding = FragmentWeatherForecastCityBinding.inflate(inflator, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchViewModel.getWeatherForecast("", appid)
    }

    private fun onData(weatherForecast: WeatherForecast?) {
        weatherForecast.let {
            TODO("do something")
        }
    }

    private fun onLoding(loading: Boolean?) {
        TODO("Not yet implemented")
    }

    private fun onError(error: Event.Error?) {
        if (error == null)
            return
    }
}