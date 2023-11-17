package com.example.pricingpal.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pricingpal.R
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
            painter = painterResource(id = R.drawable.paw_background),
            contentDescription = "Pictures of paws",
            //crops the image
            contentScale = ContentScale.Crop,
            // changes the opacity of the image
            alpha = 0.1F
        )
        loadingTimer()
    }
}

/** This is to show the loading bar on the screen. The number on the bar will increase up until it
 * gets to 100%. I do not have it set up where it can do that. I was looking a youtube tutorial trying
 * to see which launch effect would work for this. Plus I got really busy with the UI, I didn't get to
 * finish the video.
 *
 * I assume we will need a sleep and thread for it, I am not sure.
 *
 *Base on our figma we have 3 loading screens. One when we launch the app, and the other 2 when it is
 * loading up the category list. I have 3 because they will navigate to 3 different screens.*/
@Composable
fun loadingTimer(){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
            Image(
                painter = painterResource(id = R.drawable.app_icon7),
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
                .padding(start = 40.dp, top = 20.dp, end = 40.dp)
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


