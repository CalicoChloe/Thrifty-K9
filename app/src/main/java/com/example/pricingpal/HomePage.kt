package com.example.pricingpal

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pricingpal.model.Category

@Composable
fun Header( name: String){
    Row(
        modifier = Modifier
            // wraps completely around the text
            .wrapContentSize(Alignment.TopCenter, false)
            //fills it to hit the edge of the device
            .fillMaxWidth()
            .height(80.dp)
            .background(color = colorResource(id = R.color.sky_blue), shape = RectangleShape)) {

        Image(
            painter = painterResource(id = R.drawable.picture2),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 10.dp, start = 15.dp)
                .width(200.dp)
                .height(60.dp)
            //.requiredSize(60.dp),

        )

        Surface(
            shape = RectangleShape,
            color = colorResource(id = R.color.pale_blue),
            //shadowElevation = 12.dp,
            modifier = Modifier
                // wraps completely around the text
                .wrapContentSize(Alignment.TopCenter, false)
                //fills it to hit the edge of the device
                .size(width = 490.dp, height = 70.dp)
                .padding(top = 20.dp, bottom = 10.dp, start = 15.dp, end = 10.dp)
            // .fillMaxWidth()
        ){
            Text(
                text = name,
                textAlign = TextAlign.Start,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(top = 8.dp, start = 5.dp)
                //.background(Color(0xFF3ddc84))
            )
        }

        Image(
            painter = painterResource(id = R.drawable.icons8_search_128),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 17.dp)
                .requiredSize(50.dp),
        )
    }

}

@Composable
fun CategoryList (categories: ArrayList<Category>) {

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 80.dp)
        //.padding(20.dp)
    ) {
        for (category: Category in categories) {
            item { CategoryCard(category = category) }
        }
    }
}

@Composable
fun CategoryCard(category: Category) {
    Card(modifier = Modifier
        .padding(15.dp)
        //.background(Color(0xFF38A3A5))
        .fillMaxWidth()
        //.background(color = colorResource(id = R.color.pale_blue))
        .border(
            // puts a border around the card
            border = BorderStroke(4.dp, color = colorResource(id = R.color.deep_blue)),
            // shapes the card
            shape = RectangleShape
        ),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.pale_blue)
        )
        // shape = RoundedCornerShape(16.dp)
    ) {

        Column(modifier = Modifier
            .background(color = colorResource(id = R.color.pale_blue))
        ) {

        }
        /*
            Image(
                painter = painterResource(categories.imagesID),
                //bitmap = ImageBitmap.imageResource(id = categories.imagesID),
                contentDescription = null,
                modifier = Modifier
                    .width(700.dp)
                    .height(200.dp),
                //.clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop,
                alpha = 0.8F
            )

             */

        Text(
            text = category.category,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            // textAlign = TextAlign.Center,
            //lineHeight = 116.sp,
            // color is in hex decimal = 3ddc84
            color = Color.Black,
            modifier = Modifier
                .padding(10.dp)
                .align(alignment = Alignment.CenterHorizontally)
            //.align(alignment = Alignment.Center),
        )
    }
}


