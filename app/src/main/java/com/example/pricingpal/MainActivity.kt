package com.example.pricingpal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pricingpal.ui.theme.PricingpalTheme

class MainActivity : ComponentActivity() {

    private val fileName = "testdata.csv"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //When merged, it should instantiate the CSVReader object from that class
            //will need to be imported probably as it is in another package now
            val reader = CSVReader()
            val items = reader.readFile(this, fileName)
            PricingpalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    ShowItemList(items)
                }
            }
        }
    }
}

/**
 * ShowItemList
 * This function accepts a List of Item objects and displays them in
 *  a lazy column format. The function uses CreateItemPriceList to display
 *  the text and apply modifier properties
 * @author Julian Ellis
 * @param itemList The list of items generated in onCreate by the CSVReader class
 */
@Composable
fun ShowItemList(itemList: List<Item>) {

    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        for (i in itemList) {
            item {
                CreateItemPriceList(text = i.toString(), padding = 2)
            }
        }
    }
}

/**
 * CreateItemPriceList
 * This function creates the surface and displays and formats the text to
 *  display items in a list
 * @author Julian Ellis
 * @param text The text to display
 * @param padding The value to set for padding in .dp
 * @param modifier The modifier values to apply to the list items
 */
@Composable
fun CreateItemPriceList(text: String, padding: Int, modifier: Modifier = Modifier) {
    Surface(
        color = Color.LightGray, modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = text,
            modifier = modifier.padding(padding.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PricingpalTheme {
        Greeting("Android")
    }
}