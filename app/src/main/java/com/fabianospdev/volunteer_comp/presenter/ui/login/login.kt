package com.fabianospdev.volunteer_comp.presenter.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun Login(navController: NavHostController, name: String, modifier: Modifier = Modifier) {
    Column {
        Text(text = "This is $name")
        Button(onClick = { navController.navigate("Home") }) {
            Text(text = "Go to Home")
        }
        Button(onClick = { navController.navigate("Settings") }) {
            Text(text = "Go to Settings")
        }
    }
}