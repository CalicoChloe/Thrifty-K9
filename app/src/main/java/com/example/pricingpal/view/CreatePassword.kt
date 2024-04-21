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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
 * Function: Create Password Header
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 *This function sets up a scaffold with top bar for the create password screen.
 * Users will see a display of the back arrow that will allow the user to navigate back to the login screen.
 * Below the bar will show the rest of the content of the create password screen.
 *
 * NOTE: I have the scaffold set up this way, so it matches the design from figma, so please don't change it.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreatePasswordHeader(windowSize: WindowSize){
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
                    createPassword(padding, windowSize)
                },

                // this needs to stay this color so the scaffold can have the lines beneath it.
                containerColor = Persian_indigo
            )
        }
    }
}

/**
 * Function: Create Password
 * @author: Shianne Lesure
 *
 * @param paddingValues aligns the content with top app bar
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function sets up the rest of the content of the create password screen.
 * Users will see some text-fields asking for an new password and a confirmed password to update their
 * forgotten password as well as message telling them if their password is too weak and a dialog
 * telling them what they need to do to fix it.
 * Below will be a create button that will allow them to update the password and login
 */
@Composable
fun createPassword(paddingValues: PaddingValues, windowSize: WindowSize){
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 40 else 60) }
    // will scale the size of the text
    val instructionTextSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 25 else 30) }

    Column(
            modifier = Modifier
                .padding(paddingValues)
                // this is here so the line above the pricing pal logo
                .padding(top = 4.dp)
                .background(color = Periwinkle)
                .verticalScroll(rememberScrollState()), // allows for the items in the column to scroll
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            innerPricingBar() // holds the pricing pal logo
            Text(
                textAlign = TextAlign.Center,
                text = "Create Password",
                fontSize = textSize.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                textAlign = TextAlign.Center,
                text = "Enter a new password and confirm the new password below",
                fontSize = instructionTextSize.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 5.dp, end = 5.dp)
            )

            Spacer(modifier = Modifier.height(25.dp))
            passwordInputCreatePassword() // holds the new password text-field
            Spacer(modifier = Modifier.height(25.dp))
            confirmPasswordInputCreatePassword() // confirms the new password text-field
            Spacer(modifier = Modifier.height(35.dp))
            passwordStrengthCreatePassword(windowSize)
            Spacer(modifier = Modifier.height(20.dp))

            //Create Button
            // This will navigate to the Login Screen
            // they can't click until they enter new password and confirm password.
            // Therefore button needs to be  disabled
            //This should also replace the password within the database
            createPasswordSnackBar(windowSize)

            Spacer(modifier = Modifier.height(60.dp))
        }
}

/**
 * Function: Password Input Create Password
 * @author: Shianne Lesure
 *
 * This function set up the text-field for the user to be able to put in a new password to be able
 * to be able to change their forgotten password. This is a requirement for the user to be able
 * to reset their password.
 */
@Composable
fun passwordInputCreatePassword(){
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
 * Function: Confirm Password Input Create Password
 * @author: Shianne Lesure
 *
 * This function set up the text-field for the user to be able to confirm the new password to be able
 * to be able to change their forgotten password. This is a requirement for the user to be able
 * to reset their password.
 */
@Composable
fun confirmPasswordInputCreatePassword(){
    var confirmPassword by remember { mutableStateOf("") } // variable that holds a default state of text-field
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 30.dp, end = 30.dp),
        value = confirmPassword,
        onValueChange = { confirmPassword = it }, // will take in the input from the user
        textStyle = TextStyle.Default.copy(fontSize = 20.sp),
        placeholder = { Text("Enter confirm new password", fontSize = 20.sp) },
        /** The support text will not work if you have a modifier.*/
        //supportingText = { Text(text = "*required")},
        visualTransformation = PasswordVisualTransformation(), // makes the password not visible to the user
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password), // This will show the black dots instead of letters
        leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = "Lock Icon") },
        trailingIcon = {
            //When clicked, it should switch the hidden icon to the eye icon
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = ImageVector.vectorResource(id = R.drawable.hidden), contentDescription = "Hidden Icon")
            }
        },
        /** This is for the eye Icon that will allow for the user to see their password.
        There will be a if statement where when this button is click, it should show the password.

        trailingIcon = {
        IconButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = ImageVector.vectorResource(id = R.drawable.eye), contentDescription = "Eye Icon")}
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
    // this will probably be done with an if statement giving the error "Confirm password does not match with password above."
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
 * Function: Password Strength Create Password
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function displays the message of whether their password is strong or weak.
 * If their password is weak, a message pops up saying that that the passwords is weak and it needs
 * to be stronger.
 */
@Composable
fun passwordStrengthCreatePassword(windowSize: WindowSize){
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 20 else 30) }
    Row(horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
        //.padding(top = 5.dp, start = 50.dp)
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

    passwordStrengthCreateDialog(windowSize)
}

/**
 * Function: Password Strength Create Dialog
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function will display a dialog when the why button is clicked. The dialog will show the user
 * what is needed to make their password stronger.
 */
@Composable
fun passwordStrengthCreateDialog(windowSize: WindowSize){
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
 * Function: Create Password Snack Bar
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function will display a snack-bar when the create button is clicked. The snack bar will show a
 * message verifying the password has been reset.
 *
 * NOTE: This isn't really how snack-bars are made. I tried to go the route it is usually made, but
 * for some reason I couldn't get it quite right. If I can get the originally way to work, I will change
 * it, but this should be fine for now.
 */
@Composable
fun createPasswordSnackBar(windowSize: WindowSize){
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
            text = "Create",
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
                text = "Password reset",
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