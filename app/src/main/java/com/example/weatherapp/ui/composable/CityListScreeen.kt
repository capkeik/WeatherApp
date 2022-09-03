package com.example.weatherapp.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.weatherapp.data.entity.CityInfo
import com.example.weatherapp.navigation.Screen
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
        SearchField(
            onSubmitPressed = { viewModel.searchCity() },
            onValueChange = {
                viewModel.setSearchQuery(it)
            })
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
            CityListItem(it) { }
        }
    }
}

@Composable
fun CityListItem(cityInfo: CityInfo, onClick: (Int) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Card(
            modifier = Modifier
                .padding(4.dp)
                .clickable { onClick(cityInfo.id) }
        ) {
            Text(cityInfo.id.toString())
            Text(cityInfo.name)
            Text(cityInfo.main.temp.toString())
        }
    }
}

@Composable
fun SearchField(onSubmitPressed: () -> Unit, onValueChange: (String) -> Unit) {
    Row() {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            onValueChange = onValueChange,
            shape = RoundedCornerShape(100),
            trailingIcon = {
                IconButton(onClick = onSubmitPressed) {
                    Icon(
                        Icons.Rounded.Search,
                        "Search button"
                    )
                }
            }
        )
    }
}
