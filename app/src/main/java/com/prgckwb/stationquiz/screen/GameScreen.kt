package com.prgckwb.stationquiz.screen

import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.prgckwb.stationquiz.game.keioLine
import com.prgckwb.stationquiz.ui.theme.StationQuizTheme

// ゲーム画面の組み立てコンポーザブル
@Composable
fun DisplayGameScreen(navController: NavController) {
    StationQuizTheme {
        Surface(color = MaterialTheme.colors.background) {
            Column {
                PrintScore()
                RandomStation()
                WriteAnswerArea()
                BackButton(navController)
            }
        }
    }
}

//　何問目かとスコアを表示する
@Composable
fun PrintScore() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = "０問目", Modifier.fillMaxWidth(0.5f))
        Text(text = "Score : 30", Modifier.fillMaxWidth(0.5f))
    }
}


//　駅をランダムで表示して、ボタンを押すとその処理を繰り返す
@Composable
fun RandomStation() {
    var station by remember { mutableStateOf(keioLine.random()) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = station.name,
            style = MaterialTheme.typography.h2,
        )
        Spacer(Modifier.padding(16.dp))
        Button(onClick = {
            station = keioLine.random()

        }) {
            Text(text = "駅を変える")
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            text = "What is the next station?",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.caption
        )
    }
}

// 回答欄のテキストフィールド
@Composable
fun WriteAnswerArea() {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(text = "回答欄") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        maxLines = 1
    )
}

// もどるボタン
@Composable
fun BackButton(navController: NavController){
    Button(
        onClick = { navController.navigate("titleScreen") },
        modifier = Modifier.padding(8.dp)
    ) {
        Text(text = "もどる",)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Column {
        PrintScore()
        RandomStation()
        WriteAnswerArea()
    }
}