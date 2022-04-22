package com.example.weather.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.weather.base.Event
import com.example.domain.weather.search.usecase.GetWeatherUseCase
import com.example.domain.weather.util.ISchedulerProvider
import com.example.weather.base.BaseViewModel
import io.reactivex.rxkotlin.addTo

class SearchViewModel(
    scheduler: ISchedulerProvider,
    private val getWeatherUseCase: GetWeatherUseCase
) :
    BaseViewModel(scheduler) {

    private val _error = MutableLiveData<Event.Error?>()
    val error: LiveData<Event.Error?>
        get() = _error

    private val _loading = MutableLiveData<Boolean?>()
    val loading: LiveData<Boolean?>
        get() = _loading

    fun getWeather() {
        getWeatherUseCase.execute()
            .subscribeOn(scheduler.backgroundThread())
            .subscribeOn(scheduler.mainThread())
            .subscribe {
                _loading.value = it.isLoading()
                when (it) {
                    is Event.Data<*> -> {

                    }
                    is Event.Error -> {

                    }
                    else -> Unit
                }
            }.addTo(disposables)
    }
}