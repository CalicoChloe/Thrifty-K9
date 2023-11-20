package com.example.pricingpal.view.homepage.guest

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pricingpal.R
import com.example.pricingpal.ui.theme.Anti_flash_white
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo
import com.example.pricingpal.view.repetitivefunctions.arrowNavigationBar
import com.example.pricingpal.view.repetitivefunctions.emailInput
import com.example.pricingpal.view.repetitivefunctions.innerPricingBar
import com.example.pricingpal.view.repetitivefunctions.passwordInput
import com.example.pricingpal.view.repetitivefunctions.signUpButton

@Composable
fun ownerRegistration(){
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
        // Located within repetitive functions/ header file
        arrowNavigationBar()

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState()), // allows for the items in the column to scroll
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Located within repetitive functions/ header file
            // holds the pricing pal logo
            innerPricingBar()
            Text(
                textAlign = TextAlign.Center,
                text = "Owner Registration",
                fontSize = 60.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(25.dp))
            ownerOrganizationInput() // holds the organization text-field
            Spacer(modifier = Modifier.height(25.dp))

            //Located within repetitive functions/ input text-fields file
            // holds the email text-field
            emailInput()
            Spacer(modifier = Modifier.height(25.dp))

            //Located within repetitive functions/ input text-fields file
            // holds the password text-field
            passwordInput()
            Spacer(modifier = Modifier.height(25.dp))

            // Located within repetitive functions/ buttons file
            // Sign up Button
            signUpButton()

            Spacer(modifier = Modifier.height(60.dp))
        }
    }
}

@Composable
fun ownerOrganizationInput(){
    var ownerOrganization by remember { mutableStateOf("") } // variable that holds a default state of text-field
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 30.dp, end = 30.dp),
        value = ownerOrganization,
        onValueChange = {ownerOrganization = it}, // will take in the input from the user
        textStyle = TextStyle.Default.copy(fontSize = 20.sp) ,
        placeholder = { Text("Enter your organization", fontSize = 20.sp) },
        //supportingText = { Text(text = "*required") },
        leadingIcon = { Icon(imageVector = ImageVector.vectorResource(id = R.drawable.baseline_add_business_24), contentDescription = "Business Icon") },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Anti_flash_white,
            unfocusedContainerColor = Anti_flash_white,
            unfocusedIndicatorColor = Anti_flash_white,
            focusedIndicatorColor = Persian_indigo
        ),
        shape = RectangleShape,
    )
    /** I did this in replacement of the supporting text*/
    // This message is below the text-field
    // The message can change if their input is wrong
    Row(horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, start = 50.dp)
    ) {
        Text(
            text = "*required",
            fontSize = 20.sp,
            color = Color.DarkGray
        )
    }
}
