package com.example.pricingpal.view.repetitivefunctions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pricingpal.R
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Persian_indigo
import com.example.pricingpal.ui.theme.Uranian_Blue

/** displays the pricing pal logo*/
@Composable
fun pricingPalBar(){
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(containerColor = Cornflower_blue)
    ){
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Cornflower_blue),
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Pictures of paws",
                modifier = Modifier
                    .padding(top = 5.dp, start = 25.dp, end = 25.dp)
            )
        }
    }
}

/** will display a header that shows the setting icon along with a name*/
@Composable
fun settingsBar(){
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(containerColor = Cornflower_blue)
    ){
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 20.dp)
                .background(color = Cornflower_blue),
        ) {
            Icon(
                imageVector = Icons.Filled.Settings,
                contentDescription = "Setting Icon",
                tint = Color.Black,
                modifier = Modifier
                    .size(50.dp)
                    .padding(start = 10.dp, top = 5.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                textAlign = TextAlign.Center,
                text = "Settings",
                fontSize = 40.sp,
                color = Color.Black,
            )
        }
    }
    Box(
        modifier = Modifier
            .height(height = 4.dp)
            .fillMaxWidth()
            .background(color = Persian_indigo)
    )
}

/** I decided to make 2 different search bar because They are searching up to different things.
 * This search bar should only show the items and categories*/
@Composable
fun searchBar(){
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(containerColor = Cornflower_blue)
    ){
        Spacer(modifier = Modifier.height(20.dp))
        var searching by remember { mutableStateOf("") }
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(start = 50.dp, end = 50.dp),
            value = searching,
            onValueChange = { searching = it },
            textStyle = TextStyle.Default.copy(fontSize = 20.sp),
            placeholder = { Text("Search", fontSize = 20.sp) },
            leadingIcon = {
                // Search Icon Button
                // Will navigate to what ever was searched.
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search Icon",
                        tint = Color.Black,
                        modifier = Modifier
                            .size(40.dp)
                            .padding(start = 10.dp)
                    )
                }
            },
            trailingIcon = {
                // Close Icon Button
                //will exit out the search bar
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Close Icon",
                        tint = Color.Black,
                        modifier = Modifier
                            .size(40.dp)
                            .padding(end = 10.dp)
                    )
                }
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Uranian_Blue,
                unfocusedContainerColor = Uranian_Blue,
                unfocusedIndicatorColor = Uranian_Blue,
                focusedIndicatorColor = Uranian_Blue
            ),
            shape = RectangleShape,
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
}

/** I decided to make 2 different search bar because They are searching up to different things.
 * This search bar should only show the companies */
@Composable
fun companySearchBar(){
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(containerColor = Cornflower_blue)
    ){
        Spacer(modifier = Modifier.height(20.dp))
        var searching by remember { mutableStateOf("") }
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(start = 50.dp, end = 50.dp),
            value = searching,
            onValueChange = { searching = it },
            textStyle = TextStyle.Default.copy(fontSize = 20.sp),
            placeholder = { Text("Search", fontSize = 20.sp) },
            leadingIcon = {
                // Search Icon Button
                // Will navigate to what ever was searched.
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search Icon",
                        tint = Color.Black,
                        modifier = Modifier
                            .size(40.dp)
                            .padding(start = 10.dp)
                    )
                }
            },
            trailingIcon = {
                // Close Icon Button
                //will exit out the search bar
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Close Icon",
                        tint = Color.Black,
                        modifier = Modifier
                            .size(40.dp)
                            .padding(end = 10.dp)
                    )
                }
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Uranian_Blue,
                unfocusedContainerColor = Uranian_Blue,
                unfocusedIndicatorColor = Uranian_Blue,
                focusedIndicatorColor = Uranian_Blue
            ),
            shape = RectangleShape,
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun arrowNavigationBar() {

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(Color.Transparent),
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(color = Cornflower_blue),
        ) {
            //Back Arrow Button
            //will take you back to the previous page
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back arrow Icon",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(start = 10.dp, top = 5.dp)
                )
            }
        }
        Box(
            modifier = Modifier
                .height(height = 4.dp)
                .fillMaxWidth()
                .background(color = Persian_indigo)
        )
    }
}

@Composable
fun settingNavigationBar() {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(Color.Transparent),
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(color = Cornflower_blue),
        ) {
            //Back Arrow Button
            //will take you back to the previous page
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back Arrow Icon",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(start = 10.dp, top = 5.dp)
                )
            }

            //Setting Button
            // will take you straight to the settings page
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "Settings Icon",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(end = 10.dp, top = 5.dp)
                )
            }
        }
        Box(
            modifier = Modifier
                .height(height = 4.dp)
                .fillMaxWidth()
                .background(color = Persian_indigo)
        )
    }
}


/** Another version of showing the pricing pal logo*/
@Composable
fun innerPricingBar(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(color = Cornflower_blue, shape = RectangleShape),
        horizontalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier
                .padding(15.dp)
        )
    }
    Box(
        modifier = Modifier
            .height(height = 4.dp)
            .fillMaxWidth()
            .background(color = Persian_indigo)
    )
}