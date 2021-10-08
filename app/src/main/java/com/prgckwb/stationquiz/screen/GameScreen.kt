package com.prgckwb.stationquiz.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.prgckwb.stationquiz.game.GameModel
import com.prgckwb.stationquiz.string.ScreenManager
import com.prgckwb.stationquiz.ui.theme.StationQuizTheme

// ゲーム画面の組み立てコンポーザブル
@Composable
fun DisplayGameScreen(navController: NavController) {
    val gameModel = GameModel()

    StationQuizTheme {
        Surface(color = MaterialTheme.colors.background) {
            Column {
                PlayGame(gameModel)
                BackButton(navController)
            }
        }
    }
}

//　何問目かとスコアを表示する
@Composable
fun PrintScore(score: Int, questionNum: Int, wasCorrect: Boolean) {
    val color = if(wasCorrect) Color.Red else Color.Blue
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = "${questionNum}問目", Modifier.fillMaxWidth(0.5f))
        Text(text = "Score : $score", Modifier.fillMaxWidth(0.5f), color = color)
    }
}

//　路線名と方向（上り方面か下り方面か）を表示
@Composable
fun ShowLineAndDirection(gameModel: GameModel) {
    Column {
        Text(
            text = gameModel.line.lineName,
            style = MaterialTheme.typography.h5,
            color = gameModel.line.lineColor,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Text(
            text = gameModel.line.getLineDirectText(1),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            style = MaterialTheme.typography.subtitle1,
            textAlign = TextAlign.Center,

            )
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
fun PlayGame(gameModel: GameModel) {
    var station by remember { mutableStateOf(gameModel.currentStation) }
    var questionNum by remember { mutableStateOf(gameModel.questionNum) }
    var score by remember { mutableStateOf(gameModel.score) }
    var text by remember { mutableStateOf("") }
    var wasCorrect by remember { mutableStateOf(false)}


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
        Text(
            text = gameModel.currentStation.name,
            style = MaterialTheme.typography.h2,
        )

        Spacer(Modifier.padding(16.dp))

//        スキップボタンと回答ボタン
        OperationButtons(
            clickEvent1 = {
                station = gameModel.getNextStation()
                questionNum = gameModel.getNextIncrementQuestionNum()

            },
            clickEvent2 = {
                wasCorrect = gameModel.checkAnswer(text, 1)
                score = gameModel.score
                questionNum = gameModel.questionNum
                text = ""
            }
        )

        Spacer(modifier = Modifier.padding(8.dp))

//        問題文表示
        Text(
            text = "What is the next station?",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h6
        )

        WriteAnswerField(text = text) { answer -> text = answer }
        DebugText(gameModel = gameModel, text = text, 1)
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

@Composable
fun DebugText(gameModel: GameModel, text: String, step: Int) {
    Column {
        Text(text = "入力中: $text")
        Text(text = "正解:  ${gameModel.line.stations[(gameModel.stationIndex + step) % gameModel.totalStationsNum].name}")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}