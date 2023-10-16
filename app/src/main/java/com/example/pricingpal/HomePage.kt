package com.example.pricingpal

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pricingpal.model.Category
import com.example.pricingpal.model.CategoryImages
import com.example.pricingpal.model.ConnectingImage
/** Connor this is my scaffold. It is not working some reason.
 * When you modify the scaffold, can you keep it as the center app bar. I think it looks nicer for our project. **/
/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterAlignedTopAppBarExample(categories: ArrayList<Category>) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.pale_blue),
                    titleContentColor = colorResource(id = R.color.sky_blue),
                ),
                title = {
                    Text(
                        "Centered Top App Bar",
                        maxLines = 1,

                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Search, /*ImageVector.vectorResource(id = R.drawable.picture2),*/
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Localized description"
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        },
    )
    { innerPadding ->
        CategoryList(list1 = ConnectingImage().loadImages(categories), innerPaddingValues = innerPadding)

    }
}

 */

@Composable
fun Header( name: String){
    Row(
        modifier = Modifier
            // wraps completely around the text
            .wrapContentSize(Alignment.TopCenter, false)
            //fills it to hit the edge of the device
            .fillMaxWidth()
            .height(80.dp)
            .background(color = colorResource(id = R.color.sky_blue), shape = RectangleShape)) {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 10.dp, start = 15.dp)
                .width(200.dp)
                .height(60.dp)
            //.requiredSize(60.dp),

        )

        Surface(
            shape = RectangleShape,
            color = colorResource(id = R.color.pale_blue),
            modifier = Modifier
                // wraps completely around the text
                .wrapContentSize(Alignment.TopCenter, false)
                //fills it to hit the edge of the device
                .size(width = 490.dp, height = 70.dp)
                .padding(top = 20.dp, bottom = 10.dp, start = 15.dp, end = 10.dp)
        ){
            Text(
                text = name,
                textAlign = TextAlign.Start,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(top = 8.dp, start = 5.dp)
            )
        }

        Image(
            painter = painterResource(id = R.drawable.icons8_search_128),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 17.dp)
                .requiredSize(50.dp),
        )
    }

}

/** Until you can get the scaffold to work Connor, you can plug this in to see the UI design.
 * Just remove the inner paddings, and uncomment the category arraylist. **/
@Composable
fun CategoryList (/*categories: ArrayList<Category>,*/ list1:List<CategoryImages> /*, innerPaddingValues: PaddingValues*/) {

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 80.dp)
            //.padding(innerPaddingValues)
    ) {
        for (categoryImages: CategoryImages in list1){
            item { CategoryCard( categoryImages = categoryImages) }
        }

    }
}

@Composable
fun CategoryCard( categoryImages: CategoryImages) {
    Card(modifier = Modifier
        .padding(15.dp)
        .fillMaxWidth()
        //.background(color = colorResource(id = R.color.pale_blue))
        .border(
            // puts a border around the card
            border = BorderStroke(4.dp, color = colorResource(id = R.color.deep_blue)),
            // shapes the card
            shape = RectangleShape
        ),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.pale_blue)
        )
    )
    {
        Column(modifier = Modifier
            .background(color = colorResource(id = R.color.pale_blue))
        )
        {
            Image(
                painter = painterResource(categoryImages.imagesID),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop,
                alpha = 0.8F
            )

            Text(
                text = categoryImages.category,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(10.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
        }
    }
}


