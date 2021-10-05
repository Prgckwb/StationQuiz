package com.prgckwb.stationquiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.prgckwb.stationquiz.game.keioLine
import com.prgckwb.stationquiz.ui.theme.StationQuizTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            MyApp()
            Hoge()
        }
    }
}

@Composable
fun MyApp(){
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

@Composable
fun Hoge(){
    var station by remember {
        mutableStateOf(keioLine.random())
    }

    Column() {
        Text(text = station.name)
        Button(onClick = { station = keioLine.random() }) {
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}