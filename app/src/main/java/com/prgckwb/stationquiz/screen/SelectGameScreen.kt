package com.prgckwb.stationquiz.screen

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.prgckwb.stationquiz.composable.*
import com.prgckwb.stationquiz.game.GameModel
import com.prgckwb.stationquiz.ui.theme.StationQuizTheme

// 画面にSelectGameScreenを表示するコンポーザブル
@ExperimentalAnimationApi
@Composable
fun DisplaySelectGameScreen(
    navController: NavController,
    gameModel: GameModel = GameModel()
) {
    Log.d("DEBUG", "DisplaySelectGameScreen 呼び出し")

    StationQuizTheme {
        Surface(color = MaterialTheme.colors.background) {
            val stationStep = 1

            Column {
                PlaySelectGame(gameModel = gameModel, step = stationStep)
                BottomButtons(navController = navController, gameModel)
            }
        }
    }
}


// 選択肢ボタン
@Composable
fun SelectAnswerButtons(
    gameModel: GameModel,
    optionsNum: Int,
    step: Int,
    onClick: (String) -> Unit
) {
    val optionsList = gameModel.getStationOptions(optionsNum, step)

    Column(
        Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        repeat(optionsList.size) {
            val optionStationName = optionsList[it].name
            Button(
                onClick = {
                    onClick(optionStationName)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clip(CircleShape),
                colors = ButtonDefaults.buttonColors(backgroundColor = gameModel.currentLine.lineColor)
            ) {
                Text(
                    text = optionsList[it].name,
                    color = Color.White,
                    style = MaterialTheme.typography.h5
                )
            }
        }
    }
}

// 状態を管理する、SelectGameのコンポーザブル組み立てよう関数
@ExperimentalAnimationApi
@Composable
fun PlaySelectGame(gameModel: GameModel, step: Int) {
    var station by remember { mutableStateOf(gameModel.currentStation) }
    var questionNum by remember { mutableStateOf(gameModel.questionNum) }
    var score by remember { mutableStateOf(gameModel.score) }
    var text by remember { mutableStateOf("") }
    var wasCorrect by remember { mutableStateOf(false) }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
    ) {
//       問題Noとスコアの表示
        PrintScore(score, questionNum, wasCorrect)
        Spacer(modifier = Modifier.padding(16.dp))
        ShowLineAndDirection(line = gameModel.currentLine)
        Spacer(modifier = Modifier.padding(16.dp))
//        駅名表示
        StationName(gameModel)
        Spacer(modifier = Modifier.padding(8.dp))
//        問題文表示
        QuestionText(step = step)
        SelectAnswerButtons(gameModel = gameModel, optionsNum = 4, step = step) {
            wasCorrect = gameModel.checkAnswer(it, step)
            score = gameModel.score
            questionNum = gameModel.questionNum
        }
        DebugText(gameModel = gameModel, step)
    }
}


@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
fun PreviewSelectGame() {
    val navController = rememberNavController()
    DisplaySelectGameScreen(navController = navController)
}