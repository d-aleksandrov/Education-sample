package com.example.myapplication.weather

import kotlinx.coroutines.delay
import java.util.*

class WeatherRepositoryFaked : WeatherRepository {
    override suspend fun loadWeather(cityId: String): WeatherRepository.Weather {
        delay(1000L)
        return WeatherRepository.Weather(
            cityId = cityId,
            date = Date(),
            temperature = 15.0,
            humidity = 55.0
        )
    }

}