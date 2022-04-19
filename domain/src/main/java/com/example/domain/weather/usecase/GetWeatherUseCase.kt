package com.example.domain.weather.usecase

import com.example.domain.weather.IweatherRepository
import com.example.domain.weather.base.Event
import com.example.domain.weather.model.Weather
import com.example.domain.weather.base.ThrowableBase
import io.reactivex.Observable

class GetWeatherUseCase (
    private val repository: IweatherRepository
){
    fun execute(): Observable<Event<Weather>> {
        return Observable.concat(Observable.just(Event.loading()), getWeather())
    }

    private fun getWeather(): Observable<Event<Weather>>? {
        return repository.getWeather()
            .map { Event.data(it) }
            .onErrorReturn { throwable ->
                (throwable as? ThrowableBase)?.let {
                    Event.error(it.type, it)
                } ?: Event.error(throwable)
            }.toObservable()
    }
}