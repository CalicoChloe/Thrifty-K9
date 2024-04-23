package com.example.pricingpal.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pricingpal.R
import com.example.pricingpal.ui.theme.Anti_flash_white
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo

/**
 * Function: Forgot Password Header
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function sets up a scaffold with top bar for the forgot password screen.
 * Users will see a display of the back arrow that will allow the user to navigate back to the login screen.
 * Below the bar will show the rest of the content of the  forgot password screen.
 *
 * NOTE: I have the scaffold set up this way, so it matches the design from figma, so please don't change it.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordHeader(windowSize: WindowSize){
    // will scale the space of the card
    val cardSpacer by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 25 else 40) }

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
                .padding(start = cardSpacer.dp, end = cardSpacer.dp)
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
                    forgotPassword(padding, windowSize)
                },

                // this needs to stay this color so the scaffold can have the lines beneath it.
                containerColor = Persian_indigo
            )
        }
    }
}

/**
 * Function: Forgot Password
 * @author: Shianne Lesure
 *
 * @param paddingValues aligns the content with top app bar
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function sets up the rest of the content of the forgot password screen.
 * Users will see some text-field asking for an email that will verify them to be able to reset their password.
 * On the back end, a link should be sent to their email that will take them the the create password
 * UI to make new password.
 */
@Composable
fun forgotPassword(paddingValues: PaddingValues, windowSize: WindowSize) {
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 40 else 60) }
    // will scale the size of the text
    val instructionTextSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 25 else 30) }
    // will scale the space between the buttons
    val buttonSpacer by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 180 else 260) }

    Column(
        modifier = Modifier
            .padding(paddingValues)
            // this is here so the line above the pricing pal logo
            .padding(top = 4.dp)
            .background(color = Periwinkle)
            .verticalScroll(rememberScrollState()), // allows for the items in the column to scroll
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // holds the pricing pal logo
        innerPricingBar()
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            textAlign = TextAlign.Center,
            text = "Forgot Password?",
            fontSize = textSize.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            textAlign = TextAlign.Center,
            text = "Enter registered email for reset password",
            fontSize = instructionTextSize.sp,
            color = Color.Black,
            modifier = Modifier
        )

        Spacer(modifier = Modifier.height(50.dp))

        // holds the email text-field
        emailInputForgotPassword()

        Spacer(modifier = Modifier.height(50.dp))

        // Holds the send button that will display a snack message before navigating to a redirect URL
        forgotPasswordSnackBar(windowSize)
        Spacer(modifier = Modifier.height(buttonSpacer.dp))
    }
}

/**
 * Function: Email Input Forgot Password
 * @author: Shianne Lesure
 *
 * This function sets up the text-field for the user to be able to put in their email to be able to
 * have access to the URL to change their password.
 * This is a requirement for the user to be able to navigate to the change password screen.
 */
@Composable
fun emailInputForgotPassword(){
    var email by remember { mutableStateOf("") }// variable that holds a default state of text-field
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 30.dp, end = 30.dp)
            .testTag("emailTextField"),
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

/**
 * Function: Forgot Password Snack Bar
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function will display a snack-bar when the send button is clicked. The snack bar will show a
 * message verifying the user the email has been sent.
 *
 * NOTE: This isn't really how snack-bars are made. I tried to go the route it is usually made, but
 * for some reason I couldn't get it quite right. If I can get the originally way to work, I will change
 * it, but this should be fine for now.
 */
@Composable
fun forgotPasswordSnackBar(windowSize: WindowSize) {
    // will scale the height of the button
    val buttonHeight by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 110 else 120) }
    // will scale the height of the snack-bar
    val snackBarHeight by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 70 else 80) }
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 35 else 40) }
    // will scale the size of the snack-bar padding
    val snackBarPaddingTop by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 15 else 20) }
    // will scale the size of the snack-bar padding
    val snackBarPadding by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 15 else 30) }

    // a variable that determines if the snack-bar will be displayed or not
    var showSnackBar by remember { mutableStateOf(false) }
    ElevatedButton(
        onClick = { showSnackBar = true },
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(Cornflower_blue),
        elevation = ButtonDefaults.buttonElevation(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(buttonHeight.dp)
            .padding(start = 25.dp, top = 15.dp, end = 25.dp, bottom = 15.dp)
            .border(4.dp, color = Persian_indigo),

        ) {
        Text(
            textAlign = TextAlign.Center,
            text = "Send",
            fontSize = textSize.sp,
            color = Color.Black,
        )
    }
    // the snack-bar will show if the send button is clicked
    if (showSnackBar) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = { /*TODO*/
                    /* Will close the snack-bar and navigate to the next screen */ })
                    .height(snackBarHeight.dp)
                    .padding(start = 25.dp, end = 25.dp)
                    .border(2.dp, color = Persian_indigo)
                    .shadow(5.dp, shape = RectangleShape)
                    .background(color = Anti_flash_white, shape = RectangleShape),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    textAlign = TextAlign.Start,
                    text = "Email was sent",
                    modifier = Modifier
                        .padding(top = snackBarPaddingTop.dp, start = snackBarPadding.dp),
                    fontSize = 25.sp,
                    color = Color.Black,
                )

                Text(
                    textAlign = TextAlign.End,
                    text = "OK",
                    modifier = Modifier
                        .padding(top = snackBarPaddingTop.dp, end = snackBarPadding.dp),
                    fontSize = 25.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
    }

}

