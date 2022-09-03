package com.example.weatherapp.ui.vm

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.entity.CityInfo
import com.example.weatherapp.data.repository.WeatherRepository
import kotlinx.coroutines.launch

class CityDetailsViewModel: ViewModel() {
    private val repository = WeatherRepository()
    private val id: Int = 570990
    private var _city = mutableStateOf<CityInfo?>(null)
    val city: CityInfo?
        get() = _city.value

    fun getCity() {
        viewModelScope.launch {
            _city.value = repository.getWeather(id)
        }
    }
}