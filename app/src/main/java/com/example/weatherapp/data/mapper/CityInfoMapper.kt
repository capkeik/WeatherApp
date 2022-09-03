package com.example.weatherapp.data.mapper

import com.example.weatherapp.data.entity.CityInfo
import com.example.weatherapp.data.entity.WeatherResponse

class CityInfoMapper {
    operator fun invoke(weatherResponse: WeatherResponse): CityInfo {
        return CityInfo(
            weatherResponse.id,
            weatherResponse.name,
            weatherResponse.main,
            weatherResponse.wind
        )
    }
}