package com.example.pricingpal.view.editinglist.makelist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Persian_indigo
import com.example.pricingpal.view.repetitivefunctions.arrowNavigationBar
import com.example.pricingpal.view.repetitivefunctions.pricingPalBar
import com.example.pricingpal.view.repetitivefunctions.searchBar
import com.example.pricingpal.view.repetitivefunctions.viewCategory

@Composable
fun editButton(){
    //Edit Button
// Will navigate back to the Edit List Screen
    ElevatedButton(
        onClick = { /*TODO*/ },
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(Cornflower_blue),
        elevation = ButtonDefaults.buttonElevation(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .padding(start = 70.dp, top = 15.dp, end = 70.dp, bottom = 15.dp)
            .border(4.dp, color = Persian_indigo),

        ) {
        Icon(
            imageVector = Icons.Filled.Edit,
            contentDescription = "Edit Icon",
            tint = Color.Black,
            modifier = Modifier
                .size(40.dp)
                .padding(end = 10.dp, top = 5.dp)
        )
        Spacer(modifier = Modifier.width(25.dp))
        Text(
            textAlign = TextAlign.Center,
            text = "Edit",
            fontSize = 30.sp,
            color = Color.Black,
        )

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun editCategoryList(){
    // Holds the navigation of the back arrow
    // Navigates to the Edit Loading Screen
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
        for(i in 1..4) {
            item {
                viewCategory() // Shows the name of the category
            }
        }
        item{
            editButton() // Shows list of categories
        }
    }
}