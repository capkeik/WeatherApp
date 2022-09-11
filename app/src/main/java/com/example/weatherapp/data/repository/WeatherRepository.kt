package com.example.weatherapp.data.repository

import com.example.weatherapp.data.api.ApiService
import com.example.weatherapp.data.entity.CityInfo
import com.example.weatherapp.data.mapper.CityInfoMapper

class WeatherRepository {
    val api: ApiService = ApiService
    val mapper: CityInfoMapper = CityInfoMapper()

    suspend fun getWeatherList(lat: Double, lon: Double, count: Int): List<CityInfo> {
        val oldList = api.weatherApi.getWeatherList(lat, lon, count)
        return List(20) {
            mapper(oldList.list[it])
        }
    }

    suspend fun getWeather(id: Int) =
        mapper(
            api.weatherApi.getWeather(id)
        )


    suspend fun getWeather(name: String) =
        mapper(
            api.weatherApi.getWeather(name)
        )

}
