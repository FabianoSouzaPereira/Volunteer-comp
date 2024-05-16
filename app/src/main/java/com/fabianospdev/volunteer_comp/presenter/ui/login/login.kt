package com.fabianospdev.volunteer_comp.presenter.ui.login

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.fabianospdev.volunteer_comp.R
import com.fabianospdev.volunteer_comp.montserratFamily


@Composable
fun Login(navController: NavHostController, name: String, context: Context?) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    var isUsernameEmpty by remember { mutableStateOf(username.isEmpty()) }



    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = stringResource(R.string.logo),
                modifier = Modifier.size(120.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(R.string.log_in),
                fontSize = 16.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Normal
            )
            TextField(
                value = username,
                modifier = Modifier.padding(20.dp, 20.dp, 20.dp, 1.dp),
                onValueChange = {
                    username = it
                    isUsernameEmpty = it.isEmpty()
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                textStyle = TextStyle(color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold),
                shape = RoundedCornerShape(25),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent,
                ),
                placeholder = {
                    Text(
                        text = "email@email.com",
                        modifier = Modifier.basicMarquee(),
                        style = LocalTextStyle.current.copy(color = Color.Gray),
                        fontSize = 16.sp,
                        fontFamily = montserratFamily,
                        fontWeight = FontWeight.Normal
                    )
                },
                leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon") },
            )
            PasswordTextField(
                text = password,
                onTextChanged = { password = it },
                showPassword = showPassword,
                onToggleShowPassword = { showPassword = !showPassword }
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { navController.navigate(route = context!!.getString(R.string.home)) },
                enabled = true,
                interactionSource = remember { MutableInteractionSource() },
                border = BorderStroke(1.dp, color = Color.Black),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 10.dp),
                shape = MaterialTheme.shapes.large,
                colors = ButtonDefaults.buttonColors(),
                contentPadding = ButtonDefaults.ContentPadding,
            ) {
                Text(text = "Login")
            }
//            Button(
//                onClick = { navController.navigate(route = "Settings") },
//                border = BorderStroke(1.dp, color = Color.Black),
//                elevation = ButtonDefaults.buttonElevation(defaultElevation = 10.dp),
//                shape = MaterialTheme.shapes.large,
//                colors = ButtonDefaults.buttonColors(),
//                contentPadding = ButtonDefaults.ContentPadding,
//            ) {
//                Text(text = "Go to Settings")
//            }


        }
    }
}

@Composable
fun PasswordTextField(
    text: String,
    onTextChanged: (String) -> Unit,
    showPassword: Boolean,
    onToggleShowPassword: () -> Unit
) {
    TextField(
        value = text,
        onValueChange = { onTextChanged(it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        textStyle = TextStyle(
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.None
        ),
        shape = RoundedCornerShape(25),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
        ),
        placeholder = {
            Text(
                text = "Q@nm#44u",
                fontSize = 16.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight.Normal,
                color = Color.Gray
            )
        },
        leadingIcon = { Icon(imageVector = Icons.Default.CheckCircle, contentDescription = "emailIcon") },
        trailingIcon = {
            IconButton(onClick = { onToggleShowPassword() }) {
                val icon: ImageVector = if (showPassword) {
                    ImageVector.vectorResource(R.drawable.baseline_visibility_off_24)
                } else {
                    ImageVector.vectorResource(id = R.drawable.baseline_remove_red_eye_24)
                }
                Icon(
                    imageVector = icon,
                    contentDescription = if (showPassword) {
                        "Hide Password"
                    } else {
                        "Show Password"
                    },
                    tint = Color.Gray
                )
            }
        },
        modifier = Modifier.padding(end = 8.dp)
    )
}

@Preview(showSystemUi = true, showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun DefaultLogin() {
    Login(navController = rememberNavController(), name = "Login", null)
}