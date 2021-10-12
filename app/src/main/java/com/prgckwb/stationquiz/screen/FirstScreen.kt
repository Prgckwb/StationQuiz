package com.prgckwb.stationquiz.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.prgckwb.stationquiz.R
import com.prgckwb.stationquiz.string.ScreenManager

// タイトル画面の組み立てコンポーザブル
@Composable
fun DisplayTitleScreen(navController: NavController) {
    var dx by remember { mutableStateOf(0.1f) }

    Column {
        Spacer(modifier = Modifier.padding(32.dp))
        TitleText()
        Image(
            painter = painterResource(id = R.drawable.wabu_star),
            contentDescription = "わぶすたー",
            alignment = Alignment.Center,
            modifier = Modifier.padding(horizontal = dx.dp)
        )
        dx += 0.1f
        StartButton(navController = navController)
        DictionaryButton(navController = navController)
    }
}

@Composable
fun TitleText() {
    Text(
        text = "Station Quiz!!",
        style = MaterialTheme.typography.h1,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.4f),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colors.onSurface
    )
}

@Composable
fun StartButton(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            onClick = { navController.navigate(ScreenManager.SELECT_GAME_SCREEN) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(CircleShape),
        ) {
            Text(
                text = "ゲームスタート！",
                style = MaterialTheme.typography.h5
            )
        }
    }
}

@Composable
fun DictionaryButton(navController: NavController) {
    Button(
        onClick = { navController.navigate(ScreenManager.DICTIONARY_SCREEN) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(CircleShape),
    ) {
        Text(
            text = "駅リスト",
            style = MaterialTheme.typography.h5
        )
    }
}


@Preview(showBackground = true)
@Composable
fun TitlePreview() {
    val navController = rememberNavController()
    DisplayTitleScreen(navController = navController)
}