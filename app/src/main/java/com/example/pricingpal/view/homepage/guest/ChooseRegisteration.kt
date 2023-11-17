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
        arrowNavigationBar()
        innerPricingBar() // Holds the pricing pal logo

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
            lines() //-------------OR-------------
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
