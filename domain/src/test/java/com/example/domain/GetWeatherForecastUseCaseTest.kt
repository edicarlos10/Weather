package com.example.domain

import com.example.domain.weather.IWeatherForecastRepository
import com.example.domain.weather.base.Event
import com.example.domain.weather.weatherForecast.model.*
import com.example.domain.weather.weatherForecast.usecase.GetWeatherForecastUseCase
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import io.reactivex.Single
import org.junit.Test

class GetWeatherForecastUseCaseTest : BaseTest() {
    @RelaxedMockK
    private lateinit var repository: IWeatherForecastRepository

    @InjectMockKs
    private lateinit var useCase: GetWeatherForecastUseCase

    private val expected = WeatherForecast(
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
    fun `Check return WeatherForecast`() {
        every {
            repository.getWeatherForecast(
                "London",
                appid
            )
        } returns
                Single.just(expected)

        useCase.execute("London", appid)
            .test()
            .assertValueAt(0, Event.loading())
            .assertValueAt(1) { (it as Event.Data).data == expected }
    }

    @Test
    fun `Check return WeatherForecast error`() {
        every {
            repository.getWeatherForecast(
                "London",
                appid
            )
        } returns Single.error(mockErrorResponse)

        useCase.execute("London", appid)
            .test()
            .assertValueAt(0, Event.loading())
            .assertValueAt(1, Event.error(mockErrorResponse))
    }
}