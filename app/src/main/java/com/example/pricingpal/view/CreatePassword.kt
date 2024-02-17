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
import com.example.pricingpal.R
import com.example.pricingpal.ui.theme.Anti_flash_white
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo

/**
 * This file will allow the user to create a new password and confirm it.
 * This UI will only show up when they click on the link that was given to them within the email.
 * They will make a new password that is not the old password within a text-field.
 * Below that they re type the new password confirming it to be the new password.
 * On the back end, it needs to be made sure that both string are identical of they can not press send.
 * Once they are done, the user can press create which will navigate them to the login screen.
 * On the back end, the new password will be updated within the database.
 */

/**
 * Function: Create Password Header
 * @author: Shianne Lesure
 *
 *This function sets up a scaffold with top bar for the create password screen.
 * Users will see a display of the back arrow that will allow the user to navigate back to the login screen.
 * Below the bar will show the rest of the content of the create password screen.
 *
 * NOTE: I have the scaffold set up this way, so it matches the design from figma, so please don't change it.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreatePasswordHeader(){
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
                    createPassword(padding)
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
 * This function sets up the rest of the content of the create password screen.
 * Users will see some text-fields asking for an new password and a confirmed password to update
 */
@Composable
fun createPassword(paddingValues: PaddingValues){
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
                fontSize = 60.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                textAlign = TextAlign.Center,
                text = "Enter a new password and confirm the new password below",
                fontSize = 30.sp,
                color = Color.Black,
                modifier = Modifier
            )

            Spacer(modifier = Modifier.height(25.dp))
            passwordInputCreatePassword() // holds the new password text-field
            Spacer(modifier = Modifier.height(25.dp))
            confirmPasswordInputCreatePassword() // confirms the new password text-field
            Spacer(modifier = Modifier.height(35.dp))
            passwordStrengthCreatePassword()
            Spacer(modifier = Modifier.height(20.dp))

            //Create Button
            // This will navigate to the Login Screen
            // they can't click until they enter new password and confirm password.
            // Therefore button needs to be  disabled
            //This should also replace the password within the database
            createPasswordSnackBar()

            Spacer(modifier = Modifier.height(60.dp))
        }
}

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

@Composable
fun passwordStrengthCreatePassword(){
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

    //passwordStrengthDialog()
}

@Composable
fun createPasswordSnackBar(){
    // a variable that determines if the snack-bar will be displayed or not
    var showSnackBar by remember { mutableStateOf(false) }
    ElevatedButton(
        onClick = { showSnackBar = true },
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
            text = "Create",
            fontSize = 40.sp,
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
                .height(80.dp)
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
                    .padding(top = 20.dp, start = 30.dp),
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
    }
}