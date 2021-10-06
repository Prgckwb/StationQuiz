package com.prgckwb.stationquiz.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

// タイトル画面の組み立てコンポーザブル
@Composable
fun DisplayTitleScreen(navController: NavController) {
    Column {
        TitleText()
        StartButton(navController = navController)
    }
}

@Composable
fun TitleText(){
    Text(
        text = "Station Quiz!!",
        style = MaterialTheme.typography.h1,
        modifier = Modifier
            .padding(32.dp)
            .fillMaxWidth(),
    )
}

@Composable
fun StartButton(navController: NavController){
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

@Preview(showBackground = true)
@Composable
fun TitlePreview(){
    TitleText()
}