package com.example.myapplication.weather

import java.util.*

interface WeatherRepository {
    suspend fun loadWeather(cityId: String): Weather

    class Weather(
        val cityId: String,
        val date: Date,
        val temperature: Double,
        val humidity: Double
    )
}