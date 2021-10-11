package com.prgckwb.stationquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.prgckwb.stationquiz.screen.DisplayDictionaryScreen
import com.prgckwb.stationquiz.screen.DisplaySelectGameScreen
import com.prgckwb.stationquiz.screen.DisplayStationsScreen
import com.prgckwb.stationquiz.screen.DisplayTitleScreen
import com.prgckwb.stationquiz.string.ScreenManager

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigateManager()
        }
    }
}

// Navigationの情報を書いていく
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
    }
}