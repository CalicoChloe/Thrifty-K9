package com.example.pricingpal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import com.example.pricingpal.model.CSVReader
import com.example.pricingpal.model.CSVParser
import com.example.pricingpal.model.ConnectingImage
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
                    //ConnectingImage().ConnectImages(categories1 = categories)
                    Header(name = "search")
                    //ConnectingImage().ConnectImages(categories1 = categories)
                    CategoryList(list1 = ConnectingImage().loadImages(categories))

                    //ListHeader(name = "search")
                    //ItemList(itemList = items, categories)
                }
            }
        }
    }

}
