package com.example.pricingpal.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
            LazyColumn(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                item {
                    Text(text = currentCategory.category, fontSize = 70.sp)
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

//Copy and pasted from the CategoryList.kt file. Please replace with final UI design:
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
        // Allows for the text to be put on top of the card
        Box(modifier = Modifier
            // the size of the box
            .width(700.dp)
            .height(200.dp)
            // changes the color of the box
            .background(Color(0xFF38A3A5)),
            //allows for the content to be put into the center of the box
            contentAlignment = Alignment.Center,
        ){
            Text(
                // takes the text from the category variable
                text = item.name,
                // changes the size of the font
                fontSize = 70.sp,
                // allows for the font to be in bold
                fontWeight = FontWeight.Bold,
                lineHeight = 116.sp,
                //change the color of the text
                color = Color.Black,
                modifier = Modifier
                    .padding(50.dp)
            )
        }
    }
}