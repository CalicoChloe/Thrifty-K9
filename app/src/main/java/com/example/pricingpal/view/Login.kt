package com.example.pricingpal.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pricingpal.PricingPalAppBar
import com.example.pricingpal.R
import com.example.pricingpal.ui.theme.Anti_flash_white
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo

/**
 * This file will allow the user to login to make edits to their list.
 * They will login with their email and password.
 * If they don't have a login the can click on the register button or if they forgot a password, they
 * can lick on the forgot password.
 * On the back end, the database should take that login an put it within the client's table.
 * */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginHeader(){
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Anti_flash_white
    ) {
        Image(
            //Imports image from resource folder
            painter = painterResource(id = R.drawable.paw_background),
            //description of the image for accessibility
            contentDescription = "Pictures of paws",
            //crops the image
            contentScale = ContentScale.Crop,
            // changes the opacity of the image
            alpha = 0.1F
        )
        Card(
            modifier = Modifier
                .padding(start = 40.dp, end = 40.dp)
                .fillMaxSize()
                .border(4.dp, color = Persian_indigo),
            shape = RectangleShape,
            elevation = CardDefaults.cardElevation(12.dp),
           // colors = CardDefaults.cardColors(containerColor = Cornflower_blue)
        ) {

            Scaffold(
                //Create an app bar of medium size at the top of the scaffold
                topBar = {
                    TopAppBar(
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = Cornflower_blue,
                        ),
                        title = {
                            Text(text = "")
                        },
                        navigationIcon = {
                            IconButton(onClick = { /*TODO*/ },
                            ) {
                                Icon(imageVector = Icons.Filled.ArrowBack,
                                    contentDescription = "Back arrow Button",
                                    tint = Color.Black,
                                    modifier = Modifier
                                        .size(50.dp)
                                )

                            }
                        },
                    )
                },

                content = { padding ->
                    Login(padding)
                },
                containerColor = Persian_indigo
            )
        }
    }
}

@Composable
fun Login(paddingValues: PaddingValues){
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(top = 4.dp)
            .background(color = Periwinkle)
            //allows for the column to be scrollable. Might not show because there is not enough to scroll
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Located within repetitive functions/ header file
        // holds the pricing pal logo
        innerPricingBar()

        Text(
            textAlign = TextAlign.Center,
            text = "Login",
            fontSize = 60.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(25.dp))

        //Located within repetitive functions/ input text-fields file
        // holds the email text-field
        emailInputLogin()
        Spacer(modifier = Modifier.height(25.dp))

        //Located within repetitive functions/ input text-fields file
        // holds the password text-field
        passwordInputLogin()
        Spacer(modifier = Modifier.height(35.dp))

        passwordStrength()
        Spacer(modifier = Modifier.height(20.dp))
        //Login Button
        // will navigate to the Edit Upload Screen
        // they can't move on until they enter their email and password. Therefore button needs to be  disabled
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

        //Forgot Password Button
        //will navigate to the Forgot Password Screen
        TextButton(onClick = { /*TODO*/ }) {
            Text(
                textAlign = TextAlign.Center,
                text = "Forgot Password?",
                fontSize = 25.sp,
                color = Color.Black,
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        // --------- OR -------------
        // Located within repetitive functions/ buttons file
        lines()
        Spacer(modifier = Modifier.height(20.dp))

        //Register Here Button
        // will navigate to the Choose Registration Screen
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
                text = "Register Here",
                fontSize = 30.sp,
                color = Color.Black,
            )

        }

        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Composable
fun emailInputLogin(){
    var email by remember { mutableStateOf("") }// variable that holds a default state of text-field
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 30.dp, end = 30.dp),
        value = email,
        onValueChange = {email = it}, // will take in the input from the user
        textStyle = TextStyle.Default.copy(fontSize = 20.sp) ,
        placeholder = { Text("Enter email", fontSize = 20.sp) },
        /** The support text will not work if you have a modifier.*/
        //supportingText = { Text(text = "*required") },
        leadingIcon = { Icon(imageVector = Icons.Filled.Email, contentDescription = "Email Icon") },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Anti_flash_white,
            unfocusedContainerColor = Anti_flash_white,
            unfocusedIndicatorColor = Anti_flash_white,
            focusedIndicatorColor = Persian_indigo
        ),
        shape = RectangleShape,
    )
    /** I did this in replacement of the supporting text*/
    // This message is below the text-field
    // The message can change if their input is wrong
    Row(horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, start = 50.dp)
    ) {
        Text(
            text = "*required",
            fontSize = 20.sp,
            color = Color.DarkGray
        )
    }
}

@Composable
fun passwordInputLogin(){
    var password by remember { mutableStateOf("") }// variable that holds a default state of text-field
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 30.dp, end = 30.dp),
        value = password,
        onValueChange = { password = it }, // will take in the input from the user
        textStyle = TextStyle.Default.copy(fontSize = 20.sp),
        placeholder = { Text("Enter password", fontSize = 20.sp) },
        /** The support text will not work if you have a modifier.*/
        //supportingText = { Text(text = "*required")},
        visualTransformation = PasswordVisualTransformation(),// makes the password not visible to the user
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password), // This will show the black dots instead of letters
        leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = "Lock Icon") },
        trailingIcon = {
            //When clicked, it should switch the hidden icon to the eye icon
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = ImageVector.vectorResource(id = R.drawable.eye), contentDescription = "Lock Icon")
            }
        },
        /** This is for the hidden Icon that will turn the password hidden again.

        trailingIcon = {
        IconButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = ImageVector.vectorResource(id = R.drawable.eye), contentDescription = "Lock Icon")}
        },
         */
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Anti_flash_white,
            unfocusedContainerColor = Anti_flash_white,
            unfocusedIndicatorColor = Anti_flash_white,
            focusedIndicatorColor = Persian_indigo
        ),
        shape = RectangleShape,
    )
    /** I did this in replacement of the supporting text*/
    // This message is below the text-field
    // The message can change if their input is wrong
    Row(horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, start = 50.dp)
    ) {
        Text(
            text = "*required",
            fontSize = 20.sp,
            color = Color.DarkGray
        )
    }
}

@Composable
fun passwordStrength(){
    Row(horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            //.padding(top = 5.dp, start = 50.dp)
    ) {
        Text(
            textAlign = TextAlign.Center,
            text = "Password strength: ",
            fontSize = 30.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Text(
            textAlign = TextAlign.Center,
            text = "Weak",
            fontSize = 30.sp,
            color = Color.Black
        )
    }
    Text(
        textAlign = TextAlign.Center,
        text = "Password need to be stronger",
        fontSize = 30.sp,
        color = Color.Black
    )

    Spacer(modifier = Modifier.height(20.dp))

    TextButton(onClick = { /*TODO*/ }) {
        Text(
            textAlign = TextAlign.Center,
            text = "Why?",
            fontSize = 30.sp,
            color = Color.Black,
        )
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