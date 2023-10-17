package com.example.pricingpal.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.pricingpal.model.Category
import com.example.pricingpal.model.Navigation
import com.example.pricingpal.model.PricingPalAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PricingPalScaffo(categories: HashMap<String, Category>) {
    //Initialize navController
    val navController = rememberNavController()

    Scaffold(
        //Create an app bar of medium size at the top of the scaffold
        topBar = {
            // Get the name of the current screen
            val currentScreen = Screen.CategoryList
            PricingPalAppBar(
                canNavigateBack = currentScreen != Screen.CategoryList,
                navController = navController
            )
        },
        //padding automatically adjusts to match the app bar size
        content = { padding ->
            Navigation(categories = categories, padding = padding )
        },
        //Background color for the content
        containerColor = Color(0xFFC7F9CC)
    )
}


