package com.example.pricingpal.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pricingpal.R
import com.example.pricingpal.ui.theme.Anti_flash_white
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo
import com.example.pricingpal.ui.theme.Uranian_Blue

/**
 * This file will allow the user to see a list of all of the organizations that are registered.
 * On the back end, the list should be shown from the database.
 * They can only select one organization. Once clicked, a loading screen will appear which will then
 * load the registration for the guest.
 */

/**
 * Function: Guest Company List Header
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function sets up a scaffold with top bar for the login screen.
 * Users will see a display of the back arrow that will allow the user to navigate back to the Home screen.
 * Below the bar will show the rest of the content of the guess company list screen.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GuestCompanyListHeader(windowSize: WindowSize){
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Anti_flash_white
    ) {
        Scaffold(
            // creates the top app bar for the back arrow navigation
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Cornflower_blue,
                    ),
                    title = {
                        Text(text = "")
                    },
                    navigationIcon = {
                        IconButton(onClick = { /*TODO*/ },
                        ) {
                            Icon(imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back arrow Button",
                                tint = Color.Black,
                                modifier = Modifier
                                    .size(50.dp)
                            )

                        }
                    },
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
                guessCompanyDivider(padding, windowSize)
            },
        )
    }
}

/**
 * Function: Guess Company Divider
 * @author: Shianne Lesure
 *
 * @param paddingValues aligns the content with top app bar
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function allows for the scaffold and the rest of the content to be separated by a divider.
 * This was done to match more of the figma prototype.
 */
@Composable
fun guessCompanyDivider(paddingValues: PaddingValues, windowSize: WindowSize){
    Box(
        modifier = Modifier
            .padding(paddingValues)
            .height(height = 4.dp)
            .fillMaxWidth()
            .background(color = Persian_indigo)
    )
    guestCompanyList(paddingValues,windowSize)
}

/**
 * Function: Guest Company List
 * @author: Shianne Lesure
 *
 * @param paddingValues aligns the content with top app bar
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * 
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun guestCompanyList(paddingValues: PaddingValues,windowSize: WindowSize){
    LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                // this is here so the line above the pricing pal logo
                .padding(top = 4.dp)
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
                // This will allow for you to look up the company's name if the list became too long
                searchBarCompany(windowSize)
                Divider(thickness = 4.dp, color = Persian_indigo)
            }
            item {
                companiesTitle()
            }
            item {
                favorites()
            }

            for (i in 1..10) { // this will change when it is being pulled from the database
                item {
                    companyName()
                }
            }
        }
}

/**
 * Function: Companies Title
 * @author: Shianne Lesure
 *
 * This function will display the title Organizations and the instructions to the user.
 * Below the title card will show the list of organization that have been added by the owner.
 */
@Composable
fun companiesTitle(){
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
                text = "Organizations",
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )

            Text(
                text = "Select only one organization",
                fontSize = 30.sp,
                color = Color.Black,
            )
        }
    }
}

/**
 * Function: Company Name
 * @author: Shianne Lesure
 *
 * This function will show the name of the companies.
 * A company should be added when the owner register their organization.
 */
@Composable
fun companyName(){
    // The card needs to be clickable
    // Only one card can be clicked at a time
    // This will navigate to the Guest Registration Screen
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
                text = "Organization Name", // Will show up from database when Owner makes registration
                fontSize = 30.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .align(alignment = Alignment.CenterVertically)
            )

            IconButton(onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(60.dp)
                    .padding(end = 20.dp),
            ) {
                Icon(imageVector = Icons.Filled.FavoriteBorder,
                    contentDescription = "Back arrow Button",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(60.dp)
                )

            }
        }
    }
}

/**
 * Function: Favorites
 * @author: Shianne Lesure
 *
 * This function will display the title favorites to the user. Below the title card will show the list
 * of organization that have been favorite by the user.
 */
@Composable
fun favorites(){
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
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(color = Cornflower_blue, shape = RectangleShape)
                .fillMaxWidth()
                .height(110.dp)
        )
        {
            Text(
                text = "Favorites",
                fontSize = 50.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .align(alignment = Alignment.CenterVertically)
            )

            IconButton(onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(60.dp)
                    .padding(top = 10.dp, start = 20.dp),
            ) {
                Icon(imageVector = Icons.Filled.Favorite,
                    contentDescription = "Closed Heart",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(60.dp)
                )

            }
        }
    }
}

/**
 * Function: Search Bar Company
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function will display a search bar that the user can use to search up an organization.
 *
 * NOTE: I tried to make a top bar that was collapsable, but it wasn't working on my end so I
 * did this instead to get the same effect. The search bar is within a sticky header will allow for the search
 * bar to still show when scrolling down.
 */
@Composable
fun searchBarCompany(windowSize: WindowSize){
    // will scale the height of the search bar text field
    val searchHeight by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 50 else 60) }
    // will scale the width of the search bar text field
    val searchPaddingWidth by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 25 else 50) }
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 16 else 20) }
    // will scale the height of space between elements
    val spacerHeight by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 10 else 20) }
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(containerColor = Cornflower_blue)
    ){
        Spacer(modifier = Modifier.height(spacerHeight.dp))
        var searching by remember { mutableStateOf("") }
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(searchHeight.dp)
                .padding(start = searchPaddingWidth.dp, end = searchPaddingWidth.dp),
            value = searching,
            onValueChange = { searching = it }, // will take what the user is typing

            textStyle = TextStyle.Default.copy(fontSize = textSize.sp),
            placeholder = { Text("Search", fontSize = textSize.sp) },
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

        Spacer(modifier = Modifier.height(spacerHeight.dp))
    }
}


