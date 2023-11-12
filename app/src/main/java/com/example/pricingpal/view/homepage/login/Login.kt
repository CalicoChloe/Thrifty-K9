package com.example.pricingpal.view.homepage.login

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pricingpal.R
import com.example.pricingpal.ui.theme.Anti_flash_white
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo

@Composable
fun login(){
    Card(
        modifier = Modifier
            .padding(start = 40.dp, top = 50.dp, end = 40.dp, bottom = 50.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .border(4.dp, color = Persian_indigo),
        shape = RectangleShape,
        elevation = CardDefaults.cardElevation(12.dp),
        colors = CardDefaults.cardColors(containerColor = Periwinkle)
    ) {

        Row(modifier = Modifier
            .border(4.dp, color = Persian_indigo)
            .fillMaxWidth()
            .background(color = Cornflower_blue, shape = RectangleShape),
            horizontalArrangement = Arrangement.Center,
        ) {
            Image(
                //Imports image from resource folder
                painter = painterResource(id = R.drawable.logo),
                //description of the image for accessibility
                contentDescription = "Pictures of paws",
                modifier = Modifier
                    .padding(15.dp)
            )
        }

        Column(
            modifier = Modifier
                .padding(top = 10.dp),
            // verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                textAlign = TextAlign.Center,
                text = "Login",
                fontSize = 60.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(25.dp))
            loginEmailInput()
            Spacer(modifier = Modifier.height(50.dp))
            loginPasswordInput()
            Spacer(modifier = Modifier.height(25.dp))

            ElevatedButton(
                onClick = { /*TODO*/ },
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(Cornflower_blue),
                elevation = ButtonDefaults.buttonElevation(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(start = 25.dp, top = 15.dp, end = 25.dp, bottom = 15.dp)
                    .border(4.dp, color = Persian_indigo),

                ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = "Login",
                    fontSize = 40.sp,
                    color = Color.Black,
                )
            }

            TextButton(onClick = { /*TODO*/ }) {
                Text(
                    textAlign = TextAlign.Center,
                    text = "Forgot Password?",
                    fontSize = 20.sp,
                    color = Color.Black,
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            lines()
            Spacer(modifier = Modifier.height(10.dp))

            TextButton(onClick = { /*TODO*/ }) {
                Text(
                    textAlign = TextAlign.Center,
                    text = "Register Here",
                    fontSize = 30.sp,
                    color = Color.Black,
                )
            }

            ElevatedButton(
                onClick = { /*TODO*/ },
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(Cornflower_blue),
                elevation = ButtonDefaults.buttonElevation(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(start = 70.dp, top = 15.dp, end = 70.dp, bottom = 15.dp)
                    .border(4.dp, color = Persian_indigo),

                ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = "Home",
                    fontSize = 30.sp,
                    color = Color.Black,
                )

            }
        }
    }
}

@Composable
fun lines(){
    Row(modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ){
        Box(
            modifier = Modifier
                .padding(top = 20.dp, end = 10.dp)
                .height(height = 3.dp)
                .width(260.dp)
                .background(color = Color.Black)
        )

        Text(
            textAlign = TextAlign.Center,
            text = "OR",
            fontSize = 30.sp,
            color = Color.Black,
        )

        Box(
            modifier = Modifier
                .padding(top = 20.dp, start = 10.dp)
                .width(260.dp)
                .height(height = 3.dp)
                .background(color = Color.Black)
        )
    }
}


@Composable
fun loginEmailInput(){
    var loginEmail by remember { mutableStateOf("") }
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 30.dp, end = 30.dp),
        value = loginEmail,
        onValueChange = {loginEmail = it},
        textStyle = TextStyle.Default.copy(fontSize = 20.sp) ,
        placeholder = { Text("Enter email", fontSize = 20.sp) },
        supportingText = { Text(text = "*required")},
        leadingIcon = { Icon(imageVector = Icons.Filled.Email, contentDescription = "Email Icon") },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Anti_flash_white,
            unfocusedContainerColor = Anti_flash_white,
            unfocusedIndicatorColor = Anti_flash_white,
            focusedIndicatorColor = Persian_indigo
        ),
        shape = RectangleShape,
    )


}

@Composable
fun loginPasswordInput(){
    var loginPassword by remember { mutableStateOf("") }
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 30.dp, end = 30.dp),
        value = loginPassword,
        onValueChange = { loginPassword = it },
        textStyle = TextStyle.Default.copy(fontSize = 20.sp),
        placeholder = { Text("Enter password", fontSize = 20.sp) },
        supportingText = { Text(text = "*required")},
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = "Lock Icon")},
        trailingIcon = { Icon(imageVector = ImageVector.vectorResource(id = R.drawable.eye), contentDescription = "Lock Icon") },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Anti_flash_white,
            unfocusedContainerColor = Anti_flash_white,
            unfocusedIndicatorColor = Anti_flash_white,
            focusedIndicatorColor = Persian_indigo
        ),
        shape = RectangleShape,

    )


}