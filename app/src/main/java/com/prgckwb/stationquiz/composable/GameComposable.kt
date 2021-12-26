package com.prgckwb.stationquiz.composable

import androidx.compose.animation.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.prgckwb.stationquiz.game.GameModel
import com.prgckwb.stationquiz.game.Line
import com.prgckwb.stationquiz.screen.DisplaySelectGameScreen
import com.prgckwb.stationquiz.string.ScreenManager


//　何問目かとスコアを表示する
@ExperimentalAnimationApi
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

//        TimeText(time = 1L)

//        experiment
        AnimatedContent(
            targetState = score,
            transitionSpec = {
                if (targetState > initialState) {
                    slideInVertically({ height -> height }) + fadeIn() with
                            slideOutVertically({ height -> height }) + fadeOut()
                } else {
                    slideInVertically({ height -> -height }) + fadeIn() with
                            slideOutVertically({ height -> height }) + fadeOut()
                }.using(SizeTransform(clip = false))
            }
        ) { targetScore ->
            // Make sure to use `targetCount`, not `count`.
            Text(
                text = "Score : $targetScore",
                Modifier.fillMaxWidth(),
                color = color,
                style = MaterialTheme.typography.h5
            )
        }
    }
}

//　路線名と方向（上り方面か下り方面か）を表示
@Composable
fun ShowLineAndDirection(line: Line) {
    Column {
        Text(
            text = line.lineName,
            style = MaterialTheme.typography.h4,
            color = line.lineColor,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            textAlign = TextAlign.Center,
        )
        Text(
            text = line.getLineDirectText(1),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
    }
}


// 駅名表示
@ExperimentalAnimationApi
@Composable
fun StationName(gameModel: GameModel) {
    AnimatedContent(
        targetState = gameModel.currentStation.name
    ) {
        Text(
            text = gameModel.currentStation.name,
            style = MaterialTheme.typography.h2,
            modifier = Modifier
                .fillMaxWidth()
//                .height(100.dp)
                .padding(20.dp),
            textAlign = TextAlign.Center,
            maxLines = 2
        )
    }
}

// 問題文表示
@Composable
fun QuestionText(step: Int) {
    Text(
        text = "${step}つ次の駅は?",
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.h6,
    )
}

@Composable
fun NavigationButton(
    navController: NavController,
    destination: String = ScreenManager.TITLE_SCREEN,
    text: String = "タイトルへ",
) {
    MyButton(onClick = { navController.navigate(destination) }) {
        Text(
            text = text,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun BottomButtons(
    navController: NavController,
    gameModel: GameModel,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        NavigationButton(navController, ScreenManager.TITLE_SCREEN, "タイトルへ")
        NavigationButton(navController, ScreenManager.SELECT_GAME_SCREEN, text = "路線を変える")
        NavigationButton(
            navController,
            ScreenManager.DICTIONARY_STATIONS_SCREEN + "/${gameModel.currentLine.lineName}",
            text = "学習する"
        )
    }
}

@Composable
fun BackButton(navController: NavController) {
    MyButton(onClick = { navController.popBackStack() }) {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
        Text(
            text = "もどる",
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun MyButton(onClick: () -> Unit, content: @Composable () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(8.dp)
            .clip(CircleShape)
    ) {
        content()
    }
}


// 選択肢ボタン
@Composable
fun SelectAnswerButtons(
    gameModel: GameModel,
    optionsNum: Int,
    step: Int,
    modifier: Modifier = Modifier,
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
                    .height(70.dp)
                    .padding(8.dp)
                    .clip(CircleShape),
                colors = ButtonDefaults.buttonColors(backgroundColor = gameModel.currentLine.lineColor)
            ) {
                Text(
                    text = optionsList[it].name,
                    color = Color.White,
                    style = MaterialTheme.typography.h5,
                    maxLines = 1
                )
            }
        }
    }
}

@Composable
fun TimeText(time: Long) {
    val openDialog = remember { mutableStateOf(false) }

    Text(text = "押して", modifier = Modifier.clickable { openDialog.value = true })

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            title = { Text(text = "title属性だよ") },
            text = { Text(text = "text属性だよ") },
            confirmButton = {
                Button(onClick = { openDialog.value = false }) {
                    Text(text = "Confirmボタン")
                }
            },
        )
    }
}


@Composable
fun DebugText(gameModel: GameModel, step: Int) {
    val newIndex = (gameModel.stationIndex + step) % gameModel.totalStationsNum
    Text(
        text = "正解:  ${gameModel.currentLine.stations[newIndex].name}",
    )
}


@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
fun ComposablePreview() {
    val navController = rememberNavController()
    Column {
        DisplaySelectGameScreen(navController = navController, GameModel())
    }
}