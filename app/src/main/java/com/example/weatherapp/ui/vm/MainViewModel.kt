package com.example.weatherapp.ui.vm

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.entity.CityInfo
import com.example.weatherapp.data.repository.WeatherRepository
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val weatherRepository = WeatherRepository()
    private val _cityList = listOf<CityInfo>().toMutableStateList()
    private val _searchQuery = mutableStateOf("")
    private val _foundCity = mutableStateOf(false)
    val foundCity: Boolean
        get() = _foundCity.value

    val cityToGo = 0

    val searchQuery: String
        get() = _searchQuery.value
    val cityList: List<CityInfo>
        get() = _cityList

    private val lat = 54.7887
    private val lon = 49.1221
    var res = mutableStateOf("Nihuya")
    fun updateCityList() {
        if (cityList.isEmpty()) {
            viewModelScope.launch {
                weatherRepository.getWeatherList(
                        lat,
                        lon,
                        20
                ).forEach {
                    _cityList.add(it)
                }
            }
        }
    }

    fun searchCity() {
        try {
            viewModelScope.launch {

                _foundCity.value = true
            }
        } catch(e: Exception) {
            _foundCity.value = false
        }
    }

    fun setSearchQuery(value: String) {
        _searchQuery.value = value
    }

    fun onSearchSuccessful() {
        _foundCity.value = false
    }
}