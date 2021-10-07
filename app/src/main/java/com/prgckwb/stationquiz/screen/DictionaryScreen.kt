package com.prgckwb.stationquiz.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.prgckwb.stationquiz.game.Line
import com.prgckwb.stationquiz.game.allLinesList
import com.prgckwb.stationquiz.string.ScreenManager

@Composable
fun DisplayDictionaryScreen(navController: NavController) {
    LinesList(navController)
}

@Composable
fun DisplayStationsScreen(navController: NavController, lineName: String?) {
    val line = findLine(allLinesList, lineName)
    StationsList(line = line)
}

fun findLine(linesList: List<Line>, lineName: String?): Line {
    for (line in linesList) {
        if (line.lineName == lineName) return line
    }
    return allLinesList[0]
}

@Composable
fun LinesList(navController: NavController) {
    LazyColumn {
        items(allLinesList) { line ->
            Button(
                onClick = { navController.navigate("${ScreenManager.DICTIONARY_STATIONS_SCREEN}/" + line.lineName) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = line.lineColor)
            ) {
                Text(text = line.lineName, style = MaterialTheme.typography.h5)
            }
        }
    }
}

@Composable
fun StationsList(line: Line) {
    LazyColumn {
        items(line.stations) { station ->
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = line.lineColor)
            ) {
                Text(text = station.name, style = MaterialTheme.typography.h6)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDictionary() {

}