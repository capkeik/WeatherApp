package com.example.weatherapp.data.entity

data class CityInfo(
    val id: Int,
    val name: String,
    val main: Main,
    val wind: Wind
)
