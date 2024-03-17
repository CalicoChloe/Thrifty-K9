package com.example.pricingpal.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pricingpal.R
import com.example.pricingpal.ui.theme.Anti_flash_white
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UploadFormatHeader(windowSize: WindowSize){
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
                    upload(padding, windowSize)
                },

                // this needs to stay this color so the scaffold can have the lines beneath it.
                containerColor = Persian_indigo
            )
        }
    }
}

@Composable
fun upload(paddingValues: PaddingValues, windowSize: WindowSize){
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
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            // holds the pricing pal logo
            innerPricingBar()
            Spacer(modifier = Modifier.height(90.dp))
            uploadCSVButton(windowSize)
            Spacer(modifier = Modifier.height(40.dp))
            uploadLines(windowSize) // ----------- OR ------------
            Spacer(modifier = Modifier.height(40.dp))
            makeListButton(windowSize)
        }
    }
}

@Composable
fun uploadCSVButton(windowSize: WindowSize){
    //Upload CSV Button
    // will navigate to add CSV File Screen

    // will scale the height of the button
    val buttonHeight by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 120 else 140) }
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 40 else 50) }
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
            text = "Upload CSV",
            fontSize = textSize.sp,
            color = Color.Black,
        )
    }
}

/**
 * Function: Upload Lines
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function will display the OR message that is between every button
 */
@Composable
fun uploadLines(windowSize: WindowSize){
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

@Composable
fun makeListButton(windowSize: WindowSize){
    //Make List Button
    // will navigate to add Edit List Screen

    // will scale the height of the button
    val buttonHeight by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 120 else 140) }
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 40 else 50) }
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
            text = "Make List",
            fontSize = textSize.sp,
            color = Color.Black,
        )
    }
}