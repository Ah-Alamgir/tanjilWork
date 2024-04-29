package com.tanjil.mywork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tanjil.mywork.Utils.Screen
import com.tanjil.mywork.ui.Scenes.HomeScene
import com.tanjil.mywork.ui.Scenes.OTPScreen
import com.tanjil.mywork.ui.Scenes.SelectAddress
import com.tanjil.mywork.ui.Scenes.SelectService
import com.tanjil.mywork.ui.Scenes.ShowProfile
import com.tanjil.mywork.ui.Scenes.sceneSignup
import com.tanjil.mywork.ui.Scenes.searchResult

import com.tanjil.mywork.ui.theme.MyWorkTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyWorkTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    setContent {
                        myApp()
                    }

                }
            }
        }
    }
}



@Composable
fun myApp(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.otpScene.rout) {
        composable(route = Screen.HomeScene.rout){
            HomeScene(navController)
        }
        composable(route = Screen.SelectService.rout){
            SelectService(navController)
        }
        composable(route = Screen.SelecAddress.rout){
            SelectAddress()
        }
        composable(route = Screen.SIgnUp.rout){
            sceneSignup(navController)
        }
        composable(route = Screen.otpScene.rout){
            OTPScreen(navController)
        }
        composable(route = Screen.SearchResult.rout){
            searchResult()
        }
        composable(route = Screen.ProfileScene.rout){
            ShowProfile()
        }
    }
}