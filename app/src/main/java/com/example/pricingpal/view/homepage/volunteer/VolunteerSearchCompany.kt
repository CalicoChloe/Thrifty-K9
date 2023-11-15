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
import com.example.pricingpal.view.repetitivefunctions.pricingPalBar
import com.example.pricingpal.view.repetitivefunctions.searchBar



@Composable
fun volunteerCompaniesTitle(){
    Card(
        shape = RectangleShape,
        modifier = Modifier
            .padding(top = 15.dp)
            .padding(15.dp),
        elevation = CardDefaults.cardElevation(12.dp),
    ) {
        Column( //verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(color = Cornflower_blue, shape = RectangleShape)
                .border(
                    // puts a border around the card
                    border = BorderStroke(4.dp, color = Persian_indigo),
                    // shapes the card
                    shape = RectangleShape
                )
                .fillMaxWidth()
                .padding(15.dp)
        )
        {

            Text(
                //shows the name of the category
                text = "Organizations",
                fontSize = 60.sp,
                // have it in bold to make it stand out
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )

            Text(
                //shows the name of the category
                text = "Select only one organization",
                fontSize = 30.sp,
                color = Color.Black,
            )
        }
    }
}

@Composable
fun volunteerCompanyName(){
    Card(
        modifier = Modifier
            // padding around the card
            .padding(15.dp)
            .border(
                // puts a border around the card
                border = BorderStroke(4.dp, color = Persian_indigo),
                // shapes the card
                shape = RectangleShape
            ),
        // puts a shadow under the card to make it pop out
        elevation = CardDefaults.cardElevation(12.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                // changes the color of the card
                .background(color = Periwinkle, shape = RectangleShape)
                // changes the size of the card
                .fillMaxWidth()
                .height(80.dp)
        )
        {
            Text(
                text = "Organization Name",
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
    arrowNavigationBar()
    LazyColumn(
        modifier = Modifier
            .padding(top = 54.dp)
    ) {
        item {
            pricingPalBar()
        }
        stickyHeader {
            searchBar()
            Divider(thickness = 4.dp, color = Persian_indigo)
        }
        item {
            volunteerCompaniesTitle()
        }
        for(i in 1..10) {
            item {
                volunteerCompanyName()
            }
        }
    }
}