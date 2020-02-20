package com.example.myapplication.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val cityId: String,
    private val repository: WeatherRepository
) : ViewModel() {
    private var _weather: WeatherRepository.Weather? = null
        set(value) {
            field = value
            (weather as MutableLiveData).postValue(value)
        }
    val weather: LiveData<WeatherRepository.Weather> = MutableLiveData()

    private var _isLoading = true
        set(value) {
            field = value
            (isLoading as MutableLiveData).postValue(value)
        }
    val isLoading: LiveData<Boolean> = MutableLiveData(_isLoading)

    init {
        viewModelScope.launch {
            val weather: WeatherRepository.Weather? = try {
                repository.loadWeather(cityId)
            } catch (t: Throwable) {
                print(t.message)
                null
            }

            _isLoading = false
            weather?.let { _weather = it }
        }
    }
}