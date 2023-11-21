package com.example.pricingpal.view.homepage.login

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import com.example.pricingpal.view.repetitivefunctions.arrowNavigationBar
import com.example.pricingpal.view.repetitivefunctions.emailInput
import com.example.pricingpal.view.repetitivefunctions.innerPricingBar
import com.example.pricingpal.view.repetitivefunctions.lines
import com.example.pricingpal.view.repetitivefunctions.passwordInput

/**
 * This file will allow the user to login to make edits to their list.
 * They will login with their email and password.
 * If they don't have a login the can click on the register button or if they forgot a password, they
 * can lick on the forgot password.
 * On the back end, the database should take that login an put it within the client's table.
 * */

@Composable
fun login(){
    Card(
        modifier = Modifier
            .padding(start = 40.dp, end = 40.dp)
            .fillMaxSize()
            .border(4.dp, color = Persian_indigo),
        shape = RectangleShape,
        elevation = CardDefaults.cardElevation(12.dp),
        colors = CardDefaults.cardColors(containerColor = Periwinkle)
    ) {
        // This hold the back arrow for navigation
        // Navigates to the Starter Screen
        // Located within repetitive functions/ header file
        arrowNavigationBar()

        Column(
            modifier = Modifier
                //allows for the column to be scrollable. Might not show because there is not enough to scroll
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Located within repetitive functions/ header file
            // holds the pricing pal logo
            innerPricingBar()

            Text(
                textAlign = TextAlign.Center,
                text = "Login",
                fontSize = 60.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(25.dp))

            //Located within repetitive functions/ input text-fields file
            // holds the email text-field
            emailInput()
            Spacer(modifier = Modifier.height(25.dp))

            //Located within repetitive functions/ input text-fields file
            // holds the password text-field
            passwordInput()
            Spacer(modifier = Modifier.height(35.dp))

            //Login Button
            // will navigate to the Edit Upload Screen
            // they can't move on until they enter their email and password. Therefore button needs to be  disabled
            ElevatedButton(
                onClick = { /*TODO*/ },
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(Cornflower_blue),
                elevation = ButtonDefaults.buttonElevation(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(start = 25.dp, top = 15.dp, end = 25.dp, bottom = 15.dp)
                    .border(4.dp, color = Persian_indigo),

                ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = "Login",
                    fontSize = 40.sp,
                    color = Color.Black,
                )
            }

            //Forgot Password Button
            //will navigate to the Forgot Password Screen
            TextButton(onClick = { /*TODO*/ }) {
                Text(
                    textAlign = TextAlign.Center,
                    text = "Forgot Password?",
                    fontSize = 20.sp,
                    color = Color.Black,
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
            // --------- OR -------------
            // Located within repetitive functions/ buttons file
            lines()
            Spacer(modifier = Modifier.height(20.dp))

            //Register Here Button
            // will navigate to the Choose Registration Screen
            ElevatedButton(
                onClick = { /*TODO*/ },
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(Cornflower_blue),
                elevation = ButtonDefaults.buttonElevation(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(start = 70.dp, top = 15.dp, end = 70.dp, bottom = 15.dp)
                    .border(4.dp, color = Persian_indigo),

                ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = "Register Here",
                    fontSize = 30.sp,
                    color = Color.Black,
                )

            }

        }
    }
}
