package com.fabianospdev.volunteer_comp.presenter.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun Home(navController: NavHostController, name: String, modifier: Modifier = Modifier) {
    Column {
        Text(text = "This is $name")
        Button(onClick = { navController.navigate("Login") }) {
            Text(text = "Go to Login")
        }
    }
}