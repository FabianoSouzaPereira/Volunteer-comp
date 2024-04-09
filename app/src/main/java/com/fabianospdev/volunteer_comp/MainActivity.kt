package com.fabianospdev.volunteer_comp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fabianospdev.volunteer_comp.presenter.ui.home.Home
import com.fabianospdev.volunteer_comp.presenter.ui.login.Login
import com.fabianospdev.volunteer_comp.presenter.ui.theme.VolunteercompTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VolunteercompTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "login") {
                        composable("login") {
                            Login(navController, "Login")
                        }
                        composable("home") {
                            Home(navController, "Home")
                        }
                        composable("settings") {
                            Home(navController, "Settings")
                        }
                    }
                }
            }
        }
    }
}
