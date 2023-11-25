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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pricingpal.PricingPalAppBar
import com.example.pricingpal.model.Category
import com.example.pricingpal.model.Item
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo


@Composable
fun ItemList(
    selectedCategory: String?,
    padding: PaddingValues,
    categories: HashMap<String, Category>,
    navigateUp: Boolean,
    canNavigateBack: Boolean,
    currentScreen: String
) {
    Scaffold(
        //Create an app bar of medium size at the top of the scaffold
        topBar = {
            PricingPalAppBar(
                navigateUp = { navigateUp },
                canNavigateBack = canNavigateBack,
                currentScreen = currentScreen
            )
        },
        content = { padding ->
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
        })
}


@Composable
fun CategoryCard(categoryName: Category) {
    Card(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
            .height(80.dp)
            .border(
                // puts a border around the card
                border = BorderStroke(3.dp, color = Persian_indigo),
                // shapes the card
                shape = RectangleShape
            ),

        elevation = CardDefaults.cardElevation(8.dp),
        // shape = RoundedCornerShape(16.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(color = Cornflower_blue, shape = RectangleShape)
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
                border = BorderStroke(3.dp, color = Persian_indigo),
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
