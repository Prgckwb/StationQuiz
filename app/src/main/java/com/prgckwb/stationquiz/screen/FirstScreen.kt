package com.prgckwb.stationquiz.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.prgckwb.stationquiz.R

// タイトル画面の組み立てコンポーザブル
@Composable
fun DisplayTitleScreen(navController: NavController) {
    Column {
        TitleText()
        Image(
            painter = painterResource(id = R.drawable.wabu_star),
            contentDescription = "わぶすたー",
            alignment = Alignment.Center
        )
        StartButton(navController = navController)
        DictionaryButton(navController = navController)
    }
}

@Composable
fun TitleText() {
    Text(
        text = "Station Quiz!!",
        style = MaterialTheme.typography.h1,
        modifier = Modifier
            .padding(32.dp)
            .fillMaxWidth()
            .fillMaxHeight(0.3f)
    )
}

@Composable
fun StartButton(navController: NavController) {
    Button(
        onClick = { navController.navigate("gameScreen") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
    ) {
        Text(
            text = "GAME START",
        )
    }
}

@Composable
fun DictionaryButton(navController: NavController){
    Button(
        onClick = { navController.navigate("dictionaryScreen") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
    ) {
        Text(
            text = "駅リスト",
        )
    }
}


@Preview(showBackground = true)
@Composable
fun TitlePreview() {
    TitleText()
}