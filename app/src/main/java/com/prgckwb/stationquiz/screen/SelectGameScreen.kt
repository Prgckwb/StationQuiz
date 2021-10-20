package com.prgckwb.stationquiz.screen

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.prgckwb.stationquiz.composable.*
import com.prgckwb.stationquiz.game.GameModel
import com.prgckwb.stationquiz.ui.theme.StationQuizTheme
import java.util.*

// 画面にSelectGameScreenを表示するコンポーザブル
@ExperimentalAnimationApi
@Composable
fun DisplaySelectGameScreen(
    navController: NavController,
    gameModel: GameModel,
) {
    Log.d("DEBUG", "DisplaySelectGameScreen 呼び出し")

    StationQuizTheme {
        Surface(color = MaterialTheme.colors.background) {
            val stationStep = 1

            LazyColumn {
                item {
                    PlaySelectGame(gameModel = gameModel, step = stationStep)
                    BottomButtons(navController = navController, gameModel)
                }
            }
        }
    }
}

// 状態を管理する、SelectGameのコンポーザブル組み立て用の関数
@ExperimentalAnimationApi
@Composable
fun PlaySelectGame(gameModel: GameModel, step: Int) {
    var questionNum by remember { mutableStateOf(gameModel.questionNum) }
    var score by remember { mutableStateOf(gameModel.score) }
    var wasCorrect by remember { mutableStateOf(false) }
    val timer = Timer()


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
    ) {
//       問題Noとスコアの表示
        PrintScore(score, questionNum, wasCorrect)
        Spacer(modifier = Modifier.padding(8.dp))
        ShowLineAndDirection(line = gameModel.currentLine)
        Spacer(modifier = Modifier.padding(8.dp))
//        駅名表示
        StationName(gameModel)
        Spacer(modifier = Modifier.padding(4.dp))
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
    DisplaySelectGameScreen(navController = navController, GameModel())
}