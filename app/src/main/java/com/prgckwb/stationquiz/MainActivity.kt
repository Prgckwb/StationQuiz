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
import com.prgckwb.stationquiz.screen.DisplayGameScreen
import com.prgckwb.stationquiz.screen.DisplayStationsScreen
import com.prgckwb.stationquiz.screen.DisplayTitleScreen

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
    NavHost(navController = navController, startDestination = "titleScreen") {
        composable("titleScreen") { DisplayTitleScreen(navController = navController) }
        composable("gameScreen") { DisplayGameScreen(navController = navController) }
        composable("dictionaryScreen") { DisplayDictionaryScreen(navController = navController)}
        composable(
            "dictionaryStationsScreen/{lineName}",
            arguments = listOf(navArgument("lineName"){type = NavType.StringType})
        ){
            DisplayStationsScreen(navController = navController, it.arguments?.getString("lineName"))
        }
    }
}