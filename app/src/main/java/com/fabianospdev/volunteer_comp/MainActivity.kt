package com.fabianospdev.volunteer_comp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fabianospdev.volunteer_comp.presenter.ui.home.Home
import com.fabianospdev.volunteer_comp.presenter.ui.login.Login
import com.fabianospdev.volunteer_comp.presenter.ui.theme.VolunteercompTheme
import dagger.hilt.android.AndroidEntryPoint

val montserratFamily = FontFamily(
    Font(R.font.montserrat_light, FontWeight.Light),
    Font(R.font.montserrat_regular, FontWeight.Normal),
    Font(R.font.montserrat_medium, FontWeight.Medium),
    Font(R.font.montserrat_semibold, FontWeight.Bold)
)

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    //  private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        loginViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
//            .get(LoginViewModel::class.java)

        setContent {
            VolunteercompTheme {
                val context = applicationContext
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "login") {
                        composable("login") {
                            Login(navController = navController, name = "Login", context = context)
                        }
                        composable("home") {
                            Home(navController = navController, name = "Home", context = context)
                        }
                        composable("settings") {
                            Home(navController = navController, name = "Settings", context = context)
                        }
                    }
                }
            }
        }
    }


}
