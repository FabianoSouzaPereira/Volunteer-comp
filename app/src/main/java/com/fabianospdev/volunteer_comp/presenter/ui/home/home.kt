package com.fabianospdev.volunteer_comp.presenter.ui.home

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.fabianospdev.volunteer_comp.R

@Composable
fun Home(navController: NavHostController, name: String, context: Context?) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(modifier = Modifier, verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "This is $name")
            Button(onClick = { navController.navigate(context!!.getString(R.string.login)) }) {
                Text(text = "Go to Login")
            }
        }
    }
}

@Preview
@Composable
fun DefaultHome(){
    Home(navController = rememberNavController(), name = "Home", context = null)
}