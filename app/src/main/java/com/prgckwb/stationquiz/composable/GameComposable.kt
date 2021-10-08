package com.prgckwb.stationquiz.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.prgckwb.stationquiz.game.GameModel

//　何問目かとスコアを表示する
@Composable
fun PrintScore(score: Int, questionNum: Int, wasCorrect: Boolean) {
    val color = if (wasCorrect) Color.Red else Color.Blue
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = "${questionNum}問目",
            Modifier.fillMaxWidth(0.5f),
            style = MaterialTheme.typography.h5)
        Text(
            text = "Score : $score",
            Modifier.fillMaxWidth(0.5f),
            color = color,
            style = MaterialTheme.typography.h5)
    }
}

//　路線名と方向（上り方面か下り方面か）を表示
@Composable
fun ShowLineAndDirection(gameModel: GameModel) {
    Column {
        Text(
            text = gameModel.line.lineName,
            style = MaterialTheme.typography.h4,
            color = gameModel.line.lineColor,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = gameModel.line.getLineDirectText(1),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Center,

            )
    }
}


// 駅名表示
@Composable
fun StationName(gameModel: GameModel) {
    Text(
        text = gameModel.currentStation.name,
        style = MaterialTheme.typography.h2,
    )
}

// 問題文表示
@Composable
fun QuestionText(step: Int) {
    Text(
        text = "${step}つ次の駅は?",
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.h6
    )
}

@Composable
fun DebugText(gameModel: GameModel, text: String, step: Int) {
    Column {
//        Text(text = "入力中: $text")
        Text(text = "正解:  ${gameModel.line.stations[(gameModel.stationIndex + step) % gameModel.totalStationsNum].name}")
    }
}
