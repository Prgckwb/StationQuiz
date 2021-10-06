package com.prgckwb.stationquiz.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun DisplayFirstScreen(navController: NavController) {
    Column {
        Text(text = "Station Quiz!!")
        Button(onClick = { navController.navigate("secondScreen") }) {
            Text(text = "GAME START")
        }
    }
}
