package com.prgckwb.stationquiz.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.prgckwb.stationquiz.game.GameModel
import com.prgckwb.stationquiz.screen.DisplaySelectGameScreen
import com.prgckwb.stationquiz.string.ScreenManager


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
            style = MaterialTheme.typography.h5
        )
        Text(
            text = "Score : $score",
            Modifier.fillMaxWidth(),
            color = color,
            style = MaterialTheme.typography.h5
        )
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
fun BackButton(navController: NavController) {
    Button(
        onClick = { navController.navigate(ScreenManager.TITLE_SCREEN) },
        modifier = Modifier
            .padding(8.dp)
            .clip(CircleShape)
    ) {
        Text(text = "もどる")
    }
}

@Composable
fun DebugText(gameModel: GameModel, text: String, step: Int) {
    Column {
//        Text(text = "入力中: $text")
        Text(text = "正解:  ${gameModel.line.stations[(gameModel.stationIndex + step) % gameModel.totalStationsNum].name}")
    }
}


@Preview(showBackground = true)
@Composable
fun ComposablePreview() {
    val navController = rememberNavController()
    Column {
        DisplaySelectGameScreen(navController = navController)
    }
}