package com.prgckwb.stationquiz

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.prgckwb.stationquiz.game.GameModel
import com.prgckwb.stationquiz.game.GameModel.Companion.findLine
import com.prgckwb.stationquiz.screen.*
import com.prgckwb.stationquiz.string.ScreenManager

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("DEBUG", "MainActivity onCreate")

        setContent {
            NavigateManager()
        }
    }
}

// Navigationの情報を書いていく
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun NavigateManager() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreenManager.TITLE_SCREEN) {
        composable(ScreenManager.TITLE_SCREEN) { DisplayTitleScreen(navController = navController) }
        composable(ScreenManager.SELECT_GAME_SCREEN) { DisplaySelectGameScreen(navController = navController) }
        composable(ScreenManager.DICTIONARY_SCREEN) { DisplayDictionaryScreen(navController = navController) }
        composable(
            "${ScreenManager.DICTIONARY_STATIONS_SCREEN}/{lineName}",
            arguments = listOf(navArgument("lineName") { type = NavType.StringType })
        ) {
            DisplayStationsScreen(
                navController = navController,
                it.arguments?.getString("lineName")
            )
        }
//        路線名を指定してゲームスタート
//        遷移の際に、{}を余分に渡すとエラーになる
        composable(
            "${ScreenManager.SELECT_GAME_SCREEN}/{lineName}",
            arguments = listOf(navArgument("lineName") { type = NavType.StringType })
        ) {
            DisplaySelectGameScreen(
                navController = navController,
                GameModel(findLine(it.arguments?.getString("lineName")))
            )
        }

        composable(
            "${ScreenManager.WEB_VIEW_SCREEN}/{stationName}",
            arguments = listOf(navArgument("stationName"){ type = NavType.StringType}),
        ){
            WebViewScreen(url = it.arguments?.getString("stationName"))
        }
    }
}