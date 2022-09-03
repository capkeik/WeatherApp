package com.example.weatherapp.data.entity

import com.google.gson.annotations.SerializedName

data class Snow(
    @SerializedName("h1")
    val h1: Double,
    @SerializedName("h3")
    val h3: Double,
)
