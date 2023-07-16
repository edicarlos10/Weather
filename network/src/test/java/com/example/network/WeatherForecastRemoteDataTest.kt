package com.example.network

import com.example.network.base.BaseTest
import com.example.network.weather.weatherForecast.remote.WeatherForecastRemoteData
import com.example.network.weather.weatherForecast.remote.api.IWeatherForecastApiClient
import com.example.network.weather.weatherForecast.remote.response.CloudsResponse
import com.example.network.weather.weatherForecast.remote.response.CoordResponse
import com.example.network.weather.weatherForecast.remote.response.MainResponse
import com.example.network.weather.weatherForecast.remote.response.SysResponse
import com.example.network.weather.weatherForecast.remote.response.WeatherForecastResponse
import com.example.network.weather.weatherForecast.remote.response.WeatherResponse
import com.example.network.weather.weatherForecast.remote.response.WindResponse
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.reactivex.Single
import org.junit.Test
import retrofit2.Response

class WeatherForecastRemoteDataTest : BaseTest() {
    lateinit var remoteData: WeatherForecastRemoteData

    @RelaxedMockK
    lateinit var client: IWeatherForecastApiClient

    private fun responseWeatherForecast(): Response<WeatherForecastResponse> {
        return Response.success(
            WeatherForecastResponse(
                base = "Outono",
                clouds = CloudsResponse(
                    all = 90
                ),
                cod = 200, // 200
                coord = CoordResponse(
                    lat = 22.toBigDecimal(),
                    long = 22.toBigDecimal()
                ),
                dt = 1485789600,
                id = 2643743,
                main = MainResponse(
                    humidity = 81, // 81
                    pressure = 1012, // 1012
                    temp = 290.toBigDecimal(), // 280.32
                    temp_max = 289.toBigDecimal(), // 281.15
                    temp_min = 287.toBigDecimal() // 279.15
                ),
                name = "London", // London
                sys = SysResponse(
                    country = "GB", // GB
                    id = 5091, // 5091
                    message = 0.0103.toBigDecimal(), // 0.0103
                    sunrise = 1485762037, // 1485762037
                    sunset = 1485762037, // 1485794875
                    type = 1 // 1
                ),
                visibility = 10000, // 10000
                weather = listOf(
                    WeatherResponse(
                        description = "light intensity drizzle", // light intensity drizzle
                        icon = "09d", // 09d
                        id = 300, // 300
                        main = "Drizzl" // Drizzl
                    )
                ),
                wind = WindResponse(
                    deg = 80, // 80
                    speed = 4.1.toBigDecimal() // 4.1) = null
                )
            )
        )
    }

    override fun initialize() {
        super.initialize()

        remoteData = WeatherForecastRemoteData(client)
    }

    @Test
    fun `Should get weather forecast from API`(){
        every { client.getWeatherForecast("Catanduva", "")}returns
                Single.just(responseWeatherForecast())

        remoteData.getWeatherForecast("Catanduva", "")
            .test()
            .assertValue(responseWeatherForecast().body()?.toWeatherForecast() )

    }
}