package com.example.pricingpal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.pricingpal.model.FileReaderCSV
import com.example.pricingpal.model.Category
import com.example.pricingpal.ui.theme.PricingpalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val fr = FileReaderCSV
            val categories = fr.PopulateData()
            PricingpalTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CategoryList(categories)
                }
            }
        }
    }
}

@Composable
fun CategoryList(categories: ArrayList<Category>) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        for (category: Category in categories) {
            item {
                CreateListItem(text = category.name, padding = 10)
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