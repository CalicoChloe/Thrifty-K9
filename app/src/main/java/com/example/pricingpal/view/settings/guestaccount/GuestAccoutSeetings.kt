package com.example.pricingpal.view.settings.guestaccount

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
import androidx.compose.material.icons.filled.Delete
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo
import com.example.pricingpal.ui.theme.Uranian_Blue
import com.example.pricingpal.view.repetitivefunctions.settingNavigationBar
import com.example.pricingpal.view.repetitivefunctions.settingsBar
import com.example.pricingpal.view.settings.account.accountBackButton
import com.example.pricingpal.view.settings.account.accountDialog
import com.example.pricingpal.view.settings.account.emailEdit
import com.example.pricingpal.view.settings.account.passwordEdit

@Composable
fun guestAccountSetting(){
    Card(
        modifier = Modifier
            //.padding(start = 40.dp, top = 50.dp, end = 40.dp, bottom = 50.dp)
            .padding(start = 40.dp, end = 40.dp)
            .fillMaxSize()
            //.verticalScroll(rememberScrollState())
            .border(4.dp, color = Persian_indigo),
        shape = RectangleShape,
        elevation = CardDefaults.cardElevation(12.dp),
        colors = CardDefaults.cardColors(containerColor = Periwinkle)
    ) {

        settingNavigationBar()

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState()),
            // verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            settingsBar()
            Spacer(modifier = Modifier.height(20.dp))
            guestAccountBackButton()
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                textAlign = TextAlign.Center,
                text = "Organization Name ",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )

            Spacer(modifier = Modifier.height(20.dp))

            for(i in 1..4) {
                guestName()
            }
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}

@Composable
fun guestAccountBackButton(){
    Card(
        modifier = Modifier
            // padding around the card
            .padding(10.dp)
            .padding(start = 30.dp, end = 30.dp)
            .border(
                // puts a border around the card
                border = BorderStroke(4.dp, color = Persian_indigo),
                // shapes the card
                shape = RectangleShape
            ),
        elevation = CardDefaults.cardElevation(8.dp),
        // puts a shadow under the card to make it pop out
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                // changes the color of the card
                .background(color = Cornflower_blue, shape = RectangleShape)
                // changes the size of the card
                .fillMaxWidth()
                .height(90.dp)
        )
        {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowLeft,
                contentDescription = "Backward Arrow Icon",
                tint = Color.Black,
                modifier = Modifier
                    .size(50.dp)
                    .padding(start = 10.dp, top = 5.dp)
            )
            Text(
                text = "Guest Accounts",
                textAlign = TextAlign.Center,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(end = 40.dp)
                    .align(alignment = Alignment.CenterVertically)
            )
        }
    }
}

@Composable
fun guestName(){
    Card(
        modifier = Modifier
            // padding around the card
            .padding(10.dp)
            .padding(start = 20.dp, end = 20.dp)
            .border(
                // puts a border around the card
                border = BorderStroke(4.dp, color = Persian_indigo),
                // shapes the card
                shape = RectangleShape
            ),
        // puts a shadow under the card to make it pop out
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                // changes the color of the card
                .background(color = Cornflower_blue, shape = RectangleShape)
                // changes the size of the card
                .fillMaxWidth()
                .height(110.dp)
        )
        {
            Column() {
                Text(
                    text = "Email",
                    fontSize = 30.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 20.dp)
                    //.align(alignment = Alignment.CenterVertically)
                )

                Text(
                    text = "Password",
                    fontSize = 30.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 20.dp)
                    //.align(alignment = Alignment.CenterVertically)
                )
            }
            deleteIconDialog()
        }
    }
}
