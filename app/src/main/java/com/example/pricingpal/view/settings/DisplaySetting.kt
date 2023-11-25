package com.example.pricingpal.view.settings

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pricingpal.R
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo
import com.example.pricingpal.view.repetitivefunctions.settingNavigationBar
import com.example.pricingpal.view.repetitivefunctions.settingsBar

@Composable
fun displaySetting(){
    Card(
        modifier = Modifier
            .padding(start = 40.dp, end = 40.dp)
            .fillMaxSize()
            .border(4.dp, color = Persian_indigo),
        shape = RectangleShape,
        elevation = CardDefaults.cardElevation(12.dp),
        colors = CardDefaults.cardColors(containerColor = Periwinkle)
    ) {

        //holds the back arrow and settings icon
        // will navigate to the screen previous before
        settingNavigationBar()

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            settingsBar() // Holds the settings title

            Spacer(modifier = Modifier.height(30.dp))
            displayBackButton()// will navigate back to the settings home page screen

            Spacer(modifier = Modifier.height(50.dp))
            lightThemeButton() // will change the screens to light mode
            darkThemeButton() // will change the screens to dark mode

            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}

@Composable
fun displayBackButton(){
    Card(
        modifier = Modifier
            .padding(5.dp)
            .padding(start = 30.dp, end = 30.dp)
            .border(
                border = BorderStroke(4.dp, color = Persian_indigo),
                shape = RectangleShape
            ),
        elevation = CardDefaults.cardElevation(8.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .background(color = Cornflower_blue, shape = RectangleShape)
                .fillMaxWidth()
                .height(90.dp)
        )
        {
            //The Display Back Button
            //This will navigate to the setting home page screen
            IconButton(onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(50.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowLeft,
                    contentDescription = "Backward Arrow Icon",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(50.dp)
                        .padding(start = 10.dp, top = 5.dp)
                )
            }
            Text(
                text = "Display",
                textAlign = TextAlign.Center,
                fontSize = 40.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(end = 40.dp)
                    .align(alignment = Alignment.CenterVertically)
            )
        }
    }
}


@Composable
fun lightThemeButton(){
    Card(
        modifier = Modifier
            .padding(5.dp)
            .padding(start = 30.dp, end = 30.dp)
            .border(
                border = BorderStroke(4.dp, color = Persian_indigo),
                shape = RectangleShape
            ),
        elevation = CardDefaults.cardElevation(8.dp),
    ) {
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
                text = "Light Theme",
                fontSize = 30.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .align(alignment = Alignment.CenterVertically)
            )
            //Sun Icon Button
            // will change the screens to light mode theme
            IconButton(onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(70.dp)
                ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.light_theme),
                    contentDescription = "Light Theme Icon",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(70.dp)
                        .padding(end = 20.dp, top = 5.dp)
                )
            }
        }
    }
}

@Composable
fun darkThemeButton(){
    Card(
        modifier = Modifier
            .padding(5.dp)
            .padding(start = 30.dp, end = 30.dp)
            .border(
                border = BorderStroke(4.dp, color = Persian_indigo),
                shape = RectangleShape
            ),
        elevation = CardDefaults.cardElevation(8.dp),
    ) {
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
                text = "Dark Theme",
                fontSize = 30.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .align(alignment = Alignment.CenterVertically)
            )
            //Moon Icon Button
            // will change the screens to dark mode theme
            IconButton(onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(60.dp)
                ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.dark_theme1),
                    contentDescription = "Dark Theme Icon",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(60.dp)
                        .padding(end = 20.dp, top = 5.dp)
                )
            }
        }
    }
}