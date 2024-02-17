package com.example.pricingpal.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.pricingpal.R
import com.example.pricingpal.ui.theme.Anti_flash_white
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo
import com.example.pricingpal.ui.theme.Uranian_Blue

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
 * This function sets up the rest of the content of the guess company list screen.
 * Users will see a display of organization that they can choose to sign up to. They will be able to
 * select organization to be their favorites as well as being able to search for a specific organization.
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
                /* I tried to make a top bar that was collapsable, but it wasn't working on my end so I
                 * did this instead to get the same effect. The sticky header will allow for the search
                 * bar to still show when scrolling down.
                 * */
                // This will allow for you to look up the company's name if the list became too long
                searchBarCompany(windowSize)
                Divider(thickness = 4.dp, color = Persian_indigo)
            }
            item {
                companiesTitle(windowSize)
            }
            item {
                favorites(windowSize)
            }
        for (i in 1..2) { // this will change when it is being pulled from the database
            item {
                favoriteCompanyName(windowSize)
            }
        }
            for (i in 1..10) { // this will change when it is being pulled from the database
                item {
                    companyName(windowSize)
                }
            }
        }
}

/**
 * Function: Companies Title
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function will display the title Organizations and the instructions to the user.
 * Below the title card will show the list of organization that have been added by the owner.
 */
@Composable
fun companiesTitle(windowSize: WindowSize){
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if (windowSize.width == WindowType.Compact) 45 else 60) }
    // will scale the size of the text
    val instructionTextSize by remember(key1 = windowSize) { mutableStateOf(if (windowSize.width == WindowType.Compact) 25 else 30) }
    // will scale the padding around the card
    val cardPadding by remember(key1 = windowSize) { mutableStateOf(if (windowSize.width == WindowType.Compact) 10 else 15) }

    Card(
        shape = RectangleShape,
        modifier = Modifier
            .padding(top = 15.dp)
            .padding(cardPadding.dp),
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
                fontSize = textSize.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )

            Text(
                text = "Select only one organization",
                fontSize = instructionTextSize.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
            )
        }
    }
}

/**
 * Function: Company Name
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function will show the name of the companies.
 * A company should be added when the owner register their organization.
 */
@Composable
fun companyName(windowSize: WindowSize){
    // will scale the height of the row
    val rowHeight by remember(key1 = windowSize) { mutableStateOf(if (windowSize.width == WindowType.Compact) 70 else 80) }
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if (windowSize.width == WindowType.Compact) 25 else 30) }
    // will scale the padding around the card
    val cardPadding by remember(key1 = windowSize) { mutableStateOf(if (windowSize.width == WindowType.Compact) 10 else 15) }

    /*
    Only one card can be clicked at a time
    This will navigate to the Guest Registration Screen
     */
    Card(
        modifier = Modifier
            .clickable { /*TODO*/ }
            .padding(cardPadding.dp)
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
                .height(rowHeight.dp)
        )
        {
            Text(
                text = "Organization Name", // Will show up from database when Owner makes registration
                fontSize = textSize.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .align(alignment = Alignment.CenterVertically)
            )

            cookiesAndPrivacy(windowSize)
        }
    }
}

/**
 * Function: Favorites
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function will display the title favorites to the user. Below the title card will show the list
 * of organization that have been favorite by the user.
 */
@Composable
fun favorites(windowSize: WindowSize){
    // will scale the height of the row
    val rowHeight by remember(key1 = windowSize) { mutableStateOf(if (windowSize.width == WindowType.Compact) 90 else 110) }
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if (windowSize.width == WindowType.Compact) 35 else 50) }
    // will scale the padding around the card
    val cardPadding by remember(key1 = windowSize) { mutableStateOf(if (windowSize.width == WindowType.Compact) 10 else 15) }
    // will scale the padding around the card
    val iconPadding by remember(key1 = windowSize) { mutableStateOf(if (windowSize.width == WindowType.Compact) 5 else 10) }

    Card(
        modifier = Modifier
            .padding(cardPadding.dp)
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
                .height(rowHeight.dp)
        )
        {
            Text(
                text = "Favorites",
                fontSize = textSize.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .align(alignment = Alignment.CenterVertically)
            )

            IconButton(onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(60.dp)
                    .padding(top = iconPadding.dp, start = 20.dp),
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
 * Function: Favorite Company Name
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function will show the name of the companies that the user add as favorites.
 * A company should be added when the owner register their organization.
 */
@Composable
fun favoriteCompanyName(windowSize: WindowSize){
    // will scale the height of the row
    val rowHeight by remember(key1 = windowSize) { mutableStateOf(if (windowSize.width == WindowType.Compact) 70 else 80) }
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if (windowSize.width == WindowType.Compact) 25 else 30) }
    // will scale the padding around the card
    val cardPadding by remember(key1 = windowSize) { mutableStateOf(if (windowSize.width == WindowType.Compact) 10 else 15) }

    /*
    Only one card can be clicked at a time
    This will navigate to the Guest Registration Screen
     */
    Card(
        modifier = Modifier
            .clickable { /*TODO*/ }
            .padding(cardPadding.dp)
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
                .height(rowHeight.dp)
        )
        {
            Text(
                text = "Organization Name", // Will show up from database when Owner makes registration
                fontSize = textSize.sp,
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
                Icon(imageVector = Icons.Filled.Favorite,
                    contentDescription = "Filled Heart",
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

/**
 * Function: Cookies And Privacy
 * @author: Shianne Lesure
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * This function will have a dialog pop up the moment the user try to make an organization a favorite.
 * If the user accepts the cookies the can save the organization.
 * If the user declines the cookies, the organization will not be save.
 */
@Composable
fun cookiesAndPrivacy(windowSize: WindowSize){
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 20 else 30) }

    /*
    This dialog will always pop up everytime the user wants to add an organization to a favorite.
    I am not sure how it can be done the one time.
     */
    var showDialog by remember { mutableStateOf(false) }
    IconButton(onClick = { showDialog = true },
        modifier = Modifier
            .size(60.dp)
            .padding(end = 20.dp),
    ) {
        Icon(imageVector = Icons.Filled.FavoriteBorder,
            contentDescription = "Outline Heart",
            tint = Color.Black,
            modifier = Modifier
                .size(60.dp)
        )

    }
    // the dialog shows if why button is clicked
    if (showDialog) {
        Dialog(onDismissRequest = {showDialog = false}) {

            //Hold makes up the dialog box
            Surface(
                shape = RectangleShape,
                color = Color.White,
                modifier = Modifier
                    .shadow(elevation = 8.dp, RectangleShape)
                    .border(2.dp, color = Color.Black),
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // Holds the message that will be shown in dialog
                    Text(text = "Cookies & Privacy",
                        fontSize = textSize.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                    )

                    // Holds the message that will be shown in dialog
                    Text(text = "This app uses cookies to ensure you get the best experience on our app.",
                        fontSize = textSize.sp,
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        /*
                        if the user clicks accept, the dialog will close and
                        then the user will be able to save the organizations
                         */
                        Button(
                            onClick = { showDialog = false },
                            shape = RectangleShape,
                            colors = ButtonDefaults.buttonColors(Cornflower_blue),
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .border(3.dp, color = Persian_indigo),
                        ) {
                            Text(
                                "Accept",
                                fontSize = textSize.sp,
                                color = Color.Black
                            )
                        }

                        /*
                        if the user clicks decline, the dialog will close and
                        then the user will not be able to save the organizations
                         */
                        Button(
                            onClick = { showDialog = false },
                            shape = RectangleShape,
                            colors = ButtonDefaults.buttonColors(Cornflower_blue),
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .border(3.dp, color = Persian_indigo),
                        ) {
                            Text(
                                "Decline",
                                fontSize = textSize.sp,
                                color = Color.Black
                            )
                        }
                    }
                }
            }
        }
    }
}
