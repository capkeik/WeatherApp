package com.example.weatherapp.ui.vm

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherapp.data.entity.CityInfo
import com.example.weatherapp.data.repository.WeatherRepository
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val weatherRepository = WeatherRepository()
    private val _cityList = listOf<CityInfo>().toMutableStateList()
    private val _searchQuery = mutableStateOf("")

    val searchQuery: String
        get() = _searchQuery.value
    val cityList: List<CityInfo>
        get() = _cityList

    private val lat = 54.7887
    private val lon = 49.1221
    var res = mutableStateOf("Nihuya")
    fun updateCityList() {
        Log.e("dmsk", "mdkasnfl")
        viewModelScope.launch {
            weatherRepository.getWeatherList(
                lat,
                lon,
                10
            ).forEach {
                _cityList.add(it)
            }
        }
    }

    fun searchCity() {
        viewModelScope.launch {
            res.value = try {
                Log.e("dmsk", "fmdsokan")
                val city = weatherRepository.getWeather(searchQuery)
                Log.e("dmsk", city.toString())

                city.name + " " + city.main.temp.toString()
            } catch (e: Exception) {
                "Failed"
            }

        }
    }

    fun setSearchQuery(value: String) {
        _searchQuery.value = value
    }
}