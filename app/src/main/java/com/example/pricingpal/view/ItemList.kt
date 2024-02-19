package com.example.pricingpal.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pricingpal.PricingPalAppBar
import com.example.pricingpal.R
import com.example.pricingpal.model.Category
import com.example.pricingpal.model.Item
import com.example.pricingpal.ui.theme.Anti_flash_white
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ItemList(
    selectedCategory: String?,
    categories: HashMap<String, Category>,
    navController: NavController,
    windowSize: WindowSize
) {
    Scaffold(
        //Create an app bar of medium size at the top of the scaffold
        topBar = {
            PricingPalAppBar(
                navigateUp = { navController.navigateUp() },
                canNavigateBack = navController.previousBackStackEntry != null
            )
        },
        content = { padding ->
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

            /*
            This function allows for the scaffold and the rest of the content to be separated by a divider.
            This was done to match more of the figma prototype.
             */
            Box(
                modifier = Modifier
                    .padding(padding)
                    .height(height = 4.dp)
                    .fillMaxWidth()
                    .background(color = Persian_indigo)
            )
            //When the selectedCategory is received,
            // it needs to not be null to avoid causing problems. Same with the currentCategory.
            if (selectedCategory != null) {
                val currentCategory = categories.get(selectedCategory)

                if (currentCategory != null) {
                    //Everything above this line should not be touched!
                    // It's required to make sure the current category isn't null before attempting to use the value!
                    LazyColumn(
                        modifier = Modifier
                            .padding(padding)
                            .padding(top = 4.dp)
                            .fillMaxSize()
                    ) {
                        item {
                            // holds the pricing pal logo
                            // This will collapse when scrolling up
                            pricingPalBar()
                        }
                        stickyHeader {
                            // This will allow for you to look up the items and categories
                            searchBar(windowSize = windowSize)
                            Divider(thickness = 4.dp, color = Persian_indigo)
                        }
                        item {
                            //Text(text = currentCategory.category, fontSize = 70.sp)
                            CategoryCard(categoryName = currentCategory)
                        }
                        item {
                            for (i in currentCategory.item) {
                                ItemCard(i, windowSize = windowSize)
                            }
                        }
                    }
                }
            }
        },
//Background color for the content
        containerColor = Anti_flash_white
    )
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
fun ItemCard(item: Item, windowSize: WindowSize) {
    // will scale the height of the row
    val rowHeight by remember(key1 = windowSize) { mutableStateOf(if (windowSize.width == WindowType.Compact) 70 else 80) }
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if (windowSize.width == WindowType.Compact) 25 else 30) }
    // will scale the padding around the card
    val cardPadding by remember(key1 = windowSize) { mutableStateOf(if (windowSize.width == WindowType.Compact) 10 else 15) }
    Card(
        modifier = Modifier
            // padding around the card
            .padding(cardPadding.dp)
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
                .height(rowHeight.dp)
        )
        {
            Text(
                text = item.name,
                fontSize = textSize.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .align(alignment = Alignment.CenterVertically)
            )

            Text(
                text = "$" + item.price + "0",
                fontSize = textSize.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(end = 20.dp)
                    .align(alignment = Alignment.CenterVertically)
            )
        }
    }
}


//You may encounter many defeats, but you must not be defeated.
// In fact, it may be necessary to encounter the defeats so you can know who you are,
// what you can rise from, how you can still come out of it (Maya Angelou) -Julian Ellis