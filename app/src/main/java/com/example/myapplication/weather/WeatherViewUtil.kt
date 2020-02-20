package com.example.myapplication.weather

import android.content.Context
import java.text.SimpleDateFormat
import java.util.*

object WeatherViewUtil {
    @JvmStatic
    fun dateToString(date: Date?, context: Context): String? {
        date ?: return null
        return SimpleDateFormat(
            "YYYY.mm.dd HH:DD",
            context.resources.configuration.locale
        ).format(date)
    }

}