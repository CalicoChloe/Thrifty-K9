package com.example.pricingpal.view.homepage.volunteer

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pricingpal.R
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Persian_indigo
import com.example.pricingpal.view.repetitivefunctions.arrowNavigationBar
import com.example.pricingpal.view.repetitivefunctions.pricingPalBar
import com.example.pricingpal.view.repetitivefunctions.searchBar

@Composable
fun volunteerCategory(){
    Card(
        shape = RectangleShape,
        modifier = Modifier
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
                //.padding(15.dp)
        )
        {
            Image(
                painter = painterResource(id =R.drawable.rectangle_22),
                contentDescription = "Accessories image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                contentScale = ContentScale.Crop,
                alpha = 0.8F
            )

            Row(modifier = Modifier
                .border(4.dp, color = Persian_indigo)
                .fillMaxWidth()
                .height(60.dp)
                .background(color = Cornflower_blue, shape = RectangleShape),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    //shows the name of the category
                    text = "Category",
                    fontSize = 30.sp,
                    // have it in bold to make it stand out
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                )

            }
        }
    }
}

@Composable
fun volunteerHome(){
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
            text = "Home",
            fontSize = 30.sp,
            color = Color.Black,
        )

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun volunteerCategoryList(){
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
        for(i in 1..2) {
            item {
                volunteerCategory()
            }
        }
        item{
            volunteerHome()
        }
    }
}