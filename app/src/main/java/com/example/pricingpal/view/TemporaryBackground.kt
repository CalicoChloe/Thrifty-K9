package com.example.pricingpal.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pricingpal.R
import com.example.pricingpal.ui.theme.Anti_flash_white
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Persian_indigo
import com.example.pricingpal.view.homepage.guest.companyList
import com.example.pricingpal.view.homepage.guest.companySearchBar
import com.example.pricingpal.view.homepage.guest.guestRegistration
import com.example.pricingpal.view.homepage.guest.ownerOrGuess
import com.example.pricingpal.view.homepage.guest.ownerRegistration
import com.example.pricingpal.view.homepage.guest.pricingPalBar
import com.example.pricingpal.view.homepage.login.createPassword
import com.example.pricingpal.view.homepage.login.forgotPassword
import com.example.pricingpal.view.homepage.login.login
import com.example.pricingpal.view.homepage.startScreen

@Composable
fun background(){
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
        //startScreen()
        //forgotPassword()
        //login()
        //createPassword()
        //ownerOrGuess()
        //ownerRegistration()
        //companyList()
        guestRegistration()
    }
}

// This will be for the settings bar
@Composable
fun settingRow(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ){
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(270.dp),
            shape = RectangleShape,
            elevation = CardDefaults.cardElevation(12.dp),
            colors = CardDefaults.cardColors(containerColor = Cornflower_blue)
        ){
            Image(
                //Imports image from resource folder
                painter = painterResource(id = R.drawable.logo),
                //description of the image for accessibility
                contentDescription = "Pictures of paws",
                modifier = Modifier
                    .padding(top = 15.dp, start = 25.dp, end = 25.dp, bottom = 5.dp)
            )

            companySearchBar()
        }
    }
}

@Composable
fun look(){
    Row(modifier = Modifier
        .border(4.dp, color = Persian_indigo)
        .fillMaxWidth()
        .background(color = Cornflower_blue, shape = RectangleShape),
        horizontalArrangement = Arrangement.Center,
    ) {
        Image(
            //Imports image from resource folder
            painter = painterResource(id = R.drawable.logo),
            //description of the image for accessibility
            contentDescription = "Pictures of paws",
            modifier = Modifier
                .padding(15.dp)
        )
    }
}