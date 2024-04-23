package com.example.pricingpal.view

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.pricingpal.PricingPalAppBar
import com.example.pricingpal.R
import com.example.pricingpal.ui.theme.Anti_flash_white
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo

/**
 * Function: Setting Header
 * @author Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function sets up a scaffold with top bar for the setting header screen.
 * Users will see a display of the back arrow that will allow the user to navigate back to whatever the prevoius screen was before.
 * Below the bar will show the rest of the content of the setting header screen.
 *
 * NOTE: I have the scaffold set up this way, so it matches the design from figma, so please don't change it.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingHeader(windowSize: WindowSize, navController: NavController){
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
                /*
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
                        }
                    )
                },

                 */

                topBar = {
                    PricingPalAppBar(
                        navigateUp = { navController.navigateUp() },
                        canNavigateBack = navController.previousBackStackEntry != null
                    )
                },

                content = { padding ->
                    settings(padding, windowSize, navController)
                },

                // this needs to stay this color so the scaffold can have the lines beneath it.
                containerColor = Persian_indigo
            )
        }
    }
}

/**
 * Function: Settings
 * @author: Shianne Lesure
 *
 * @param paddingValues aligns the content with top app bar
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function sets up the rest of the content of the settings screen.
 * Users will see a list of buttons that will navigate to accounts, display, and accessability as well
 * as being able to log out the app.
 */
@Composable
fun settings(paddingValues: PaddingValues, windowSize: WindowSize, navController: NavController){
    // scale height of the lazy column
    val lazyHeight by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 310 else 370) }

        Card(
            modifier = Modifier
                .padding(paddingValues)
                .padding(top = 4.dp),
            colors = CardDefaults.cardColors(containerColor = Periwinkle)
        ) {
            settingsBar(windowSize)
            LazyColumn(
                modifier = Modifier
                    .padding(start = 30.dp, end = 30.dp, top = 40.dp, bottom = lazyHeight.dp)
                    .fillMaxSize()
                    .border(
                        border = BorderStroke(4.dp, color = Persian_indigo),
                        shape = RectangleShape
                    ),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                item {
                    ownerAccountButton(windowSize, navController)
                    Divider(thickness = 4.dp, color = Persian_indigo)
                }

                item {
                    guestAccountButton(windowSize, navController)
                    Divider(thickness = 4.dp, color = Persian_indigo)
                }

                item {
                    displayButton(windowSize)
                    Divider(thickness = 4.dp, color = Persian_indigo)
                }

                item { accessibilityButton(windowSize) }

            }
        }
    logoutButton(paddingValues, windowSize)
}

/**
 * Function: Owner Account Button
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function creates the button that will navigate to the owner's account screen.
 */
@Composable
fun ownerAccountButton(windowSize: WindowSize, navController: NavController){
    // will scale the height of the button
    val buttonHeight by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 70 else 90) }
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 30 else 40) }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .background(color = Cornflower_blue, shape = RectangleShape)
                .fillMaxWidth()
                .height(buttonHeight.dp)
        )
        {
            Text(
                text = "Account",
                fontSize = textSize.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .align(alignment = Alignment.CenterVertically)
            )
            /** Account Button
             * Will navigate you to the account setting screen*/
            IconButton(onClick = {  navController.navigate(Screen.OwnerAccount.route) },
                modifier = Modifier
                    .size(50.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowRight,
                    contentDescription = "Forward Arrow Icon",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(50.dp)
                        .padding(end = 10.dp, top = 5.dp)
                )
            }
        }
}

/**
 * Function: Guest Account Button
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function creates the button that will navigate to the guest account screen.
 */
@Composable
fun guestAccountButton(windowSize: WindowSize, navController: NavController){
    // will scale the height of the button
    val buttonHeight by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 70 else 90) }
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 30 else 40) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .background(color = Cornflower_blue, shape = RectangleShape)
            .fillMaxWidth()
            .height(buttonHeight.dp)
    )
    {
        Text(
            text = "Guest Accounts",
            fontSize = textSize.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(start = 20.dp)
                .align(alignment = Alignment.CenterVertically)
        )
        /** Guest Account Button
         * Will navigate you to the guest account setting screen*/
        IconButton(onClick = { navController.navigate(Screen.GuestAccount.route) },
            modifier = Modifier
                .size(50.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowRight,
                contentDescription = "Forward Arrow Icon",
                tint = Color.Black,
                modifier = Modifier
                    .size(50.dp)
                    .padding(end = 10.dp, top = 5.dp)
            )
        }
    }
}

/**
 * Function: Display Button
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function creates the button that will navigate to the display screen.
 */
@Composable
fun displayButton(windowSize: WindowSize){
    // will scale the height of the button
    val buttonHeight by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 70 else 90) }
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 30 else 40) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .background(color = Cornflower_blue, shape = RectangleShape)
            .fillMaxWidth()
            .height(buttonHeight.dp)
    )
    {
        Text(
            text = "Display",
            fontSize = textSize.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(start = 20.dp)
                .align(alignment = Alignment.CenterVertically)
        )
        /** Display Button
         * Will navigate you to the display setting screen*/
        IconButton(onClick = { /*TODO*/ },
            modifier = Modifier
                .size(50.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowRight,
                contentDescription = "Forward Arrow Icon",
                tint = Color.Black,
                modifier = Modifier
                    .size(50.dp)
                    .padding(end = 10.dp, top = 5.dp)
            )
        }
    }
}

/**
 * Function: Accessibility Button
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function creates the button that will navigate to the accessibility screen.
 */
@Composable
fun accessibilityButton(windowSize: WindowSize){
    // will scale the height of the button
    val buttonHeight by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 70 else 90) }
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 30 else 40) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .background(color = Cornflower_blue, shape = RectangleShape)
            .fillMaxWidth()
            .height(buttonHeight.dp)
    )
    {
        Text(
            text = "Accessibility",
            fontSize = textSize.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(start = 20.dp)
                .align(alignment = Alignment.CenterVertically)
        )
        /** Accessibility Button
         * Will navigate you to the accessibility setting screen*/
        IconButton(onClick = { /*TODO*/ },
            modifier = Modifier
                .size(50.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowRight,
                contentDescription = "Forward Arrow Icon",
                tint = Color.Black,
                modifier = Modifier
                    .size(50.dp)
                    .padding(end = 10.dp, top = 5.dp)
            )
        }
    }
}

/**
 * Function: Logout Button
 * @author: Shianne Lesure
 *
 * @param paddingValues aligns the content with top app bar
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function creates the button that will navigate to a dialog display to the user whether they
 * want to logout of the app or not.
 */
@Composable
fun logoutButton(paddingValues: PaddingValues, windowSize: WindowSize){
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 20 else 30) }
    // will scale space from the app bar to the logout button
    val topPadding by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 580 else 700) }
    // will scale the height of the button
    val buttonHeight by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 100 else 120) }
    // will scale the size of button text
    val buttonText by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 30 else 40) }

    // a variable that determines if the state of the dialog to be use or not
    var showDialog by remember { mutableStateOf(false) }
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
                .padding(top = topPadding.dp)

        ){
            ElevatedButton(
                onClick = { showDialog = true },
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(Cornflower_blue),
                elevation = ButtonDefaults.buttonElevation(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(buttonHeight.dp)
                    .padding(start = 35.dp, top = 15.dp, end = 35.dp, bottom = 15.dp)
                    .border(4.dp, color = Persian_indigo),

                ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = "Logout",
                    fontSize = buttonText.sp,
                    color = Color.Black,
                )
            }
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
                    Text(text = "Are you sure you want to logout?",
                        fontSize = textSize.sp,
                        color = Color.Black,
                    )

                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                    ){

                        //No Button will close you out the dialog box
                        Button(
                            onClick = { showDialog = false },
                            shape =  RectangleShape,
                            colors = ButtonDefaults.buttonColors(Cornflower_blue),
                            elevation = ButtonDefaults.buttonElevation(8.dp),
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .border(3.dp, color = Persian_indigo),
                        ) {
                            Text("No",
                                fontSize = 25.sp,
                                color = Color.Black
                            )
                        }

                        Spacer(modifier = Modifier.width(50.dp))

                        // Yes button will close the user out the dialog box and naivgate them to the home page screen
                        Button(
                            onClick = { showDialog = false },
                            shape =  RectangleShape,
                            colors = ButtonDefaults.buttonColors(Cornflower_blue),
                            elevation = ButtonDefaults.buttonElevation(8.dp),
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .border(3.dp, color = Persian_indigo),
                        ) {
                            Text("Yes",
                                fontSize = 25.sp,
                                color = Color.Black
                            )
                        }

                    }
                }
            }
        }
    }
}