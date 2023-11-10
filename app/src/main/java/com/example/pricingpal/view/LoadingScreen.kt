package com.example.pricingpal.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pricingpal.R
import com.example.pricingpal.ui.theme.Anti_flash_white
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo
import com.example.pricingpal.ui.theme.Uranian_Blue

@Composable
fun Loading(){
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Periwinkle
    ) {
        Image(
            //Imports image from resource folder
            painter = painterResource(id = R.drawable.paw_background),
            //description of the image for accessibility
            contentDescription = "Pictures of paws",
            //crops the image
            contentScale = ContentScale.Crop,
            // changes the opacity of the image
            alpha = 0.1F
        )
        loadingTimer()
    }
}

@Composable
fun loadingTimer(){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
            Image(
                //Imports image from resource folder
                painter = painterResource(id = R.drawable.app_icon7),
                //description of the image for accessibility
                contentDescription = "Pictures of paws",
                modifier = Modifier
                    .width(320.dp)
                    .height(317.dp)
                    .shadow(elevation = 12.dp, RoundedCornerShape(55.dp)),
            )

        Text(
            text = "Pricing Pals",
            textAlign = TextAlign.Center,
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 20.dp)
        )

        Card(
            modifier = Modifier
                .padding(start = 50.dp, top = 20.dp, end = 50.dp)
                .border(4.dp, color = Persian_indigo)
                .fillMaxWidth()
                .height(75.dp),
            shape = RectangleShape,
            elevation = CardDefaults.cardElevation(8.dp),
            colors = CardDefaults.cardColors(containerColor = Uranian_Blue)
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ){
                Text(
                    text = "Loading....",
                    textAlign = TextAlign.Start,
                    fontSize = 40.sp,
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .align(alignment = Alignment.CenterVertically)
                )

                Text(
                    text = "0 %",
                    textAlign = TextAlign.End,
                    fontSize = 40.sp,
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .align(alignment = Alignment.CenterVertically)
                )

            }
        }
    }

}


