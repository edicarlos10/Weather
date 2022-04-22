package com.example.weather.search

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val searchModule = module {
    viewModel<SearchViewModel>()
}