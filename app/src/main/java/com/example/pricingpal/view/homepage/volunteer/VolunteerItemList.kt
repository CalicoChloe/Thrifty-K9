package com.example.pricingpal.view.homepage.volunteer

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pricingpal.ui.theme.Persian_indigo
import com.example.pricingpal.view.repetitivefunctions.arrowNavigationBar
import com.example.pricingpal.view.repetitivefunctions.categoryTitle
import com.example.pricingpal.view.repetitivefunctions.pricingPalBar
import com.example.pricingpal.view.repetitivefunctions.searchBar
import com.example.pricingpal.view.repetitivefunctions.viewItems

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun volunteerItemList(){
    // Holds the navigation of the back arrow
    // Navigates to the volunteer category list  Screen
    arrowNavigationBar()
    LazyColumn(
        modifier = Modifier
            .padding(top = 54.dp)
    ) {
        item {
            // holds the pricing pal logo
            // This will collapse when scrolling up
            pricingPalBar()
        }
        stickyHeader {
            /** I tried to make a top bar that was collapsable, but it wasn't working on my end so I
             * did this instead to get the same effect. The sticky header will allow for the search
             * bar to still show when scrolling down.*/
            // This will allow for you to look up the items and categories
            searchBar()
            Divider(thickness = 4.dp, color = Persian_indigo)
        }
        item{
            categoryTitle() // Shows the name of the category
        }
        for(i in 1..10) {
            item {
                viewItems() // shows list of items
            }
        }
    }
}