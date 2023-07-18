package com.example.weather.weatherForecast.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weather.weatherForecast.WeatherForecastViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search(weatherForecastViewModel: WeatherForecastViewModel?, appid: String) {
    var searchText by remember { mutableStateOf("") }
    var textEmpty by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = searchText, onValueChange = {
            searchText = it
            textEmpty = it.isEmpty()
        },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Digite a localidade para buscar") },
        singleLine = true,
        isError = textEmpty,
        trailingIcon = {
            IconButton(
                onClick = {
                    //viewModel
                    if (searchText.isNotEmpty()) {
                        weatherForecastViewModel?.getWeather(searchText, appid)
                        weatherForecastViewModel?.setLoading()
                    } else {
                        textEmpty = true
                    }
                }
            ) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Icone de Busca")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun SearchPreview() {
    Search(null, "")
}