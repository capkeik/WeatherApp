package com.example.weatherapp.data.entity

import com.google.gson.annotations.SerializedName

data class Precipiration(
    @SerializedName("valueP")
    val valueP: Double,
)
