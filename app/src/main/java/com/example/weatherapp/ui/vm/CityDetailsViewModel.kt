package com.example.weatherapp.ui.vm

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.entity.CityInfo
import com.example.weatherapp.data.repository.WeatherRepository
import kotlinx.coroutines.launch

class CityDetailsViewModel: ViewModel() {
    private val repository = WeatherRepository()
    private var id: Int = 570990
    private var _city = mutableStateOf<CityInfo?>(null)
    val city: CityInfo?
        get() = _city.value

    fun getCity() {
        viewModelScope.launch {
            Log.e("dmsk", "gone to details")
            _city.value = repository.getWeather(id)
        }
    }

    fun setCityId(id: Int) {
        this.id = id
    }
}
