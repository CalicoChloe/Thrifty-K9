package com.example.pricingpal.view.homepage.guest

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.example.pricingpal.view.repetitivefunctions.arrowNavigationBar
import com.example.pricingpal.view.repetitivefunctions.emailInput
import com.example.pricingpal.view.repetitivefunctions.innerPricingBar
import com.example.pricingpal.view.repetitivefunctions.passwordInput
import com.example.pricingpal.view.repetitivefunctions.signUpButton

@Composable
fun guestRegistration(){
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
        // Navigates to the choose registration Screen
        arrowNavigationBar()

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState()), // allows for the items in the column to scroll

            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            innerPricingBar() // holds the pricing pal logo
            Text(
                textAlign = TextAlign.Center,
                text = "Guest Registration",
                fontSize = 60.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(25.dp))
            organizationName()
            Spacer(modifier = Modifier.height(35.dp))
            emailInput() // holds the email text-field
            Spacer(modifier = Modifier.height(25.dp))
            passwordInput() // holds the password text-field
            Spacer(modifier = Modifier.height(25.dp))

            // Sign up Button
            signUpButton()

            Spacer(modifier = Modifier.height(60.dp))
        }
    }
}

@Composable
fun organizationName(){
    Card(
        shape = RectangleShape,
        modifier = Modifier
            .padding(start = 30.dp, end = 30.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(color = Cornflower_blue, shape = RectangleShape)
                .border(
                    border = BorderStroke(4.dp, color = Persian_indigo),
                    shape = RectangleShape
                )
                .fillMaxWidth()
                .padding(15.dp)
        )
        {

            Text(
                //This should update,when the user click on a company from the Guest Organization List
                text = "Organization Name",
                fontSize = 40.sp,
                color = Color.Black,
            )
        }
    }
}
