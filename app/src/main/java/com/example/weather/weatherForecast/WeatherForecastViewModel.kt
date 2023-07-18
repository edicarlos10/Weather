package com.example.weather.weatherForecast

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.weather.base.Event
import com.example.domain.weather.util.ISchedulerProvider
import com.example.domain.weather.weatherForecast.model.WeatherForecast
import com.example.domain.weather.weatherForecast.usecase.GetWeatherForecastUseCase
import com.example.weather.base.BaseViewModel
import io.reactivex.rxkotlin.addTo

class WeatherForecastViewModel(
    scheduler: ISchedulerProvider,
    private val getWeatherForecastUseCase: GetWeatherForecastUseCase
) :
    BaseViewModel(scheduler) {

    private val _error = MutableLiveData<Event.Error?>()
    val error: LiveData<Event.Error?>
        get() = _error

    private val _loading = MutableLiveData<Boolean?>()
    val loading: LiveData<Boolean?>
        get() = _loading

    private val _weatherForecast = MutableLiveData<WeatherForecast?>()
    val weatherForecast: LiveData<WeatherForecast?>
        get() = _weatherForecast

    private val _weatherForecastState = MutableLiveData<Event<WeatherForecast?>>()
    val weatherForecastState: LiveData<Event<WeatherForecast?>>
        get() = _weatherForecastState

    //for xml context
    fun getWeatherForecast(q: String, appid: String) {
        getWeatherForecastUseCase.execute(q, appid)
            .subscribeOn(scheduler.backgroundThread())
            .observeOn(scheduler.mainThread())
            .subscribe {
                _loading.value = it.isLoading()
                when (it) {
                    is Event.Data<*> -> {
                        _weatherForecast.value = it.data as WeatherForecast
                    }
                    is Event.Error -> {
                        _error.value = it
                    }
                    else -> Unit
                }
            }.addTo(disposables)
    }

    fun getWeather(q: String, appid: String) {
        getWeatherForecastUseCase.execute(q, appid)
            .subscribeOn(scheduler.backgroundThread())
            .observeOn(scheduler.mainThread())
            .subscribe {
                _weatherForecastState.value = it
            }.addTo(disposables)
    }

    fun setLoading(){
        _weatherForecastState.value = Event.loading()
    }
}