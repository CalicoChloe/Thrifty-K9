package com.example.pricingpal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pricingpal.model.CSVReader
import com.example.pricingpal.model.CSVParser
import com.example.pricingpal.model.Category
import com.example.pricingpal.ui.theme.ItemList
import com.example.pricingpal.ui.theme.ListHeader
import com.example.pricingpal.ui.theme.PricingpalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val csvp = CSVParser
            val categories = csvp.PopulateData(CSVReader.readFile(this, "testdata.csv"))
            val csvr = CSVReader
            val items = csvr.readFile(this, "testdata.csv")
            PricingpalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    //This changes the color of the background of the tablet.
                    color = colorResource(id = R.color.grey_blue)
                ) {
                    //This is an import of the paw Image. This will sit on top of the background color.
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
                   // Header(name = "search")
                    //CategoryList(categories)

                    ListHeader(name = "search")
                    ItemList(itemList = items, categories)
                }
            }
        }
    }
}
