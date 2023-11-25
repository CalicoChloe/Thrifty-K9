package com.example.pricingpal.view

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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pricingpal.R
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Persian_indigo
import com.example.pricingpal.ui.theme.Uranian_Blue

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


@Composable
fun searchBar(windowSize: WindowSize){
    val searchHeight by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 50 else 60) }
    val iconSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.height == WindowType.Compact) 20 else 40) }
    val searchPaddingWidth by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 25 else 50) }
    val textSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 16 else 20) }
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
            onValueChange = { searching = it },

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
                            .size(iconSize.dp)
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
                            .size(iconSize.dp)
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