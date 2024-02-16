package com.example.pricingpal.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.pricingpal.R
import com.example.pricingpal.ui.theme.Anti_flash_white
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * This file will allow for the user to enter their email to reset their password.
 * They will enter the email they use for registration within the text field.
 * When they click send, a dialog will pop up saying "email was sent".
 * On the back end, a link should be sent to their email that will take them the the create password
 * UI to make new password.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordHeader(){
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
        ) {

            Scaffold(
                // creates the top app bar for the back arrow navigation
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
                    forgotPassword(padding)
                },

                // this needs to stay this color so the scaffold can have the lines beneath it.
                containerColor = Persian_indigo
            )
        }
    }
}

@Composable
fun forgotPassword(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            // this is here so the line above the pricing pal logo
            .padding(top = 4.dp)
            .background(color = Periwinkle)
            .verticalScroll(rememberScrollState()), // allows for the items in the column to scroll
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Located within repetitive functions/ header file
        // holds the pricing pal logo
        innerPricingBar()
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            textAlign = TextAlign.Center,
            text = "Forgot Password?",
            fontSize = 60.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            textAlign = TextAlign.Center,
            text = "Enter registered email for reset password",
            fontSize = 30.sp,
            color = Color.Black,
            modifier = Modifier
        )

        Spacer(modifier = Modifier.height(50.dp))

        //Located within repetitive functions/ input text-fields file
        // holds the email text-field
        emailInputForgotPassword()

        Spacer(modifier = Modifier.height(50.dp))
        //forgotPasswordDialog() // holds the send button that will take you to the forgot password dialog
        ElevatedButton(
            onClick = { forgotPasswordSnackBar()},
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
                text = "Send",
                fontSize = 40.sp,
                color = Color.Black,
            )
        }
        Spacer(modifier = Modifier.height(260.dp))
        forgotPasswordSnackBar()
        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Composable
fun emailInputForgotPassword(){
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

/** This functionality hold the dialog for when the user press the button send,
 * it will show them the message "Email was sent".
 * On the back end, the database should send a link to the user of the create password UI*/
@Composable
fun forgotPasswordDialog() {
    // a variable that determines if the state of the dialog to be use or not
    var showDialog by remember { mutableStateOf(false) }
    Column {

        // Send Button
        //this will allow for the dialog to be open
        // this button will also send a verification link to the user's email
        ElevatedButton(
            onClick = { showDialog = true },
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
                text = "Send",
                fontSize = 40.sp,
                color = Color.Black,
            )
        }
    }
    // the dialog shows if send button is clicked
    if (showDialog) {
        Dialog(onDismissRequest = {showDialog = false}) {

            //Hold makes up the dialog box
            Surface(
                shape = RectangleShape,
                color = Color.White,
                modifier = Modifier
                    .shadow(elevation = 8.dp, RectangleShape)
                    .border(2.dp, color = Color.Black),
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // Holds the message that will be shown in dialog
                    Text(text = "Email was sent",
                        fontSize = 35.sp,
                        color = Color.Black,
                    )
                    /** somewhere here is where the there a connection to where the link is sent to
                     * their email from the database.*/

                    //Close button
                    // will exit the dialog
                    Button(
                        onClick = { showDialog = false },
                        shape =  RectangleShape,
                        colors = ButtonDefaults.buttonColors(Cornflower_blue),
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .border(3.dp, color = Persian_indigo),
                    ) {
                        Text("Close",
                            fontSize = 25.sp,
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun forgotPasswordSnackBar(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* Will navigate the user to the next screen */ }
            .height(80.dp)
            .padding(start = 25.dp, end = 25.dp)
            .border(2.dp, color = Persian_indigo)
            .shadow(5.dp, shape = RectangleShape)
            .background(color = Anti_flash_white, shape = RectangleShape),
        horizontalArrangement = Arrangement.SpaceBetween,
    ){
        Text(
            textAlign = TextAlign.Start,
            text = "Email was sent",
            modifier = Modifier
                .padding(top = 20.dp, start = 30.dp),
                //.fillMaxWidth(),
            fontSize = 25.sp,
            color = Color.Black,
        )

        Text(
            textAlign = TextAlign.End,
            text = "OK",
            modifier = Modifier
                .padding(top = 20.dp, end = 30.dp),
            fontSize = 30.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
    }

    /*
    ElevatedButton(
        onClick = { /*TODO*/ },
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(Anti_flash_white),
        elevation = ButtonDefaults.buttonElevation(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(start = 25.dp, top = 15.dp, end = 25.dp, bottom = 15.dp)
            .border(2.dp, color = Persian_indigo),

        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            //horizontalArrangement = Arrangement.Center,
        ){
            Text(
                textAlign = TextAlign.Start,
                text = "Email was sent",
                modifier = Modifier
                    .fillMaxWidth(),
                fontSize = 30.sp,
                color = Color.Black,
            )

            Text(
                textAlign = TextAlign.Center,
                text = "OK",
                modifier = Modifier
                    .fillMaxWidth(),
                fontSize = 30.sp,
                color = Color.Black,
            )
        }


        /*
        Text(
            textAlign = TextAlign.Center,
            text = "Email was sent",
            modifier = Modifier
                .fillMaxWidth(),
            fontSize = 30.sp,
            color = Color.Black,
        )

         */

    }



/*
    Column {
        val (snackbarVisibleState, setSnackBarState) = remember { mutableStateOf(false) }


        Button(onClick = { setSnackBarState(!snackbarVisibleState) }) {
            if (snackbarVisibleState) {
                Text("Send")
            }
            /*
            else {
                Text("Send")
            }

             */
        }


        if (snackbarVisibleState) {
            Snackbar(

                action = {
                    /*
                    Button(onClick = {setSnackBarState(!snackbarVisibleState)}) {
                        Text("MyAction")
                    }

                     */
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(
                            textAlign = TextAlign.Center,
                            text = "Register Here",
                            fontSize = 30.sp,
                            color = Color.Black,
                        )
                    }
                },


                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "This is a snack-bar!")
            }
        }
    }

 */

*/

}

