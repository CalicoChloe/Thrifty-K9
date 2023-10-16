package com.example.pricingpal.ui.theme

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pricingpal.R
import com.example.pricingpal.model.Category
import com.example.pricingpal.model.Item

@Composable
fun ListHeader( name: String){
    Column() {
        Row(
            modifier = Modifier
                // wraps completely around the text
                .wrapContentSize(Alignment.TopCenter, false)
                //fills it to hit the edge of the device
                .fillMaxWidth()
                .height(80.dp)
                .background(color = Color(0xFF758BFD), shape = RectangleShape)
        ) {

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 10.dp, start = 15.dp)
                    .width(200.dp)
                    .height(60.dp)
                //.requiredSize(60.dp),

            )

            Surface(
                shape = RectangleShape,
                color = Color(0xFFAEB8FE),
                //shadowElevation = 12.dp,
                modifier = Modifier
                    // wraps completely around the text
                    .wrapContentSize(Alignment.TopCenter, false)
                    //fills it to hit the edge of the device
                    .size(width = 490.dp, height = 70.dp)
                    .padding(top = 20.dp, bottom = 10.dp, start = 15.dp, end = 10.dp)
                // .fillMaxWidth()
            ) {
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


}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ItemList (itemList: List<Item>,categoryList: ArrayList<Category>) {
    Column(modifier = Modifier
        .padding(top = 80.dp)
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                //.padding(top = 175.dp)
            //.padding(20.dp)
        ) {
            /** This is the other code just encase the one below doesn't work. **/
            /*
            for (category: Category in categoryList) {
                CategoryCard(categoryName = category)
            }
            for (item: Item in itemList) {
                    item { ItemCard(itemView = item) }
                }

             */

            for (category: Category in categoryList) {
                stickyHeader { CategoryCard(categoryName = category)}
                for (item: Item in itemList) {
                    if(item.category.contains(category.category, ignoreCase = true)) {
                        item { ItemCard(itemView = item) }
                    }
                }
            }
        }
    }

}

@Composable
fun CategoryCard(categoryName: Category) {
    Card(modifier = Modifier
        .padding(15.dp)
        .fillMaxWidth()
        .height(80.dp)
        .border(
            // puts a border around the card
            border = BorderStroke(3.dp, Color(0xFF27187E)),
            // shapes the card
            shape = RectangleShape
        ),

        elevation = CardDefaults.cardElevation(8.dp),
        // shape = RoundedCornerShape(16.dp)
    ) {

        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(color = Color(0xFF758BFD), shape = RectangleShape)
                .fillMaxWidth()
                .height(80.dp)
        )
        {

            Text(
                text = categoryName.category,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .align(alignment = Alignment.CenterVertically)
            )
        }
    }
}

@Composable
fun ItemCard(itemView: Item) {
    Card(
        modifier = Modifier
            .padding(15.dp)
            .border(
                // puts a border around the card
                border = BorderStroke(3.dp, Color(0xFF27187E)),
                // shapes the card
                shape = RectangleShape
            ),
        elevation = CardDefaults.cardElevation(8.dp),
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .background(color = Color(0xFFAEB8FE), shape = RectangleShape)
                .fillMaxWidth()
                .height(80.dp)
        )
        {
            Text(
                text = itemView.name,
                fontSize = 30.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .align(alignment = Alignment.CenterVertically)
            )

            Text(
                text = itemView.price.toString(),
                fontSize = 30.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(end = 20.dp)
                    .align(alignment = Alignment.CenterVertically)
            )

        }
    }
}

