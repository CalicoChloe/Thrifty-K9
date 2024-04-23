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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.pricingpal.R
import com.example.pricingpal.ui.theme.Anti_flash_white
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo
import com.example.pricingpal.ui.theme.Uranian_Blue

/**
 * Function: Owner Account Header
 * @author Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function sets up a scaffold with top bar for the owner account header screen.
 * Users will see a display of the back arrow that will allow the user to navigate back to settings page.
 * Below the bar will show the rest of the content of the owner account header screen.
 *
 * NOTE: I have the scaffold set up this way, so it matches the design from figma, so please don't change it.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ownerAccountHeader(windowSize: WindowSize, navController: NavController){
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
                        }
                    )
                },

                content = { padding ->
                    ownerAccount(padding, windowSize, navController)
                },

                // this needs to stay this color so the scaffold can have the lines beneath it.
                containerColor = Persian_indigo
            )
        }
    }
}

/**
 * Function: Owner Account
 * @author: Shianne Lesure
 *
 * @param paddingValues aligns the content with top app bar
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function sets up the rest of the content of the owner account screen.
 * Users will see a list of edit buttons that will allow them to edit their organization name,
 * the user's name, email, & password. They will also have the option to delete their account.
 */
@Composable
fun ownerAccount(paddingValues: PaddingValues, windowSize: WindowSize, navController: NavController){
    Card(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .border(4.dp, color = Persian_indigo),
        shape = RectangleShape,
        elevation = CardDefaults.cardElevation(12.dp),
        colors = CardDefaults.cardColors(containerColor = Periwinkle)
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            settingsBar(windowSize) // Holds the settings title
            Spacer(modifier = Modifier.height(30.dp))
            Column(
                modifier = Modifier
                    .padding(top = 15.dp, start = 30.dp, bottom = 15.dp, end = 30.dp)
                    .border(4.dp, color = Persian_indigo)
                    .background(color = Cornflower_blue, shape = RectangleShape),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                accountTitle(windowSize)
                Spacer(modifier = Modifier.height(20.dp))
                organizationNameEdit(windowSize)
                nameEdit(windowSize,navController)
                emailEdit(windowSize)
                passwordEdit(windowSize)
                Spacer(modifier = Modifier.height(20.dp))
            }

            Spacer(modifier = Modifier.height(20.dp))
            deleteAccountButton(windowSize)
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}

/**
 * Function: Account Title
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function creates the title for the word account above the edit buttons.
 */
@Composable
fun accountTitle(windowSize: WindowSize){
    // will scale the height of the row
    val rowHeight by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 70 else 90) }
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 30 else 40) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(color = Cornflower_blue, shape = RectangleShape)
            .fillMaxWidth()
            .height(rowHeight.dp)
            .border(
                border = BorderStroke(4.dp, color = Persian_indigo),
                shape = RectangleShape
            ),
    )
    {
        Text(
            text = "Account",
            textAlign = TextAlign.Center,
            fontSize = textSize.sp,
            color = Color.Black,
            modifier = Modifier
                .align(alignment = Alignment.CenterVertically)
        )
    }
}

/**
 * Function: Organization Name Edit
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function will allow the user to change the organization through the edit button.
 */
@Composable
fun organizationNameEdit(windowSize: WindowSize){
    // will scale the height of the button
    val buttonHeight by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 70 else 90) }
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 30 else 40) }
    // will scale the size of the padding for the text
    val startPadding by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 15 else 20) }
    // will scale the height of the edit button
    val editHeight by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 45 else 60) }
    // will scale the width of the edit button
    val editWidth by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 100 else 200) }
    // will scale the size of the edit text
    val editTextSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 20 else 30) }
    // will scale the size of the edit padding
    val editPadding by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 15 else 30) }
    // will scale the size of the edit border
    val editBorder by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 3 else 4) }

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
            text = "Organization",
            fontSize = textSize.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(start = startPadding.dp)
                .align(alignment = Alignment.CenterVertically)
        )
        // Edit Button will navigate to the change organization screen
        ElevatedButton(
            onClick = { /*TODO*/ },
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(Uranian_Blue),
            elevation = ButtonDefaults.buttonElevation(8.dp),
            modifier = Modifier
                .width(editWidth.dp)
                .height(editHeight.dp)
                .padding(end = editPadding.dp)
                .border(editBorder.dp, color = Persian_indigo),

            ) {
            Text(
                textAlign = TextAlign.Center,
                text = "Edit",
                fontSize = editTextSize.sp,
                color = Color.Black,
            )
        }
    }
}

/**
 * Function: Name Edit
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function will allow the user to change the name of the user through the edit button.
 */
@Composable
fun nameEdit(windowSize: WindowSize, navController: NavController){
    // will scale the height of the button
    val buttonHeight by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 70 else 90) }
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 30 else 40) }
    // will scale the size of the padding for the text
    val startPadding by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 15 else 20) }
    // will scale the height of the edit button
    val editHeight by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 45 else 60) }
    // will scale the width of the edit button
    val editWidth by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 100 else 200) }
    // will scale the size of the edit text
    val editTextSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 20 else 30) }
    // will scale the size of the edit padding
    val editPadding by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 15 else 30) }
    // will scale the size of the edit border
    val editBorder by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 3 else 4) }

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
            text = "Name",
            fontSize = textSize.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(start = startPadding.dp)
                .align(alignment = Alignment.CenterVertically)
        )
        // Edit Button will navigate to the change password screen
        ElevatedButton(
            onClick = { navController.navigate(Screen.ChangeUsername.route) },
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(Uranian_Blue),
            elevation = ButtonDefaults.buttonElevation(8.dp),
            modifier = Modifier
                .width(editWidth.dp)
                .height(editHeight.dp)
                .padding(end = editPadding.dp)
                .border(editBorder.dp, color = Persian_indigo),

            ) {
            Text(
                textAlign = TextAlign.Center,
                text = "Edit",
                fontSize = editTextSize.sp,
                color = Color.Black,
            )
        }
    }
}

/**
 * Function: Email Edit
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function will allow the user to change their email through the edit button.
 */
@Composable
fun emailEdit(windowSize: WindowSize){
    // will scale the height of the button
    val buttonHeight by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 70 else 90) }
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 30 else 40) }
    // will scale the size of the padding for the text
    val startPadding by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 15 else 20) }
    // will scale the height of the edit button
    val editHeight by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 45 else 60) }
    // will scale the width of the edit button
    val editWidth by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 100 else 200) }
    // will scale the size of the edit text
    val editTextSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 20 else 30) }
    // will scale the size of the edit padding
    val editPadding by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 15 else 30) }
    // will scale the size of the edit border
    val editBorder by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 3 else 4) }

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
            text = "Email",
            fontSize = textSize.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(start = startPadding.dp)
                .align(alignment = Alignment.CenterVertically)
        )
        //Edit Button will navigate to the change email screen
        ElevatedButton(
            onClick = { /*TODO*/ },
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(Uranian_Blue),
            elevation = ButtonDefaults.buttonElevation(8.dp),
            modifier = Modifier
                .width(editWidth.dp)
                .height(editHeight.dp)
                .padding(end = editPadding.dp)
                .border(editBorder.dp, color = Persian_indigo),

            ) {
            Text(
                textAlign = TextAlign.Center,
                text = "Edit",
                fontSize = editTextSize.sp,
                color = Color.Black,
            )
        }
    }
}

/**
 * Function: Password Edit
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function will allow the user to change the password through the edit button.
 */
@Composable
fun passwordEdit(windowSize: WindowSize){
    // will scale the height of the button
    val buttonHeight by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 70 else 90) }
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 30 else 40) }
    // will scale the size of the padding for the text
    val startPadding by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 15 else 20) }
    // will scale the height of the edit button
    val editHeight by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 45 else 60) }
    // will scale the width of the edit button
    val editWidth by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 100 else 200) }
    // will scale the size of the edit text
    val editTextSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 20 else 30) }
    // will scale the size of the edit padding
    val editPadding by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 15 else 30) }
    // will scale the size of the edit border
    val editBorder by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 3 else 4) }

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
            text = "Password",
            fontSize = textSize.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(start = startPadding.dp)
                .align(alignment = Alignment.CenterVertically)
        )
        // Edit Button
        // will navigate to the change password screen
        ElevatedButton(
            onClick = { /*TODO*/ },
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(Uranian_Blue),
            elevation = ButtonDefaults.buttonElevation(8.dp),
            modifier = Modifier
                .width(editWidth.dp)
                .height(editHeight.dp)
                .padding(end = editPadding.dp)
                .border(editBorder.dp, color = Persian_indigo),

            ) {
            Text(
                textAlign = TextAlign.Center,
                text = "Edit",
                fontSize = editTextSize.sp,
                color = Color.Black,
            )
        }
    }
}

/**
 * Function: Logout Button
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function creates the button that will navigate to a dialog display to the user whether they
 * want to delete of the app or not.
 */
@Composable
fun deleteAccountButton(windowSize: WindowSize){
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 20 else 30) }
    // will scale the height of the button
    val buttonHeight by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 100 else 120) }
    // will scale the size of button text
    val buttonText by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 30 else 40) }
    // will scale the size of the text
    val textSize2 by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 20 else 25) }

    // a variable that determines if the state of the dialog to be use or not
    var showDialog by remember { mutableStateOf(false) }
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .fillMaxWidth()
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
                    text = "Delete Account",
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
                    Text(text = "By deleting this account, you will be deleting the organization.\n " +
                            "Do you still wish to delete?" ,
                        fontSize = textSize.sp,
                        color = Color.Black,
                    )

                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                    ){

                        //delete Button will close the user out the dialog box and navigate them to the home page screen
                        Button(
                            onClick = { showDialog = false },
                            shape =  RectangleShape,
                            colors = ButtonDefaults.buttonColors(Cornflower_blue),
                            elevation = ButtonDefaults.buttonElevation(8.dp),
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .border(3.dp, color = Persian_indigo),
                        ) {
                            Text("Delete",
                                fontSize = textSize2.sp,
                                color = Color.Black
                            )
                        }

                        Spacer(modifier = Modifier.width(50.dp))

                        // Cancel button will close the user out the dialog box
                        Button(
                            onClick = { showDialog = false },
                            shape =  RectangleShape,
                            colors = ButtonDefaults.buttonColors(Cornflower_blue),
                            elevation = ButtonDefaults.buttonElevation(8.dp),
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .border(3.dp, color = Persian_indigo),
                        ) {
                            Text("Cancel",
                                fontSize = textSize2.sp,
                                color = Color.Black
                            )
                        }

                    }
                }
            }
        }
    }
}