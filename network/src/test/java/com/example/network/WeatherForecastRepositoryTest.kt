package com.example.network

import com.example.domain.weather.weatherForecast.model.Clouds
import com.example.domain.weather.weatherForecast.model.Coord
import com.example.domain.weather.weatherForecast.model.Main
import com.example.domain.weather.weatherForecast.model.Sys
import com.example.domain.weather.weatherForecast.model.Weather
import com.example.domain.weather.weatherForecast.model.WeatherForecast
import com.example.domain.weather.weatherForecast.model.Wind
import com.example.network.base.BaseTest
import com.example.network.weather.weatherForecast.WeatherForecastRepository
import com.example.network.weather.weatherForecast.remote.IWeatherForecastRemoteData
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import io.reactivex.Single
import org.junit.Test

class WeatherForecastRepositoryTest : BaseTest() {

    @RelaxedMockK
    lateinit var remote: IWeatherForecastRemoteData

    @InjectMockKs
    lateinit var repository: WeatherForecastRepository

    private val weatherForecastRemoteData =
        WeatherForecast(
            base = "Outono",
            clouds = Clouds(
                all = 90
            ),
            cod = 200, // 200
            coord = Coord(
                lat = 22.toBigDecimal(),
                lon = 22.toBigDecimal()
            ),
            dt = 1485789600,
            id = 2643743,
            main = Main(
                humidity = 81, // 81
                pressure = 1012, // 1012
                temp = 290.toBigDecimal(), // 280.32
                temp_max = 289.toBigDecimal(), // 281.15
                temp_min = 287.toBigDecimal() // 279.15
            ),
            name = "London", // London
            sys = Sys(
                country = "GB", // GB
                id = 5091, // 5091
                message = 0.0103.toBigDecimal(), // 0.0103
                sunrise = 1485762037, // 1485762037
                sunset = 1485762037, // 1485794875
                type = 1 // 1
            ),
            visibility = 10000, // 10000
            weather = listOf(
                Weather(
                    description = "light intensity drizzle", // light intensity drizzle
                    icon = "09d", // 09d
                    id = 300, // 300
                    main = "Drizzl" // Drizzl
                )
            ),
            wind = Wind(
                deg = 80, // 80
                speed = 4.1.toBigDecimal() // 4.1) = null
            )
        )
    @Test
    fun `Should return users`() {

        every { remote.getWeatherForecast("Catanduva", "") } returns
                Single.just(weatherForecastRemoteData)

        repository.getWeatherForecast("Catanduva", "")
            .test()
            .assertValue(weatherForecastRemoteData)
    }

    @Test
    fun `Should return error users`() {
        every {
            remote.getWeatherForecast("Catanduva", "").map {
                throw genericErrorResponse
            }
        } returns
                Single.error(genericErrorResponse)

        repository.getWeatherForecast("Catanduva", "")
            .test()
            .assertError(genericErrorResponse)
    }
}