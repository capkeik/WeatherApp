package com.example.weatherapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.weatherapp.navigation.Screen
import com.example.weatherapp.ui.composable.CityDetailsScreen
import com.example.weatherapp.ui.composable.CityListScreen

@Composable
fun App() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.CityList.route
    ) {
        composable(Screen.CityList.route) {
            CityListScreen(navController)
        }

        composable(
            "${Screen.CityDetails.route}/{cityId}",
            arguments = listOf(navArgument("cityId") { type = NavType.IntType})
        ) {
            CityDetailsScreen(it.arguments?.getInt("cityId") ?: 570990)
        }
    }
}