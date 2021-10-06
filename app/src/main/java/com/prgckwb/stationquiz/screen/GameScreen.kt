package com.prgckwb.stationquiz.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.prgckwb.stationquiz.game.GameModel
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
fun PrintScore(score: Int, questionNum: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = "${questionNum}問目", Modifier.fillMaxWidth(0.5f))
        Text(text = "Score : ${score}", Modifier.fillMaxWidth(0.5f))
    }
}

@Composable
fun ShowDirection(gameModel: GameModel){
    Text(
        text = gameModel.line.getLineDirectText(1),
        modifier = Modifier.padding(8.dp),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.subtitle1
    )
}


//　駅をランダムで表示して、ボタンを押すとその処理を繰り返す
@Composable
fun PlayGame(gameModel: GameModel) {
    var station by remember { mutableStateOf(gameModel.stationNow)}
    var questionNum by remember { mutableStateOf(gameModel.questionNum)}
    var score by remember { mutableStateOf(gameModel.score)}
    var text by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
//       問題Noとスコアの表示
        PrintScore(score, questionNum)

        Spacer(modifier = Modifier.padding(16.dp))

//        上り OR 下り表示
        ShowDirection(gameModel = gameModel)
        Spacer(modifier = Modifier.padding(16.dp))

//        駅名表示
        Text(
            text = gameModel.stationNow.name,
            style = MaterialTheme.typography.h2,
        )

        Spacer(Modifier.padding(16.dp))

//        スキップボタンと回答ボタン
        Row(){
            Button(onClick = {
                station = gameModel.getNextStation()
                questionNum = gameModel.getNextQuestionNum()
            },
                modifier = Modifier.fillMaxWidth(0.3f)
            ) {
                Text(text = "Change")
            }

            Spacer(modifier = Modifier.padding(8.dp))

            Button(onClick = {
                station = gameModel.stationNow
                gameModel.checkAnswer(text)
                score = gameModel.score
                questionNum = gameModel.questionNum
                text = ""
            },
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Text(text = "Answer")
            }
        }

        Spacer(modifier = Modifier.padding(8.dp))

        Text(
            text = "What is the next station?",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body2
        )

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text(text = "回答欄") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            maxLines = 1
        )
        Column{
            Text(text = "入力中: ${text}")
            Text(text = "正解:  ${gameModel.stationNow.name}")
        }
    }
}


// もどるボタン
@Composable
fun BackButton(navController: NavController) {
    Button(
        onClick = { navController.navigate("titleScreen") },
        modifier = Modifier.padding(8.dp)
    ) {
        Text(text = "もどる")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}