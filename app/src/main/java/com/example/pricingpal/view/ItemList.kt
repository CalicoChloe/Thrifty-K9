package com.example.pricingpal.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo

@OptIn(ExperimentalFoundationApi::class)
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
                    .padding(top = 54.dp)
            ) {
                item{
                    CategoryTitle(currentCategory) // Shows the name of the category
                }
                for(item in currentCategory.item) {
                    item {
                        ViewItems(item) // shows list of items
                    }
                }
            }  }
            }
        }

@Composable
fun CategoryTitle(c: Category){
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
                text = c.category, // name of category for when it is being viewed in item-list
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
        }
    }
}

@Composable
fun ViewItems(item: Item){
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
                text = item.itemName,
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

