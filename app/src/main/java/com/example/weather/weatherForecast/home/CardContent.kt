package com.example.weather.weatherForecast.home

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.domain.weather.weatherForecast.model.WeatherForecast
import com.example.weather.extension.convertLongToTime

@Composable
fun CardContent(weather: WeatherForecast?) {
    var expanded by remember { mutableStateOf(false) }
    val linkToImg = "https://openweathermap.org/img/wn/"

    Card(
        modifier = Modifier.padding(vertical = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(12.dp)
            ) {
                val placeName = weather?.name ?: ""
                val placeDate = weather?.dt?.toLong() ?: 0

                Text(text = "$placeName, ${placeDate.convertLongToTime()}")
                Row {
                    AsyncImage(
                        model = linkToImg + weather?.weather?.get(0)?.icon + "@2x.png",
                        contentDescription = "imagem do clima"
                    )
                    Text(
                        text = weather?.weather?.get(0)?.main ?: "",
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontWeight = FontWeight.ExtraBold
                        )
                    )
                }

                if (expanded) {
                    Text(
                        modifier = Modifier.padding(top = 16.dp),
                        text = (weather?.weather?.get(0)?.description ?: ""),
                    )
                }
            }
            IconButton(onClick = { expanded = !expanded }) {
                Icon(
                    imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = if (expanded) {
                        ""
                    } else {
                        ""
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardContentPreview() {
    CardContent(null)
}