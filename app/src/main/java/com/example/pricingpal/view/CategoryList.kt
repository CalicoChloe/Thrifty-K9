package com.example.pricingpal.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pricingpal.R
import com.example.pricingpal.model.Category
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Persian_indigo

const val  CATEGORY_NAMES = "categories"
//Will be replaced with the actual authentication status
var loggedIn = false
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoryList (categories: HashMap<String, Category>, navController: NavController, padding: PaddingValues){
    LazyColumn(
        modifier = Modifier
            .padding(top = 54.dp)
    ) {
        // takes each category card and put into a list
        for(category : Category in categories.values){
            item {ViewCategory(category, navController)}
        }

        if (!loggedIn){
            item { VolunteerHome() }
        } else{
            item { EditButton() }
        }

    }
}

@Composable
//puts the category name into a card view
fun ViewCategory(category: Category, navController: NavController){
    Card(
        shape = RectangleShape,
        modifier = Modifier
            .clickable(onClick = { navController.navigate(Screen.ItemList.withArgs(category.category)) })
            .padding(start = 10.dp, end = 10.dp)
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
        )
        {
            Image(
                painter = painterResource(id = R.drawable.rectangle_22), // will display the image the that was uploaded
                contentDescription = "Accessories image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                contentScale = ContentScale.Crop,
                alpha = 0.8F
            )

            Row(modifier = Modifier
                .border(4.dp, color = Persian_indigo)
                .fillMaxWidth()
                .height(60.dp)
                .background(color = Cornflower_blue, shape = RectangleShape),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = category.category, // name of category
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                )

            }
        }
    }
}

//Home Button
// Will navigate back to the starter Screen
@Composable
fun VolunteerHome(){
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
        Text(
            textAlign = TextAlign.Center,
            text = "Home",
            fontSize = 30.sp,
            color = Color.Black,
        )
    }
}

@Composable
fun EditButton(){
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