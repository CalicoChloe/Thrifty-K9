package com.example.pricingpal

/** Some of the imports I didn't take out because they are connected to the functions below, they are just on pause**/
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import com.example.pricingpal.model.CSVReader
import com.example.pricingpal.model.CSVParser
import com.example.pricingpal.model.ConnectingImage
import com.example.pricingpal.ui.theme.ItemList
import com.example.pricingpal.ui.theme.ListHeader
import com.example.pricingpal.ui.theme.PricingpalTheme

/** I took the UI out of the main page because I wanted to look similar to the set up for the navigation in the cupcake lab.
 * Plus I didn't want too much to be crowding the main. **/
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val csvp = CSVParser
            val categories = csvp.PopulateData(CSVReader.readFile(this, "testdata.csv"))
            val csvr = CSVReader

            // This is to show the list of items for the list view page
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

                    /** This is here to display the list of categories on the home page**/
                    Header(name = "search")
                    HomePageApp()
                    /** This is here if you can get the other function to work in connectingImages class **/
                    //CategoryList(list1 = ConnectingImage().loadImagesTemp(categories))
                    /** This is the experimental scaffold that is suppose to fix the header, but it not working. Connor you might want to look at this. **/
                    //CenterAlignedTopAppBarExample(categories = categories)

                    /** This here is to display the list of items on the list view page **/
                    //ListHeader(name = "search")
                    //ItemList(itemList = items, categories)
                }
            }
        }
    }

}
