package com.prgckwb.stationquiz.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.prgckwb.stationquiz.composable.*
import com.prgckwb.stationquiz.game.GameModel
import com.prgckwb.stationquiz.string.ScreenManager
import com.prgckwb.stationquiz.ui.theme.StationQuizTheme

// ゲーム画面の組み立てコンポーザブル
@Composable
fun DisplayWriteGameScreen(navController: NavController) {
    val gameModel = GameModel()

    StationQuizTheme {
        Surface(color = MaterialTheme.colors.background) {
            val stationStep = 1

            Column {
                PlayWriteGame(gameModel, stationStep)
                BackButton(navController)
            }
        }
    }
}

//　ChangeボタンとAnswerボタン
@Composable
fun OperationButtons(
    clickEvent1: () -> Unit,
    clickEvent2: () -> Unit
) {
    Row {
        Button(onClick = clickEvent1, modifier = Modifier.fillMaxWidth(0.3f)) {
            Text(text = "Change")
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Button(onClick = clickEvent2, modifier = Modifier.fillMaxWidth(0.5f)) {
            Text(text = "Answer")
        }
    }
}

// 答えの入力欄
@Composable
fun WriteAnswerField(text: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = text,
        onValueChange = onValueChange,
        label = { Text(text = "回答欄") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        maxLines = 1
    )
}

//　ゲームの流れを作る
//  Stateを管理して、それらを使うコンポーザブルを配置する
@Composable
fun PlayWriteGame(gameModel: GameModel, step: Int) {
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
        ShowLineAndDirection(gameModel = gameModel)
        Spacer(modifier = Modifier.padding(16.dp))
//        駅名表示
        StationName(gameModel)
        Spacer(Modifier.padding(16.dp))

//        スキップボタンと回答ボタン
        OperationButtons(
            clickEvent1 = {
                station = gameModel.getNextStation()
                questionNum = gameModel.getNextIncrementQuestionNum()

            },
            clickEvent2 = {
                wasCorrect = gameModel.checkAnswer(text, step)
                score = gameModel.score
                questionNum = gameModel.questionNum
                text = ""
            }
        )
        Spacer(modifier = Modifier.padding(8.dp))
//        問題文表示
        QuestionText(step = step)
        WriteAnswerField(text = text) { answer -> text = answer }
        DebugText(gameModel = gameModel, text = text, step)
    }
}


// もどるボタン
@Composable
fun BackButton(navController: NavController) {
    Button(
        onClick = { navController.navigate(ScreenManager.TITLE_SCREEN) },
        modifier = Modifier.padding(8.dp)
    ) {
        Text(text = "もどる")
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}