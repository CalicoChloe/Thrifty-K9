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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Settings
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
import androidx.compose.material3.TextButton
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
import com.example.pricingpal.R
import com.example.pricingpal.ui.theme.Anti_flash_white
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingHeader(windowSize: WindowSize){
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
                        actions = {
                            IconButton(onClick = { /*TODO*/ },
                            ) {
                                Icon(imageVector = Icons.Filled.Settings,
                                    contentDescription = "Setting Gear Button",
                                    tint = Color.Black,
                                    modifier = Modifier
                                        .size(50.dp)
                                )

                            }
                        }
                    )
                },

                content = { padding ->
                    //settingsBar(paddingValues = padding)

                    settings(padding, windowSize)
                },

                // this needs to stay this color so the scaffold can have the lines beneath it.
                containerColor = Persian_indigo
            )
        }
    }
}

@Composable
fun settings(paddingValues: PaddingValues, windowSize: WindowSize){
    //settingsBar(paddingValues)

        Card(
            modifier = Modifier
                .padding(paddingValues)
                .padding(top = 4.dp)
                /*
                .border(
                    border = BorderStroke(4.dp, color = Persian_indigo),
                    shape = RectangleShape
                )
                 */
                    ,
            colors = CardDefaults.cardColors(containerColor = Periwinkle)
        ) {
            settingsBar()
            LazyColumn(
                //aligns the categories within the center
                modifier = Modifier
                    .padding(start = 30.dp, end = 30.dp, top = 40.dp, bottom = 370.dp)
                    .fillMaxSize()
                    .border(
                        border = BorderStroke(4.dp, color = Persian_indigo),
                        shape = RectangleShape
                    ),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                item {
                    ownerAccountButton()
                    Divider(thickness = 4.dp, color = Persian_indigo)
                }

                item {
                    guestAccountButton()
                    Divider(thickness = 4.dp, color = Persian_indigo)
                }

                item {
                    displayButton()
                    Divider(thickness = 4.dp, color = Persian_indigo)
                }

                item { accessibilityButton() }

            }
        }
    logoutButton(paddingValues, windowSize)
}


@Composable
fun ownerAccountButton(){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .background(color = Cornflower_blue, shape = RectangleShape)
                .fillMaxWidth()
                .height(90.dp)
        )
        {
            Text(
                text = "Account",
                fontSize = 40.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .align(alignment = Alignment.CenterVertically)
            )
            /** Account Button
             * Will navigate you to the account setting screen*/
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

@Composable
fun guestAccountButton(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .background(color = Cornflower_blue, shape = RectangleShape)
            .fillMaxWidth()
            .height(90.dp)
    )
    {
        Text(
            text = "Guest Accounts",
            fontSize = 40.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(start = 20.dp)
                .align(alignment = Alignment.CenterVertically)
        )
        /** Guest Account Button
         * Will navigate you to the guest account setting screen*/
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

@Composable
fun displayButton(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .background(color = Cornflower_blue, shape = RectangleShape)
            .fillMaxWidth()
            .height(90.dp)
    )
    {
        Text(
            text = "Display",
            fontSize = 40.sp,
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

@Composable
fun accessibilityButton(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .background(color = Cornflower_blue, shape = RectangleShape)
            .fillMaxWidth()
            .height(90.dp)
    )
    {
        Text(
            text = "Accessibility",
            fontSize = 40.sp,
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
/*
@Composable
fun logoutButton(paddingValues: PaddingValues){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .fillMaxWidth()
            .padding(paddingValues)
            .padding(top = 700.dp)

    ){
        ElevatedButton(
            onClick = { /*TODO*/ },
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(Cornflower_blue),
            elevation = ButtonDefaults.buttonElevation(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(start = 35.dp, top = 15.dp, end = 35.dp, bottom = 15.dp)
                .border(4.dp, color = Persian_indigo),

            ) {
            Text(
                textAlign = TextAlign.Center,
                text = "Logout",
                fontSize = 40.sp,
                color = Color.Black,
            )
        }
    }
}

 */

@Composable
fun logoutButton(paddingValues: PaddingValues, windowSize: WindowSize){
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 20 else 30) }

    // a variable that determines if the state of the dialog to be use or not
    var showDialog by remember { mutableStateOf(false) }
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
                .padding(top = 700.dp)

        ){
            ElevatedButton(
                onClick = { showDialog = true },
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(Cornflower_blue),
                elevation = ButtonDefaults.buttonElevation(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(start = 35.dp, top = 15.dp, end = 35.dp, bottom = 15.dp)
                    .border(4.dp, color = Persian_indigo),

                ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = "Logout",
                    fontSize = 40.sp,
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
                        //Spacer(modifier = Modifier.width(25.dp))

                        //No Button
                        // will close you out the dialog box
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