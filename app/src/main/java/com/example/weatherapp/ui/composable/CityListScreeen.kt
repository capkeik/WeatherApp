package com.example.weatherapp.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.weatherapp.data.entity.CityInfo
import com.example.weatherapp.navigation.Screen
import com.example.weatherapp.ui.ColorTransformer
import com.example.weatherapp.ui.vm.MainViewModel
import kotlinx.coroutines.launch

@Composable
fun CityListScreen(navController: NavController) {
    val viewModel: MainViewModel = viewModel()
    LaunchedEffect(key1 = 1, block = {
        launch {
            viewModel.updateCityList()
        }
    })
    Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                    .padding(4.dp)
                    .fillMaxSize()
    ) {
        CityList(viewModel.cityList) { id ->
            navController.navigate("${Screen.CityDetails.route}/$id")
        }
    }
}

@Composable
fun CityList(cityList: List<CityInfo>, onItemClick: (Int) -> Unit) {
    LazyColumn(
            modifier = Modifier
                    .padding(4.dp)
    ) {
        items(cityList) {
            CityListItem(it, onItemClick)
        }
    }
}

@Composable
fun CityListItem(cityInfo: CityInfo, onClick: (Int) -> Unit) {
    Card(
            modifier = Modifier
                    .padding(4.dp)
                    .clickable { onClick(cityInfo.id) }
    ) {
        Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
        ) {
            Text(
                    fontSize = 24.sp,
                    text = cityInfo.name
            )
            Text(
                    color = ColorTransformer.getColor(cityInfo.main.temp.toInt()),
                    fontSize = 24.sp,
                    text = cityInfo.main.temp.toInt().toString()
            )
        }
    }
}
