package com.example.pricingpal.view.editinglist.makelist

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo
import com.example.pricingpal.view.repetitivefunctions.pricingPalBar
import com.example.pricingpal.view.repetitivefunctions.settingNavigationBar

@Composable
fun editCategoryTitle(){
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
                text = "Category Name",
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
        }
    }
}

@Composable
fun editItemCard(){
    Card(
        modifier = Modifier
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
                text = "Items",
                fontSize = 30.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .align(alignment = Alignment.CenterVertically)
            )

            Text(
                text = "Price",
                fontSize = 30.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(end = 20.dp)
                    .align(alignment = Alignment.CenterVertically)
            )

        }
    }
}

/** Upload Button
 * will navigate to the Edit List Screen
 * will upload to the item list*/
@Composable
fun uploadItemListButton(){
    ElevatedButton(
        onClick = { /*TODO*/ },
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(Cornflower_blue),
        elevation = ButtonDefaults.buttonElevation(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(start = 50.dp, top = 15.dp, end = 50.dp, bottom = 15.dp)
            .border(4.dp, color = Persian_indigo),

        ) {
        Text(
            textAlign = TextAlign.Center,
            text = "Upload Item List",
            fontSize = 40.sp,
            color = Color.Black,
        )
    }
}

@Composable
fun itemAddAndTrashButton(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(200.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        //Add Circle Button
        // Will navigate to the Add Item Screen
        ElevatedButton(
            onClick = { /*TODO*/ },
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(Cornflower_blue),
            elevation = ButtonDefaults.buttonElevation(8.dp),
            modifier = Modifier
                .size(140.dp)
                .border(4.dp, color = Persian_indigo),

            ) {
            Icon(
                imageVector = Icons.Filled.AddCircle,
                contentDescription = "Add Icon",
                tint = Color.Black,
                modifier = Modifier
                    .size(140.dp)
            )
        }

        //Delete Button
        // Will delete the entire item list
        ElevatedButton(
            onClick = { /*TODO*/ },
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(Cornflower_blue),
            elevation = ButtonDefaults.buttonElevation(8.dp),
            modifier = Modifier
                .size(140.dp)
                .border(4.dp, color = Persian_indigo),

            ) {
            Icon(
                imageVector = Icons.Filled.Delete,
                contentDescription = "Delete Icon",
                tint = Color.Black,
                modifier = Modifier
                    .size(140.dp)
            )
        }
    }
}

@Composable
fun viewEditItemList(){
    // holds the back arrow and setting's navigation's
    // will navigate back to Edit List Screen
    settingNavigationBar()
    LazyColumn(
        modifier = Modifier
            .padding(top = 54.dp)
    ) {
        item {
            pricingPalBar()
            Divider(thickness = 4.dp, color = Persian_indigo)
            Spacer(modifier = Modifier.height(20.dp))
        }
        /** I remove the search bar because I didn't think it was necessary when it comes to editing*/
        /*
        stickyHeader {
            searchBar()
            Divider(thickness = 4.dp, color = Persian_indigo)
        }

         */
        item{
            editCategoryTitle()
        }
        for(i in 1..2) {
            item {
                editItemCard() // will show the item
            }
        }
        item{
            itemAddAndTrashButton() // for you to add or delete items
        }
        item {
            uploadItemListButton() // will upload the item list to the category
        }
    }
}