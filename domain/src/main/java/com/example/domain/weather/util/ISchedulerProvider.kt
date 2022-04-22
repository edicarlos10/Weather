package com.example.domain.weather.util

import io.reactivex.Scheduler

interface ISchedulerProvider {
    fun mainThread(): Scheduler
    fun backgroundThread(): Scheduler
}