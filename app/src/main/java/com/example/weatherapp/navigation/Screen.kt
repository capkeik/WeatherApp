package com.example.weatherapp.navigation

sealed class Screen(val route: String) {
    object CityList: Screen("list")
    object CityDetails: Screen("details")
}
