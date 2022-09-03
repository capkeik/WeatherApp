package com.example.weatherapp.data.entity

import com.example.weatherapp.data.entity.WeatherResponse
import com.google.gson.annotations.SerializedName

data class CityList(
    @SerializedName("list")
    val list: List<WeatherResponse>,
)
