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
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pricingpal.R
import com.example.pricingpal.ui.theme.Anti_flash_white
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo

/**
 * Function: Login Header
 * @author Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function sets up a scaffold with top bar for the login screen.
 * Users will see a display of the back arrow that will allow the user to navigate back to the Home screen.
 * Below the bar will show the rest of the content of the login screen.
 *
 * NOTE: I have the scaffold set up this way, so it matches the design from figma, so please don't change it.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginHeader(navController: NavController, windowSize: WindowSize){
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
                    Login(padding, windowSize)
                },

                // this needs to stay this color so the scaffold can have the lines beneath it.
                containerColor = Persian_indigo
            )
        }
    }
}

/**
 * Function: Login
 * @author: Shianne Lesure
 *
 * @param paddingValues aligns the content with top app bar
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function sets up the rest of the content of the login screen.
 * Users will see some text-fields asking for an email and password as well as message telling them
 * if their password is too weak and a dialog telling them what they need to do to fix it.
 * Below that will be the list of buttons the user can navigate to.
 */
@Composable
fun Login(paddingValues: PaddingValues, windowSize: WindowSize){
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 50 else 60) }

    Column(
        modifier = Modifier
            .padding(paddingValues)
            // this is here so the line above the pricing pal logo
            .padding(top = 4.dp)
            .background(color = Periwinkle)
            //allows for the column to be scrollable. Might not show because there is not enough to scroll
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // holds the pricing pal logo
        innerPricingBar()

        Text(
            textAlign = TextAlign.Center,
            text = "Login",
            fontSize = textSize.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(25.dp))

        // holds the email text-field
        emailInputLogin()
        Spacer(modifier = Modifier.height(25.dp))

        // holds the password text-field
        passwordInputLogin()
        Spacer(modifier = Modifier.height(35.dp))

        //Login Button
        // will navigate to the Upload Screen
        // they can't move on until they enter their email and password. Therefore button needs to be  disabled
        loginSnackBar(windowSize)
        Spacer(modifier = Modifier.height(20.dp))

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
        lines(windowSize)
        Spacer(modifier = Modifier.height(20.dp))

        //Register Here Button
        // will navigate to the Choose Registration Screen
        TextButton(onClick = { /*TODO*/ }) {
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

/**
 * Function: Email Input Login
 * @author: Shianne Lesure
 *
 * This function sets up the text-field for the user to be able to put in their email to be able to
 * login. This is a requirement for the user to be able to navigate to the Upload screen.
 */
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

/**
 * Function: Password Input Login
 * @author: Shianne Lesure
 *
 * This function set up the text-field for the user to be able to put in their password to be able to
 * login. This is a requirement for the user to be able to navigate to the Upload screen.
 */
@Composable
fun passwordInputLogin(){
    var password by remember { mutableStateOf("") }// variable that holds a default state of text-field
    var hidePass by remember { mutableStateOf(true) } // variable that holds a default state of the password being hidden
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

        visualTransformation = if(hidePass) PasswordVisualTransformation() else VisualTransformation.None,// makes the password not visible to the user
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password), // This will show the black dots instead of letters
        leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = "Lock Icon") },
        trailingIcon = {
            //When clicked, it should switch the hidden icon to the eye icon
            IconButton(onClick = { hidePass = !hidePass }) {
                Icon(imageVector = ImageVector.vectorResource(id = R.drawable.eye), contentDescription = "Lock Icon")
            }
        },
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
 * Function: Login Snack Bar
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function will display a snack-bar when the login button is clicked. The snack bar will show a
 * message verifying the user is login.
 *
 * NOTE: This isn't really how snack-bars are made. I tried to go the route it is usually made, but
 * for some reason I couldn't get it quite right. If I can get the originally way to work, I will change
 * it, but this should be fine for now.
 */
@Composable
fun loginSnackBar(windowSize: WindowSize) {
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
            text = "Login",
            fontSize = textSize.sp,
            color = Color.Black,
        )
    }
    // the snack-bar will show if the login button is clicked
    if (showSnackBar) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { /*TODO*/
                    /* Will close the snack-bar and navigate to the next screen */
                })
                .height(snackBarHeight.dp)
                .padding(start = 25.dp, end = 25.dp)
                .border(2.dp, color = Persian_indigo)
                .shadow(5.dp, shape = RectangleShape)
                .background(color = Anti_flash_white, shape = RectangleShape),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                textAlign = TextAlign.Start,
                text = "You are login",
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



/**
 * Function: Lines
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function will display the OR message that is between every button
 */
@Composable
fun lines(windowSize: WindowSize){
    // will scale the height of the button
    val lineHeight by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 2 else 3) }
    // will scale the height of the button
    val lineWidth by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 130 else 260) }
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 25 else 30) }

    Row(modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ){
        Box(
            modifier = Modifier
                .padding(top = 20.dp, end = 10.dp)
                .height(height = lineHeight.dp)
                .width(lineWidth.dp)
                .background(color = Color.Black)
        )

        Text(
            textAlign = TextAlign.Center,
            text = "OR",
            fontSize = textSize.sp,
            color = Color.Black,
        )

        Box(
            modifier = Modifier
                .padding(top = 20.dp, start = 10.dp)
                .width(lineWidth.dp)
                .height(height = lineHeight.dp)
                .background(color = Color.Black)
        )
    }
}