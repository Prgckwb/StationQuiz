package com.prgckwb.stationquiz.screen

import android.util.Log
import android.view.Display
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.widget.ConstraintSet
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.prgckwb.stationquiz.R
import com.prgckwb.stationquiz.string.ScreenManager

// タイトル画面の組み立てコンポーザブル
@Composable
fun DisplayTitleScreen(navController: NavController) {
    var dx by remember { mutableStateOf(0.1f) }
    var isforwarding by remember { mutableStateOf(false)}

    Column(modifier = Modifier.padding(16.dp)) {
        Spacer(modifier = Modifier.padding(16.dp))
        TitleText()
        Row(Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.padding(dx.dp))
            Image(
                painter = painterResource(id = R.drawable.wabu_star),
                contentDescription = "わぶすたー",
                alignment = Alignment.Center,
            )

//            タイトル画面の画像をアニメーションさせる
            if(isforwarding){
                if(dx < 70.0f) dx += 0.5f
                else isforwarding = false
            }else{
                if(dx > 0.1f) dx -= 0.5f
                else isforwarding = true
            }
        }

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
    Button(
        onClick = { navController.navigate(ScreenManager.SELECT_GAME_SCREEN) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(CircleShape),
    ) {
        Icon(
            Icons.Filled.Person,
            contentDescription = null,
        )
        Text(
            text = "ランダムな路線で遊ぶ",
            style = MaterialTheme.typography.h5
        )
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
        Icon(imageVector = Icons.Default.Search, contentDescription = null)
        Text(
            text = "路線・駅を調べる",
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
