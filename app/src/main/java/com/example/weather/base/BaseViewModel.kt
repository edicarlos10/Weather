package com.example.weather.base

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import com.example.domain.weather.util.ISchedulerProvider
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel (protected val scheduler: ISchedulerProvider) : ViewModel(){
    protected val disposables = CompositeDisposable()

    @CallSuper
    override fun onCleared() {
        disposables.clear()
    }
}