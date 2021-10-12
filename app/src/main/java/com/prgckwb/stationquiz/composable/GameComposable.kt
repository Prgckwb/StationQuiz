package com.prgckwb.stationquiz.composable

import android.util.Log
import androidx.compose.animation.*
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
                .padding(16.dp),
            textAlign = TextAlign.Center
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
    AnimatedContent(targetState = gameModel.currentStation.name) {
        Text(
            text = gameModel.currentStation.name,
            style = MaterialTheme.typography.h2,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
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
fun BottomButtons(navController: NavController, gameModel: GameModel) {
    Log.d("DEBUG", "BottomButtons 呼び出し")
    Row(
        modifier = Modifier.fillMaxWidth()
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
        Text(
            text = "もどる",
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun MyButton(modifier: Modifier = Modifier, onClick: () -> Unit, content: @Composable () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(8.dp)
            .clip(CircleShape),
    ) {
        content()
    }
}


@Composable
fun DebugText(gameModel: GameModel, step: Int) {
    Text(text = "正解:  ${gameModel.currentLine.stations[(gameModel.stationIndex + step) % gameModel.totalStationsNum].name}")
}


@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
fun ComposablePreview() {
    val navController = rememberNavController()
    Column {
        DisplaySelectGameScreen(navController = navController)
    }
}