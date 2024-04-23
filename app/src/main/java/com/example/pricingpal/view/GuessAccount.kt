package com.example.pricingpal.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.material.icons.filled.Delete
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
import androidx.compose.runtime.collectAsState
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pricingpal.R
import com.example.pricingpal.model.User
import com.example.pricingpal.ui.theme.Anti_flash_white
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo
import com.example.pricingpal.viewmodel.UserFileViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun guestAccountHeader(windowSize: WindowSize){

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
                        guestAccount(padding, windowSize)
                },

                // this needs to stay this color so the scaffold can have the lines beneath it.
                containerColor = Persian_indigo
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun guestAccount(paddingValues: PaddingValues, windowSize: WindowSize, userFileViewModel: UserFileViewModel = hiltViewModel() ){

    val userList = userFileViewModel.userList.collectAsState(initial = listOf()).value

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
            LazyColumn(
                modifier = Modifier
                    .padding(top = 15.dp, start = 30.dp, end = 30.dp),
                //.border(4.dp, color = Persian_indigo)
                //.background(color = Cornflower_blue, shape = RectangleShape),
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                stickyHeader {
                    guestAccountTitle(windowSize)
                }
                item {
                    // guestAccountTitle(windowSize)
                    Spacer(modifier = Modifier.height(10.dp))
                    organizationUser(windowSize)
                    Spacer(modifier = Modifier.height(10.dp))
                }
                if(!userList.isNullOrEmpty()){
                    for(user in userList){
                        item { guestUsers(user, userFileViewModel) }
                    }
                }
            }
            //Spacer(modifier = Modifier.height(20.dp))

            //Spacer(modifier = Modifier.height(30.dp))
        }
    }
}

@Composable
fun guestAccountTitle(windowSize: WindowSize) {
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
            text = "Guest Accounts",
            textAlign = TextAlign.Center,
            fontSize = textSize.sp,
            color = Color.Black,
            modifier = Modifier
                .align(alignment = Alignment.CenterVertically)
        )
    }
}

@Composable
fun organizationUser(windowSize: WindowSize) {
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
            text = "Organization" + "'s Users",
            textAlign = TextAlign.Center,
            fontSize = textSize.sp,
            color = Color.Black,
            modifier = Modifier
                .align(alignment = Alignment.CenterVertically)
        )
    }
}

@Composable
fun guestUsers(user: User, userFileViewModel: UserFileViewModel){
    if(!user.isOwner) {
        Card(
            modifier = Modifier
                .padding(10.dp)
                .padding(start = 20.dp, end = 20.dp)
                .border(
                    border = BorderStroke(4.dp, color = Persian_indigo),

                    shape = RectangleShape
                ),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .background(color = Cornflower_blue, shape = RectangleShape)
                    .fillMaxWidth()
                    .height(110.dp)
            )
            {
                Column() {
                    Text(
                        text = user.fullName,
                        fontSize = 30.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(start = 20.dp)
                    )

                    Text(
                        text = user.email,
                        fontSize = 30.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(start = 20.dp)
                    )
                }
                deleteIconDialog(userFileViewModel, user, user.email)
            }
        }
    }
}


@Composable
fun deleteIconDialog(userFileViewModel: UserFileViewModel, user: User, email: String){
    var showDialog by remember { mutableStateOf(false) }// a variable that determines if the state of the dialog to be use or not
    Column {
        // Delete Icon Button
        // will send you to a dialog asking if you want to delete the guest account
        IconButton(onClick = { showDialog = true
            //userViewModel.getOneUser(user.email)
        },
            modifier = Modifier
                .size(50.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Delete,
                contentDescription = "Delete Icon",
                tint = Color.Black,
                modifier = Modifier
                    .size(50.dp)
                    .padding(end = 10.dp)
            )
        }
    }
    if (showDialog) {// the dialog shows if send button is clicked
        Dialog(onDismissRequest = {showDialog = false}) {
            // Custom shape, background, and layout for the dialog
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
                    Text(text = "Do you want to delete this account?\n\n" + user.email,

                        fontSize = 40.sp, // 40
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ){
                        ElevatedButton(
                            onClick = { showDialog = false
                                 },
                            elevation = ButtonDefaults.buttonElevation(8.dp),
                            shape = RectangleShape,
                            colors = ButtonDefaults.buttonColors(Cornflower_blue),
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .border(3.dp, color = Persian_indigo),

                            ) {
                            Text(
                                textAlign = TextAlign.Center,
                                text = "Yes",
                                fontSize = 25.sp,
                                color = Color.Black,
                            )
                        }

                        Spacer(modifier = Modifier.width(25.dp))
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

                    }
                }
            }
        }
    }
}







