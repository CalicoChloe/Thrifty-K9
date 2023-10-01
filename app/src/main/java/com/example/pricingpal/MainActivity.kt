package com.example.pricingpal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pricingpal.model.CSVReader
import com.example.pricingpal.model.CSVParser
import com.example.pricingpal.model.Category
import com.example.pricingpal.ui.theme.PricingpalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val csvp = CSVParser
            val categories = csvp.PopulateData(CSVReader.readFile(this, "testdata.csv"))
            PricingpalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                        //.background(Color(0xFFC7F9CC)),
                    //color = MaterialTheme.colorScheme.background,
                    color = Color(0xFFC7F9CC)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.paw_background),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        alpha = 0.1F
                    )
                    CategoryList(categories)
                }
            }
        }
    }
}

/*
@Composable
fun CategoryList(categories: ArrayList<Category>) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        for (category: Category in categories) {
            item {
                CreateListItem(text = category.category, padding = 10)
            }
        }
    }
}

@Composable
fun CreateListItem(text: String, padding: Int, modifier: Modifier = Modifier) {
    Surface(color = Color.LightGray, modifier = Modifier
        .border
            (
            border = BorderStroke(2.dp, Color.Black),
            shape = RectangleShape
        )
        .fillMaxWidth()) {
        Text(
            text = text,
            modifier = modifier.padding(padding.dp),
            textAlign = TextAlign.Center
        )
    }
}

 */


@Composable
fun CategoryList (categories: ArrayList<Category>){
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.picture2),
                contentDescription = "pricing pal logo",
                modifier = Modifier
                    .padding(top = 10.dp)
                    .width(600.dp)
                    .height(150.dp),
            )
        }
        for(category : Category in categories) {
           item { CategoryCard(category = category)}
        }
    }
}



@Composable
fun CategoryCard(category: Category){
    Card(modifier = Modifier
        .padding(15.dp)
        .border(
            border = BorderStroke(3.dp, Color(0xFF22577A)),
            shape = RectangleShape
        ),
        elevation = CardDefaults.cardElevation(12.dp),
        //shape = RoundedCornerShape(16.dp)
    ) {

        Box(modifier = Modifier
            .width(700.dp)
            .height(200.dp)
            .background(Color(0xFF38A3A5)),
            contentAlignment = Alignment.Center,
            ){
            Text(
                text = category.category,
                fontSize = 70.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 116.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    //.padding(start = 150.dp)
                    .padding(50.dp)
                    .align(alignment = Alignment.TopCenter),
                )
        }
    }
}