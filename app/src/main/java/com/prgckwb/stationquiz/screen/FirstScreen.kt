package com.prgckwb.stationquiz.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DisplayFirstScreen(navController: NavController) {
    Column {
        Text(
            text = "Station Quiz!!",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(32.dp)
                .fillMaxWidth(),
        )
        Button(
            onClick = { navController.navigate("gameScreen") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
        ) {
            Text(
                text = "GAME START",
                textAlign = TextAlign.Center
            )
        }
    }
}
