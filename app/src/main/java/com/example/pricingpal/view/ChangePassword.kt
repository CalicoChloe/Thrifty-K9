package com.example.pricingpal.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
 * Function: Change Password Header
 * @author Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function sets up a scaffold with top bar for the change password screen.
 * Users will see a display of the back arrow that will allow the user to navigate back to owner account page.
 * Below the bar will show the rest of the content of the change password screen.
 *
 * NOTE: I have the scaffold set up this way, so it matches the design from figma, so please don't change it.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChangePasswordHeader(windowSize: WindowSize){
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
                    changePassword(padding, windowSize)
                },

                // this needs to stay this color so the scaffold can have the lines beneath it.
                containerColor = Persian_indigo
            )
        }
    }
}

/**
 * Function: Change Password
 * @author: Shianne Lesure
 *
 * @param paddingValues aligns the content with top app bar
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function sets up the rest of the content of the change password screen.
 * Users will see a list of instructions with 2 text-fields explaining they need to input the old password
 * and new password which will be saved for update.
 */
@Composable
fun changePassword(paddingValues: PaddingValues, windowSize: WindowSize){
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
            .verticalScroll(rememberScrollState()), // allows for the items in the column to scroll,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        settingsBar(windowSize)
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            textAlign = TextAlign.Center,
            text = "Change Password",
            fontSize = textSize.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))
        if(windowSize.width == WindowType.Compact){
            Text(
                textAlign = TextAlign.Center,
                text = "New password should be \n different from old password",
                fontSize = instructionTextSize.sp,
                color = Color.Black,
            )
        } else {
            Text(
                textAlign = TextAlign.Center,
                text = "New password should be different from old password",
                fontSize = instructionTextSize.sp,
                color = Color.Black,
            )
        }

        Spacer(modifier = Modifier.height(50.dp))

        oldInputChangePassword()
        Spacer(modifier = Modifier.height(10.dp))
        newInputChangePassword()
        Spacer(modifier = Modifier.height(35.dp))
        passwordStrengthChangePassword(windowSize)
        Spacer(modifier = Modifier.height(15.dp))

        savePassword(windowSize)
        Spacer(modifier = Modifier.height(20.dp))
    }
}

/**
 * Function: Old Input Change Password
 * @author: Shianne Lesure
 *
 * This function set up the text-field for the user to be able to input their old password.
 */
@Composable
fun oldInputChangePassword(){
    var oldPassword by remember { mutableStateOf("") }// variable that holds a default state of text-field
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 30.dp, end = 30.dp),
        value = oldPassword,
        onValueChange = {oldPassword = it}, // will take in the input from the user
        textStyle = TextStyle.Default.copy(fontSize = 20.sp) ,
        placeholder = { Text("Enter old password", fontSize = 20.sp) },
        /** The support text will not work if you have a modifier.*/
        //supportingText = { Text(text = "*required") },
        visualTransformation = PasswordVisualTransformation(), // makes the password not visible to the user
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password), // This will show the black dots instead of letters
        leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = "Lock Icon") },
        trailingIcon = {
            //When clicked, it should switch the hidden icon to the eye icon
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = ImageVector.vectorResource(id = R.drawable.hidden), contentDescription = "Hidden Icon")
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
 * Function: New Input Change Password
 * @author: Shianne Lesure
 *
 * This function set up the text-field for the user to be able to input their new password.
 */
@Composable
fun newInputChangePassword(){
    var newPassword by remember { mutableStateOf("") }// variable that holds a default state of text-field
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 30.dp, end = 30.dp),
        value = newPassword,
        onValueChange = {newPassword = it}, // will take in the input from the user
        textStyle = TextStyle.Default.copy(fontSize = 20.sp) ,
        placeholder = { Text("Enter new password", fontSize = 20.sp) },
        /** The support text will not work if you have a modifier.*/
        //supportingText = { Text(text = "*required") },
        visualTransformation = PasswordVisualTransformation(), // makes the password not visible to the user
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password), // This will show the black dots instead of letters
        leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = "Lock Icon") },
        trailingIcon = {
            //When clicked, it should switch the hidden icon to the eye icon
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = ImageVector.vectorResource(id = R.drawable.hidden), contentDescription = "Hidden Icon")
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
 * Function: Password Strength Change Password
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function displays the message of whether their password is strong or weak.
 * If their password is weak, a message pops up saying that that the passwords is weak and it needs
 * to be stronger.
 */
@Composable
fun passwordStrengthChangePassword(windowSize: WindowSize){
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

    passwordStrengthChangeDialog(windowSize)
}

/**
 * Function: Password Strength Change Dialog
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function will display a dialog when the why button is clicked. The dialog will show the user
 * what is needed to make their password stronger.
 */
@Composable
fun passwordStrengthChangeDialog(windowSize: WindowSize){
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
 * Function: Save Password
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function will display a button that will allow the user to save the updated information.
 */
@Composable
fun savePassword(windowSize: WindowSize){
    // will scale the height of the button
    val buttonHeight by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 100 else 120) }
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 35 else 40) }

    ElevatedButton(
        onClick = { /*TODO*/ },
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
            text = "Save",
            fontSize = textSize.sp,
            color = Color.Black,
        )
    }
}