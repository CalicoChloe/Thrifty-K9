package com.example.pricingpal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pricingpal.model.CSVParser
import com.example.pricingpal.model.CSVReader
import com.example.pricingpal.model.Category
import com.example.pricingpal.model.Navigation
import com.example.pricingpal.viewmodel.CategoryViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = viewModel<CategoryViewModel>(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return CategoryViewModel(context = this@MainActivity) as T
                    }
                }
            )
            CategoryScaffold(categories = viewModel.categories)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScaffold(categories: HashMap<String, Category>) {
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
           Navigation(categories = categories, padding = padding)
        },
        //Background color for the content
        containerColor = Color(0xFFC7F9CC)
    )
}