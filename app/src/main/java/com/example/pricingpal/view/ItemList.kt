package com.example.pricingpal.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pricingpal.model.Category
import com.example.pricingpal.model.Item


@Composable
fun ItemList(
    selectedCategory: String?,
    padding: PaddingValues,
    categories: HashMap<String, Category>
) {
    //When the selectedCategory is received, it needs to not be null to avoid causing problems. Same with the currentCategory.
    if (selectedCategory != null) {
        val currentCategory = categories.get(selectedCategory)
        if (currentCategory != null) {
            //Everything above this line should not be touched! It's required to make sure the current category isn't null before attempting to use the value!
            //Everything below these comments is temporary code to display the item list. Please replace with the final UI design:
            //stickyHeader { CategoryCard(categoryName = currentCategory)}
            //ListHeader(name = currentCategory.category)
            LazyColumn(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                item {
                    //Text(text = currentCategory.category, fontSize = 70.sp)
                    CategoryCard(categoryName = currentCategory)
                }
                item {
                    for (i in currentCategory.item) {
                        ItemCard(i)
                    }
                }
            }
        }
    }
}

/*@Composable
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


}*/

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
                //shows the name of the category
                text = categoryName.category,
                fontSize = 40.sp,
                // have it in bold to make it stand out
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .align(alignment = Alignment.CenterVertically)
            )
        }
    }
}
@Composable
fun ItemCard(item: Item) {
    Card(
        modifier = Modifier
            // padding around the card
            .padding(15.dp)
            .border(
                // puts a border around the card
                border = BorderStroke(3.dp, Color(0xFF22577A)),
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
                .background(color = Color(0xFFAEB8FE), shape = RectangleShape)
                // changes the size of the card
                .fillMaxWidth()
                .height(80.dp)
        )
        {
            Text(
                text = item.name,
                fontSize = 30.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .align(alignment = Alignment.CenterVertically)
            )

            Text(
                text = "$" + item.price + "0",
                fontSize = 30.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(end = 20.dp)
                    .align(alignment = Alignment.CenterVertically)
            )
        }
    }
}
