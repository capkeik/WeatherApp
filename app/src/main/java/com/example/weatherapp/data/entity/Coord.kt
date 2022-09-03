package com.example.weatherapp.data.entity

import com.google.gson.annotations.SerializedName

data class Coord(
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double
)
