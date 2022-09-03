package com.example.weatherapp.data.api

import com.example.weatherapp.data.entity.CityList
import com.example.weatherapp.data.entity.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("find?units=metric&lang=ru")
    suspend fun getWeatherList(
        @Query("lat") lat:Double,
        @Query("lon") lon:Double,
        @Query("cnt") count:Int
    ): CityList

    @GET("weather?units=metric")
    suspend fun getWeather(
        @Query("id") id: Int) : WeatherResponse

    @GET("weather?units=metric")
    suspend fun getWeather(
        @Query("q") name: String): WeatherResponse
}
