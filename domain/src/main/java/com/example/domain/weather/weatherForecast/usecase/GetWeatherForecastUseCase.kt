package com.example.domain.weather.weatherForecast.usecase

import com.example.domain.weather.IWeatherForecastRepository
import com.example.domain.weather.base.Event
import com.example.domain.weather.base.ThrowableBase
import com.example.domain.weather.weatherForecast.model.WeatherForecast
import io.reactivex.Observable

class GetWeatherForecastUseCase (
    private val repository: IWeatherForecastRepository
){
    fun execute(q: String, appid: String): Observable<Event<WeatherForecast>> {
        return Observable.concat(Observable.just(Event.loading()), getWeatherForecast(q, appid))
    }

    private fun getWeatherForecast(q: String, appid: String): Observable<Event<WeatherForecast>>? {
        return repository.getWeatherForecast(q, appid)
            .map { Event.data(it) }
            .onErrorReturn { throwable ->
                (throwable as? ThrowableBase)?.let {
                    Event.error(it.type, it)
                } ?: Event.error(throwable)
            }.toObservable()
    }
}