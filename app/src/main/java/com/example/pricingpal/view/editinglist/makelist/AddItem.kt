package com.example.pricingpal.view.editinglist.makelist

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pricingpal.ui.theme.Anti_flash_white
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo
import com.example.pricingpal.ui.theme.Uranian_Blue
import com.example.pricingpal.view.repetitivefunctions.settingNavigationBar

@Composable
fun addItems(){
    Card(
        modifier = Modifier
            .padding(start = 40.dp, end = 40.dp)
            .safeContentPadding()
            .fillMaxSize()
            .border(4.dp, color = Persian_indigo),
        shape = RectangleShape,
        elevation = CardDefaults.cardElevation(12.dp),
        colors = CardDefaults.cardColors(containerColor = Periwinkle),

        ) {
        // Holds the navigation of the back arrow
        // Navigates to the Edit Item List Screen
        settingNavigationBar()
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())// allows for the items in the column to scroll
                .padding(top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                textAlign = TextAlign.Center,
                text = "Category Item",
                fontSize = 60.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(30.dp))
            itemInput()// the text-field for item Name
            Spacer(modifier = Modifier.height(15.dp))
            priceInput()// the text-field for price
            Spacer(modifier = Modifier.height(25.dp))
            addItemButton() // will add the item name and price to the list below
            Spacer(modifier = Modifier.height(25.dp))
            for(i in 1..2) {
                itemName()// will show the item name and price
            }
            Spacer(modifier = Modifier.height(30.dp))
            uploadItemButton()// will upload the list of items to the edit item list Screen
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}

@Composable
fun itemInput(){
    var itemInput by remember { mutableStateOf("") }// variable that holds a default state of text-field
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 30.dp, end = 30.dp),
        value = itemInput,
        onValueChange = {itemInput = it},// will take in the input from the user
        textStyle = TextStyle.Default.copy(fontSize = 20.sp) ,
        placeholder = { Text("Enter item", fontSize = 20.sp) },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Anti_flash_white,
            unfocusedContainerColor = Anti_flash_white,
            unfocusedIndicatorColor = Anti_flash_white,
            focusedIndicatorColor = Persian_indigo
        ),
        shape = RectangleShape,
    )
    /** I did this in replacement of the supporting text*/
    // This message is below the text-field
    // The message can change if their input is wrong
    Row(horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, start = 50.dp)
    ) {
        Text(
            text = "*required",
            fontSize = 20.sp,
            color = Color.DarkGray
        )
    }
}

@Composable
fun priceInput(){
    var priceInput by remember { mutableStateOf("") }// variable that holds a default state of text-field
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 30.dp, end = 30.dp),
        value = priceInput,
        onValueChange = {priceInput = it},// will take in the input from the user
        textStyle = TextStyle.Default.copy(fontSize = 20.sp) ,
        placeholder = { Text("Enter price", fontSize = 20.sp) },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Anti_flash_white,
            unfocusedContainerColor = Anti_flash_white,
            unfocusedIndicatorColor = Anti_flash_white,
            focusedIndicatorColor = Persian_indigo
        ),
        shape = RectangleShape,
    )
    /** I did this in replacement of the supporting text*/
    // This message is below the text-field
    // The message can change if their input is wrong
    Row(horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, start = 50.dp)
    ) {
        Text(
            text = "*required",
            fontSize = 20.sp,
            color = Color.DarkGray
        )
    }
}

@Composable
fun itemName(){
    Card(
        modifier = Modifier
            .padding(15.dp)
            .padding(start = 30.dp, end = 30.dp)
            .border(
                border = BorderStroke(4.dp, color = Persian_indigo),
                shape = RectangleShape
            ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .background(color = Uranian_Blue, shape = RectangleShape)
                .fillMaxWidth()
                .height(100.dp)
        )
        {
            Column() {
                Text(
                    text = "Item Name",
                    fontSize = 30.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 20.dp)
                )

                Text(
                    text = "Price",
                    fontSize = 30.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 20.dp)
                )
            }

            //Delete Button
            // Will allow for you to remove the item file
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "Delete Icon",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(50.dp)
                        .padding(end = 10.dp)
                )
            }

        }
    }
}

@Composable
fun addItemButton(){
    //Add item Button
    // will load the item card below the button
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
            text = "Add Item",
            fontSize = 40.sp,
            color = Color.Black,
        )
    }
}

@Composable
fun uploadItemButton(){
    //Upload Item Button
    // will navigate back to Edit Item list Screen
    // will upload the items
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
            text = "Upload Items",
            fontSize = 40.sp,
            color = Color.Black,
        )
    }
}