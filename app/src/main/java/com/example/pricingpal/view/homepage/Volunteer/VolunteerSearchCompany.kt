package com.example.pricingpal.view.homepage.Volunteer

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pricingpal.R
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo
import com.example.pricingpal.ui.theme.Uranian_Blue
import com.example.pricingpal.view.homepage.guest.pricingPalBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun volunteerCompanySearchBar(){
    Card(
        modifier = Modifier
            //.nestedScroll(rememberNestedScrollInteropConnection())
            //.verticalScroll(rememberScrollState())
            .fillMaxWidth(),
        //.shadow(12.dp)
        //.height(500.dp),
        shape = RectangleShape,
        //elevation = CardDefaults.cardElevation(12.dp),
        colors = CardDefaults.cardColors(containerColor = Cornflower_blue)
    ){
        Spacer(modifier = Modifier.height(20.dp))
        var searching by remember { mutableStateOf("") }
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(start = 50.dp, end = 50.dp),
            value = searching,
            onValueChange = { searching = it },
            textStyle = TextStyle.Default.copy(fontSize = 20.sp),
            placeholder = { Text("Search", fontSize = 20.sp) },
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search Icon",
                        tint = Color.Black,
                        modifier = Modifier
                            .size(40.dp)
                            .padding(start = 10.dp)
                    )
                }
            },
            trailingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Close Icon",
                        tint = Color.Black,
                        modifier = Modifier
                            .size(40.dp)
                            .padding(end = 10.dp)
                    )
                }
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Uranian_Blue,
                unfocusedContainerColor = Uranian_Blue,
                unfocusedIndicatorColor = Uranian_Blue,
                focusedIndicatorColor = Uranian_Blue
            ),
            shape = RectangleShape,
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
}

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
    LazyColumn {
        item {
            pricingPalBar()
        }
        stickyHeader {
            volunteerCompanySearchBar()
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