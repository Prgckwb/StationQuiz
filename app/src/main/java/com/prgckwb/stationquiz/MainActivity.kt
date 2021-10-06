package com.prgckwb.stationquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.prgckwb.stationquiz.screen.DisplayFirstScreen
import com.prgckwb.stationquiz.screen.DisplayGameScreen

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
    NavHost(navController = navController, startDestination = "firstScreen") {
        composable("firstScreen") { DisplayFirstScreen(navController = navController) }
        composable("secondScreen") { DisplayGameScreen() }
    }
}