package com.prgckwb.stationquiz.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.prgckwb.stationquiz.game.keioLine
import com.prgckwb.stationquiz.ui.theme.StationQuizTheme

@Composable
fun DisplayGameScreen() {
    StationQuizTheme {
        Surface(color = MaterialTheme.colors.background) {
            Column {
                PrintScore()
                RandomStation()
                WriteAnswerArea()
            }
        }
    }
}

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
    }
}

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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DisplayGameScreen()
}