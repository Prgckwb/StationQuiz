package com.prgckwb.stationquiz.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.prgckwb.stationquiz.composable.BackButton
import com.prgckwb.stationquiz.composable.MyButton
import com.prgckwb.stationquiz.composable.ShowLineAndDirection
import com.prgckwb.stationquiz.game.GameModel.Companion.findLine
import com.prgckwb.stationquiz.game.GameModel.Companion.findLines
import com.prgckwb.stationquiz.game.Line
import com.prgckwb.stationquiz.string.ScreenManager

@ExperimentalComposeUiApi
@Composable
fun DisplayDictionaryScreen(navController: NavController) {
    Log.d("DEBUG", "DisplayDictionaryScreen 呼び出し")

    var text by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    Column {
        OutlinedTextField(
            value = text,
            onValueChange = {
                text = it
            },
            label = { Text(text = "路線検索") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            maxLines = 1,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() })
        )
        LinesList(navController, text)
    }

}

@Composable
fun DisplayStationsScreen(navController: NavController, lineName: String?) {
    Log.d("DEBUG", "DisplayStationsScreen 呼び出し")

    val line = findLine(lineName)
    StationsList(line = line, navController)
}

@Composable
fun DictionaryTitle() {
    Text(
        text = "路線リスト",
        style = MaterialTheme.typography.h2,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}


@Composable
fun LinesList(navController: NavController, text: String?) {
    val lineList = findLines(text)

    LazyColumn {
        item { DictionaryTitle() }
        items(lineList) { line ->
            Button(
                onClick = { navController.navigate("${ScreenManager.DICTIONARY_STATIONS_SCREEN}/" + line.lineName) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clip(CircleShape),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = line.lineColor,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = line.lineName,
                    style = MaterialTheme.typography.h5,
                    textAlign = TextAlign.Center
                )
            }
        }

        item { BackButton(navController = navController) }
    }
}

@Composable
fun StationsList(line: Line, navController: NavController) {
    LazyColumn {
        item {
            Spacer(modifier = Modifier.padding(16.dp))
            ShowLineAndDirection(line = line)
        }

        item {
            MyButton(
                onClick = {
                    val destination = "${ScreenManager.SELECT_GAME_SCREEN}/${line.lineName}"
                    navController.navigate(destination)
                }
            ) {
                Text(text = "この路線であそぶ")
            }
        }

        items(line.stations) { station ->
            Button(
                onClick = {
                    navController.navigate("${ScreenManager.WEB_VIEW_SCREEN}/"+ station.name)
                          },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .padding(horizontal = 8.dp)
                    .clip(CircleShape),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = line.lineColor,
                    contentColor = Color.White
                ),
            ) {
                Text(text = station.name, style = MaterialTheme.typography.h6)
            }
        }

        item { BackButton(navController = navController) }
    }
}

@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun PreviewDictionary() {
    val navController = rememberNavController()
    DisplayDictionaryScreen(navController = navController)
}

@Preview(showBackground = true)
@Composable
fun PreviewStations() {
    val navController = rememberNavController()
    DisplayStationsScreen(navController = navController, lineName = "京王線")
}