package com.example.pricingpal.view

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.pricingpal.R
import com.example.pricingpal.ui.theme.Anti_flash_white
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo

/**
 * Function: Guest Registeration Header
 * @author Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function sets up a scaffold with top bar for the guest registration screen.
 * Users will see a display of the back arrow that will allow the user to navigate back to the choose registration screen.
 * Below the bar will show the rest of the content of the owner registration screen.
 *
 * NOTE: I have the scaffold set up this way, so it matches the design from figma, so please don't change it.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuestRegisterationHeader(windowSize: WindowSize){
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
                    guestRegistration(padding, windowSize )
                },

                // this needs to stay this color so the scaffold can have the lines beneath it.
                containerColor = Persian_indigo
            )
        }
    }
}

/**
 * Function: Guest Registration
 * @author: Shianne Lesure
 *
 * @param paddingValues aligns the content with top app bar
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function sets up the rest of the content of the Guest Registration screen.
 * Users will see some text-fields asking for an email and password as well as message telling them
 * if their password is too weak and a dialog telling them what they need to do to fix it.
 * Below that will be the list of buttons the user can navigate to.
 */
@Composable
fun guestRegistration(paddingValues: PaddingValues, windowSize: WindowSize){
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 50 else 60) }

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
        Text(
            textAlign = TextAlign.Center,
            text = "Guest Registration",
            fontSize = textSize.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(25.dp))
        guestOrganizationName(windowSize)
        Spacer(modifier = Modifier.height(30.dp))

        // holds the username text-field
        usernameInputGuest()
        Spacer(modifier = Modifier.height(25.dp))

        // holds the email text-field
        emailInputGuest()
        Spacer(modifier = Modifier.height(25.dp))

        // holds the password text-field
        passwordInputGuest()
        Spacer(modifier = Modifier.height(25.dp))
        // check whether password is strong or weak
        passwordStrengthGuest(windowSize)
        Spacer(modifier = Modifier.height(20.dp))

        // Sign up Button
        signSnackBarGuest(windowSize)

        Spacer(modifier = Modifier.height(20.dp))

        Spacer(modifier = Modifier.height(60.dp))
    }
}

/**
 * Function: Guest Organization Name
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function will show the name of the organization the user picked from the guest company screen.
 * This should updated the name when the user clicks the organization from previous file
 */
@Composable
fun guestOrganizationName(windowSize: WindowSize){
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 30 else 40) }

    Card(
        shape = RectangleShape,
        modifier = Modifier
            .padding(start = 30.dp, end = 30.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(color = Cornflower_blue, shape = RectangleShape)
                .border(
                    border = BorderStroke(4.dp, color = Persian_indigo),
                    shape = RectangleShape
                )
                .fillMaxWidth()
                .padding(15.dp)
        )
        {

            Text(
                //This should update,when the user click on a company from the Guest Organization List
                text = "Organization Name",
                fontSize = textSize.sp,
                color = Color.Black,
            )
        }
    }
}

/**
 * Function: Username Input Guest
 * @author: Shianne Lesure
 *
 * This function sets up the text-field for the user to be able to put in their name to be able to
 * sign up. This is a requirement for the user to be able to navigate to the Upload screen.
 */
@Composable
fun usernameInputGuest(){
    var name by remember { mutableStateOf("") }// variable that holds a default state of text-field
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 30.dp, end = 30.dp),
        value = name,
        onValueChange = {name = it}, // will take in the input from the user
        textStyle = TextStyle.Default.copy(fontSize = 20.sp) ,
        placeholder = { Text("Enter name", fontSize = 20.sp) },
        /** The support text will not work if you have a modifier.*/
        //supportingText = { Text(text = "*required") },
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
 * Function: Email Input Guest
 * @author: Shianne Lesure
 *
 * This function sets up the text-field for the user to be able to put in their email to be able to
 * sign up. This is a requirement for the user to be able to navigate to the Upload screen.
 */
@Composable
fun emailInputGuest(){
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
 * Function: Password Input Guest
 * @author: Shianne Lesure
 *
 * This function set up the text-field for the user to be able to put in their password to be able to
 * sign up. This is a requirement for the user to be able to navigate to the Upload screen.
 */
@Composable
fun passwordInputGuest(){
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

/**
 * Function: Password Strength Guest
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function displays the message of whether their password is strong or weak.
 * If their password is weak, a message pops up saying that that the passwords is weak and it needs
 * to be stronger.
 */
@Composable
fun passwordStrengthGuest(windowSize: WindowSize){
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 20 else 30) }
    Row(horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            textAlign = TextAlign.Center,
            text = "Password strength: ",
            fontSize = textSize.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

        /*
        The password check would be coming from database. A if statement will be letting the user
        know if the password is weak or strong.

        if(password doesn't meet requirement ){
        Text(
            textAlign = TextAlign.Center,
            text = "Weak",
            fontSize = 30.sp,
            color = Color.Black
        )
        Text(
            textAlign = TextAlign.Center,
            text = "Password need to be stronger",
            fontSize = 30.sp,
            color = Color.Black
        )
        } else{
        Text(
            textAlign = TextAlign.Center,
            text = "Strong",
            fontSize = 30.sp,
            color = Color.Black
        )
        }
         */
        Text(
            textAlign = TextAlign.Center,
            text = "Weak",
            fontSize = textSize.sp,
            color = Color.Black
        )
    }
    Text(
        textAlign = TextAlign.Center,
        text = "Password need to be stronger",
        fontSize = textSize.sp,
        color = Color.Black
    )

    Spacer(modifier = Modifier.height(20.dp))

    passwordStrengthGuestDialog(windowSize)
}

/**
 * Function: Password Strength Guest Dialog
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function will display a dialog when the why button is clicked. The dialog will show the user
 * what is needed to make their password stronger.
 */
@Composable
fun passwordStrengthGuestDialog(windowSize: WindowSize){
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 20 else 30) }

    // a variable that determines if the state of the dialog to be use or not
    var showDialog by remember { mutableStateOf(false) }
    Column {
        TextButton(onClick = { showDialog = true }) {
            Text(
                textAlign = TextAlign.Center,
                text = "Why?",
                fontSize = textSize.sp,
                color = Color.Black,
            )
        }
    }
    // the dialog shows if why button is clicked
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
                    Text(text = "Passwords needs to be more than 8 characters.\n\n" +
                            "Must consist of one of each:\n" +
                            "- uppercase letter\n" +
                            "- symbol\n" +
                            "- digit\n" +
                            "- lower case letter",
                        fontSize = textSize.sp,
                        color = Color.Black,
                    )

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
                            fontSize = textSize.sp,
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}

/**
 * Function: Sign Snack Bar Guest
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function will display a snack-bar when the sign up button is clicked. The snack bar will show a
 * message verifying the user is sign in.
 *
 * NOTE: This isn't really how snack-bars are made. I tried to go the route it is usually made, but
 * for some reason I couldn't get it quite right. If I can get the originally way to work, I will change
 * it, but this should be fine for now.
 */
@Composable
fun signSnackBarGuest(windowSize: WindowSize) {
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
            text = "Sign Up",
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
                text = "You are sign up",
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