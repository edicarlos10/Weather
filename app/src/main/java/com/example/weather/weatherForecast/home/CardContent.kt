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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.domain.weather.weatherForecast.model.WeatherForecast
import com.example.weather.R
import com.example.weather.extension.convertLongToTime
import java.math.RoundingMode

@Composable
fun CardContent(weather: WeatherForecast?) {
    var expanded by remember { mutableStateOf(false) }
    val linkToImg by remember { mutableStateOf("https://openweathermap.org/img/wn/") }
    val placeName by remember { mutableStateOf(weather?.name ?: "") }
    val placeDate by remember { mutableStateOf(weather?.dt?.toLong() ?: 0) }
    val weatherDescription by remember {
        mutableStateOf(
            weather?.weather?.get(0)?.description?.replaceFirstChar(Char::titlecase) ?: ""
        )
    }
    val weatherMaxMin by remember {
        mutableStateOf(
            "Max/Min: " + weather?.main?.temp_max?.setScale(
                0, RoundingMode.HALF_EVEN
            )?.toString() + "°/" + weather?.main?.temp_min?.setScale(
                0, RoundingMode.HALF_EVEN
            )?.toString() + "°"
        )
    }
    val weatherHumidity by remember {
        mutableStateOf("Humidade: " + weather?.main?.humidity?.toString() + "%")
    }

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
                Text(text = "$placeName, ${placeDate.convertLongToTime()}")
                Row(
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(context = LocalContext.current)
                            .data(linkToImg + weather?.weather?.get(0)?.icon + "@2x.png")
                            .crossfade(true).build(),
                        error = painterResource(R.drawable.ic_broken_image),
                        placeholder = painterResource(R.drawable.loading_animation),
                        contentDescription = "imagem do clima",
                        contentScale = ContentScale.FillBounds
                    )
                    Text(
                        text = weatherDescription,
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight.ExtraBold
                        )
                    )
                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight.SemiBold
                        ),
                        text = (weather?.main?.temp?.setScale(0, RoundingMode.HALF_EVEN)
                            ?.toString() + "°"),
                    )
                }

                if (expanded) {
                    Text(
                        modifier = Modifier.padding(top = 16.dp),
                        text = weatherMaxMin,
                    )
                    Text(
                        modifier = Modifier.padding(top = 8.dp),
                        text = weatherHumidity,
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