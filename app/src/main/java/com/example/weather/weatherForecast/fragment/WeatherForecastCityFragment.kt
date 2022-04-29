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
        fun newInstance() : WeatherForecastCityFragment{
            val args = Bundle().apply {  }
            val fragment = WeatherForecastCityFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private val weatherForecastViewModel: WeatherForecastViewModel by viewModel()
    private var _binding: FragmentWeatherForecastCityBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstance: Bundle?) {
        super.onCreate(savedInstance)
        weatherForecastViewModel.weatherForecast.observe(this) { onData(it) }
        weatherForecastViewModel.error.observe(this) { onError(it) }
        weatherForecastViewModel.loading.observe(this) { onLoading(it) }
    }

    override fun onCreateView(
        inflator: LayoutInflater,
        container: ViewGroup?,
        savedInstance: Bundle?
    ): View {
        _binding = FragmentWeatherForecastCityBinding.inflate(inflator, container, false)
        return binding.root
    }

    external fun stringFromJNI(): String?

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        weatherForecastViewModel.getWeatherForecast("Catanduva", appid)
    }

    private fun onData(weatherForecast: WeatherForecast?) {
        weatherForecast.let {
            binding.textMain.text = it?.weather?.get(0)?.description
        }
    }

    private fun onLoading(loading: Boolean?) {
        loading?.let {
            if (it) binding.textMain.visibility = View.GONE
            else
                binding.textMain.visibility = View.VISIBLE
        }
    }

    private fun onError(error: Event.Error?) {
        if (error == null)
            return
    }
}