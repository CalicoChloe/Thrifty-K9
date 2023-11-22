package com.example.pricingpal.view.homepage.volunteer

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo
import com.example.pricingpal.view.repetitivefunctions.arrowNavigationBar
import com.example.pricingpal.view.repetitivefunctions.companySearchBar
import com.example.pricingpal.view.repetitivefunctions.pricingPalBar

/**
 * This file will allow the user to see a list of all of the organizations that are registered.
 * On the back end, the list should be shown from the database.
 * They can only select one organization. Once clicked, a loading screen will appear which will then
 * load the category list for volunteers.
 */

@Composable
fun volunteerCompaniesTitle(){
    Card(
        shape = RectangleShape,
        modifier = Modifier
            .padding(top = 15.dp)
            .padding(15.dp),
        elevation = CardDefaults.cardElevation(12.dp),
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
                text = "Organizations",
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )

            Text(
                text = "Select only one organization",
                fontSize = 30.sp,
                color = Color.Black,
            )
        }
    }
}

/** This will show the name of the companies.
 * A company should be added when the owner register their organization.
 * This will be pulled from the database*/
@Composable
fun volunteerCompanyName(){
    // The card needs to be clickable
    // Only one card can be clicked at a time
    // This will navigate to the Volunteer loading Screen
    Card(
        modifier = Modifier
            .padding(15.dp)
            .border(
                border = BorderStroke(4.dp, color = Persian_indigo),
                shape = RectangleShape
            ),
        elevation = CardDefaults.cardElevation(12.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .background(color = Periwinkle, shape = RectangleShape)
                .fillMaxWidth()
                .height(80.dp)
        )
        {
            Text(
                text = "Organization Name", // Will show up from database when Owner makes registration
                fontSize = 30.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .align(alignment = Alignment.CenterVertically)
            )

        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun volunteerCompanyList(){
    // Holds the navigation of the back arrow
    // Navigates to the choose registration Screen
    // Located within repetitive functions/ header file
    arrowNavigationBar()
    LazyColumn(
        modifier = Modifier
            .padding(top = 54.dp)
    ) {
        item {
            // holds the pricing pal logo
            // This will collapse when scrolling up
            // Located within repetitive functions/ header file
            pricingPalBar()
        }
        stickyHeader {
            /** I tried to make a top bar that was collapsable, but it wasn't working on my end so I
             * did this instead to get the same effect. The sticky header will allow for the search
             * bar to still show when scrolling down.*/
            // This will allow for you to look up the company's name if the list became too long
            companySearchBar()
            Divider(thickness = 4.dp, color = Persian_indigo)
        }
        item {
            volunteerCompaniesTitle()
        }
        for(i in 1..10) { // this will change when it is being pulled from the database
            item {
                volunteerCompanyName()
            }
        }
    }
}