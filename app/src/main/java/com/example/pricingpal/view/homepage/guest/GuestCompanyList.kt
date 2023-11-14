package com.example.pricingpal.view.homepage.guest

import android.provider.ContactsContract.CommonDataKinds.Organization
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pricingpal.R
import com.example.pricingpal.ui.theme.Anti_flash_white
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo
import com.example.pricingpal.ui.theme.Pink80
import com.example.pricingpal.ui.theme.Uranian_Blue
import com.example.pricingpal.view.CategoryCard
import com.example.pricingpal.view.settingRow
import io.ktor.http.Url

/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MediumTopAppBar(
                modifier = Modifier
                    //.fillMaxWidth()
                    .height(270.dp),
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Pink80
                ),
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ){
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(270.dp),
                            shape = RectangleShape,
                            elevation = CardDefaults.cardElevation(12.dp),
                            colors = CardDefaults.cardColors(containerColor = Cornflower_blue)
                        ){
                            Image(
                                //Imports image from resource folder
                                painter = painterResource(id = R.drawable.logo),
                                //description of the image for accessibility
                                contentDescription = "Pictures of paws",
                                modifier = Modifier
                                    .padding(top = 15.dp, start = 25.dp, end = 25.dp, bottom = 5.dp)
                            )
                            companySearchBar()
                        }
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        },
    ) {padding ->
        companyList(paddingValues = padding)
    }
}

 */



@Composable
fun pricingPalBar(){
    Row(
        //verticalAlignment = Alignment.CenterVertically,
        verticalAlignment = Alignment.Top,

    ){
        Card(
            modifier = Modifier
                .nestedScroll(rememberNestedScrollInteropConnection())
                .fillMaxWidth()
                .height(270.dp),
            shape = RectangleShape,
            elevation = CardDefaults.cardElevation(12.dp),
            colors = CardDefaults.cardColors(containerColor = Cornflower_blue)
        ){
            Image(
                //Imports image from resource folder
                painter = painterResource(id = R.drawable.logo),
                //description of the image for accessibility
                contentDescription = "Pictures of paws",
                modifier = Modifier
                    .padding(top = 15.dp, start = 25.dp, end = 25.dp, bottom = 5.dp)
            )
            companySearchBar()
        }
    }
}

@Composable
fun companySearchBar(){
    var loginEmail by remember { mutableStateOf("") }
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 50.dp, end = 50.dp),
        value = loginEmail,
        onValueChange = {loginEmail = it},
        textStyle = TextStyle.Default.copy(fontSize = 20.sp) ,
        placeholder = { Text("Search", fontSize = 20.sp) },
        trailingIcon = {
            Icon(imageVector = Icons.Filled.Search,
                contentDescription = "Search Icon",
                tint = Color.Black,
                modifier = Modifier
                    .size(50.dp)
                    .padding(end = 10.dp)
            ) },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Uranian_Blue,
            unfocusedContainerColor = Uranian_Blue,
            unfocusedIndicatorColor = Uranian_Blue,
            focusedIndicatorColor = Uranian_Blue
        ),
        shape = RectangleShape,
    )
}

@Composable
fun companiesTitle(){
    Card(
        shape = RectangleShape,
        modifier = Modifier
            .padding(15.dp),
        elevation = CardDefaults.cardElevation(12.dp),
    ) {
        Column( //verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(color = Cornflower_blue, shape = RectangleShape)
                .border(
                    // puts a border around the card
                    border = BorderStroke(4.dp, color = Persian_indigo),
                    // shapes the card
                    shape = RectangleShape
                )
                .fillMaxWidth()
                .padding(15.dp)
        )
        {

            Text(
                //shows the name of the category
                text = "Organizations",
                fontSize = 60.sp,
                // have it in bold to make it stand out
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )

            Text(
                //shows the name of the category
                text = "Select only one organization",
                fontSize = 30.sp,
                color = Color.Black,
            )
        }
    }
}

@Composable
fun companyName(){
    Card(
        modifier = Modifier
            // padding around the card
            .padding(15.dp)
            .border(
                // puts a border around the card
                border = BorderStroke(4.dp, color = Persian_indigo),
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
                text = "Organization Name",
                fontSize = 30.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .align(alignment = Alignment.CenterVertically)
            )

        }
    }
}

@Composable
fun companyList(){
    pricingPalBar()
    LazyColumn(
        modifier = Modifier
            .padding(top = 270.dp)
    ){

        item {
            companiesTitle()
        }
        for(i in 1..10) {
            item {
                companyName()
            }
        }
    }
}

