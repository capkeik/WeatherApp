package com.example.weatherapp.ui.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 48.dp),
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        viewModel.city?.let {
            Spacer(modifier = Modifier.size(128.dp))

            Text(
                    fontSize = 32.sp,
                    text = it.name
            )
            Spacer(modifier = Modifier.size(64.dp))
            Text(
                    fontSize = 48.sp,
                    text = it.main.temp.toString())
            Spacer(modifier = Modifier.size(72.dp))
            DetailsBlock(it)
        } ?: Text("Something went wrong")
    }
}

@Composable
fun DetailsBlock(cityInfo: CityInfo) {
    Card(
    ) {
        Column() {
            Row() {
                Text(text = "${cityInfo.wind.degree} ")
                Text(text = "${cityInfo.wind.speed} m/s")
                Text(text = "${cityInfo.wind.gust} ")
            }
            Row() {
                Text(text = "${cityInfo.main.feelsLike} ")
                Text(text = "${cityInfo.main.humidity} ")
                Text(text = "${cityInfo.main.pressure} ")
            }
        }
    }
}
