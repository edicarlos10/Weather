package com.example.weather.utils.domain

import com.example.domain.weather.util.ISchedulerProvider
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AppSchedulerProvider : ISchedulerProvider {
    override fun mainThread(): Scheduler = AndroidSchedulers.mainThread()
    override fun backgroundThread(): Scheduler = Schedulers.io()
}