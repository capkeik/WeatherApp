package com.example.weatherapp.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherapp.data.entity.CityInfo
import com.example.weatherapp.data.entity.Main
import com.example.weatherapp.ui.vm.CityDetailsViewModel

@Composable
fun CityDetailsScreen(cityId: Int) {
    val viewModel: CityDetailsViewModel = viewModel()
    LaunchedEffect(key1 = 1) {
        viewModel.setCityId(cityId)
        viewModel.getCity()
    }
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        viewModel.city?.let {
            Text(it.name)
            Text(it.main.temp.toString())
            DetailsBlock(it)
        } ?: Text("Something went wrong")
    }
}

@Composable
fun DetailsBlock(cityInfo: CityInfo) {
    Card() {
        Column() {
            Row() {
                Text(text = "${cityInfo.wind.degree.toString()} ")
                Text(text = "${cityInfo.wind.speed.toString()} m/s")
                Text(text = "${cityInfo.wind.gust.toString()} ")
            }
            Row() {
                Text(text = "${cityInfo.main.feelsLike.toString()} ")
                Text(text = "${cityInfo.main.humidity.toString()} ")
                Text(text = "${cityInfo.main.pressure.toString()} ")
            }
        }
    }
}

