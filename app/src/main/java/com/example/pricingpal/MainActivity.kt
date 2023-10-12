package com.example.pricingpal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pricingpal.model.CSVReader
import com.example.pricingpal.model.CSVParser
import com.example.pricingpal.model.Category

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val csvp = CSVParser
            val categories = csvp.PopulateData(CSVReader.readFile(this, "testdata.csv"))
            CategoryScaffold(categories)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScaffold(categories: ArrayList<Category>) {
    Scaffold (
        topBar = {
            MediumTopAppBar(
                title = {
                    // App bar title
                    Text(text = "Pricing Pal")
                }
            )
        },
        //padding automatically adjusts to match the app bar size
        content = { padding ->
            CategoryList(categories, padding)
        },
        //Background color for the content
        containerColor = Color(0xFFC7F9CC)
    )
}

@Composable
// this function will take categories cards and put them into a scrollable list
fun CategoryList (categories: ArrayList<Category>, padding: PaddingValues){
    LazyColumn(
        //aligns the categories within the center
        modifier = Modifier.padding(padding).fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        // takes each category card and put into a list
        for(category : Category in categories) {
           item { CategoryCard(category = category)}
        }
    }
}

@Composable
//puts the category name into a card view
fun CategoryCard(category: Category){
    Card(modifier = Modifier
        // padding around the card
        .padding(15.dp)
        .border(
            // puts a border around the card
            border = BorderStroke(3.dp, Color(0xFF22577A)),
            // shapes the card
            shape = RectangleShape
        ),
        // puts a shadow under the card to make it pop out
        elevation = CardDefaults.cardElevation(12.dp),
    ) {
        // Allows for the text to be put on top of the card
        Box(modifier = Modifier
            // the size of the box
            .width(700.dp)
            .height(200.dp)
            // changes the color of the box
            .background(Color(0xFF38A3A5)),
            //allows for the content to be put into the center of the box
            contentAlignment = Alignment.Center,
            ){
            Text(
                // takes the text from the category variable
                text = category.category,
                // changes the size of the font
                fontSize = 70.sp,
                // allows for the font to be in bold
                fontWeight = FontWeight.Bold,
                lineHeight = 116.sp,
                //change the color of the text
                color = Color.Black,
                modifier = Modifier
                    .padding(50.dp)
                )
        }
    }
}