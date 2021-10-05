package com.prgckwb.stationquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.prgckwb.stationquiz.ui.theme.StationQuizTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StationQuizTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "welcome"){
                        composable("welcome"){ WelcomeScreen(navController = navController)}
                        composable("secondScreen"){ SecondScreen()}
                    }
                }
            }
        }
    }
}

@Composable
fun WelcomeScreen(navController: NavController){
    Column {
        Text(text = "Welcome!")
        Button(onClick = { navController.navigate("secondScreen") }) {
            Text(text = "Continue")
        }
    }
}

@Composable
fun SecondScreen(){
    Text(text = "Second screen!")
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StationQuizTheme {
        Greeting("Android")
    }
}