package com.example.pricingpal.view.repetitivefunctions

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pricingpal.R
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo

@Composable
fun viewCategory(){
    Card(
        shape = RectangleShape,
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp)
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
        )
        {
            Image(
                painter = painterResource(id = R.drawable.rectangle_22), // will display the image the that was uploaded
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
                    text = "Category", // name of category
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                )

            }
        }
    }
}

@Composable
fun categoryTitle(){
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
                text = "Category Name", // name of category for when it is being viewed in item-list
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
        }
    }
}

@Composable
fun viewItems(){
    Card(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp)
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
                text = "Items",
                fontSize = 30.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .align(alignment = Alignment.CenterVertically)
            )

            Text(
                text = "Price",
                fontSize = 30.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(end = 20.dp)
                    .align(alignment = Alignment.CenterVertically)
            )

        }
    }
}