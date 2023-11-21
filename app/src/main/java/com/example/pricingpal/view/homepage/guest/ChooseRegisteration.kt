package com.example.pricingpal.view.homepage.guest

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo
import com.example.pricingpal.view.repetitivefunctions.arrowNavigationBar
import com.example.pricingpal.view.repetitivefunctions.innerPricingBar
import com.example.pricingpal.view.repetitivefunctions.lines

/** This file  will allow for the user to choose between 2 options.
 * The 1st option is owner which will be through the owner of the company.
 * This will navigate them to the screen owner registration where it would take organization, email, and password.
 *
 * The 2nd option is guest which will be through management or anyone else that the owner wants to allow have access to the list.
 * This will navigate them to screen guest company list where it will show a list of companies that are registered from the owner.
 * */
@Composable
fun ownerOrGuess(){
    Card(
        modifier = Modifier
            .padding(start = 40.dp, end = 40.dp)
            .fillMaxSize()
            .border(4.dp, color = Persian_indigo),
        shape = RectangleShape,
        elevation = CardDefaults.cardElevation(12.dp),
        colors = CardDefaults.cardColors(containerColor = Periwinkle)
    ) {

        // Holds the navigation of the back arrow
        // Navigates to the Starter Screen
        // Located within repetitive functions/ header file
        arrowNavigationBar()

        // Located within repetitive functions/ header file
        // holds the pricing pal logo
        innerPricingBar()

        Column(
            modifier = Modifier
                .padding(top = 90.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            //Owner Button
            // This will navigate to the Owner Registration Screen
            ElevatedButton(
                onClick = { /*TODO*/ },
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(Cornflower_blue),
                elevation = ButtonDefaults.buttonElevation(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .padding(start = 25.dp, top = 15.dp, end = 25.dp, bottom = 15.dp)
                    .border(4.dp, color = Persian_indigo),

                ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = "Owner",
                    fontSize = 50.sp,
                    color = Color.Black,
                )
            }

            Spacer(modifier = Modifier.height(40.dp))
            lines() // Located within repetitive functions/ buttons file
            Spacer(modifier = Modifier.height(40.dp))

            // Guest Button
            // This will navigate to the Guest Company List Screen
            ElevatedButton(
                onClick = { /*TODO*/ },
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(Cornflower_blue),
                elevation = ButtonDefaults.buttonElevation(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .padding(start = 25.dp, top = 15.dp, end = 25.dp, bottom = 15.dp)
                    .border(4.dp, color = Persian_indigo),

                ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = "Guest",
                    fontSize = 50.sp,
                    color = Color.Black,
                )
            }
        }
    }
}
