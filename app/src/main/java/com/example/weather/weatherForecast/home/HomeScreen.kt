package com.example.weather.weatherForecast.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.domain.weather.base.Event
import com.example.weather.weatherForecast.WeatherForecastViewModel

@Composable
fun HomeScreen(weatherForecastViewModel: WeatherForecastViewModel? = null, appid: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        AppBar()
        Search(weatherForecastViewModel, appid)
        Body(weatherForecastViewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    TopAppBar(
        title = { Text(text = "Previsão do tempo") }
    )
}

@Composable
fun Body(weatherForecastViewModel: WeatherForecastViewModel?) {
    val weatherState = weatherForecastViewModel?.weatherForecastState?.observeAsState()

    weatherState?.value?.let { state ->
        when (state) {
            is Event.Data -> {
                CardContent(state.data)
            }

            is Event.Loading -> {
                OnLoading()
            }

            is Event.Error -> {
                Error()
            }

            else -> Unit
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        null, ""
    )
}