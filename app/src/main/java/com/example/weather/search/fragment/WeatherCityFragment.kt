package com.example.weather.search.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.domain.weather.base.Event
import com.example.domain.weather.search.model.Weather
import com.example.weather.databinding.FragmentWeatherCityBinding
import com.example.weather.search.SearchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherCityFragment : Fragment() {
    companion object{
        private const val publicKey = "58611e500e6bfe3dd41851e99a88a932"   //Weather api key
    }

    private val searchViewModel by viewModel<SearchViewModel>()
    private var _binding: FragmentWeatherCityBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstance: Bundle?) {
        super.onCreate(savedInstance)
        searchViewModel.weather.observe(this) { onData(it) }
        searchViewModel.error.observe(this) { onError(it) }
        searchViewModel.loading.observe(this) { onLoding(it) }
    }

    override fun onCreateView(
        inflator: LayoutInflater,
        container: ViewGroup?,
        savedInstance: Bundle?
    ): View {
        _binding = FragmentWeatherCityBinding.inflate(inflator, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchViewModel.getWeather()
    }

    private fun onData(weather: Weather?) {
        weather.let {
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