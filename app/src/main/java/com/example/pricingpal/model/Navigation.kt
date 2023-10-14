package com.example.pricingpal.model

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pricingpal.view.CategoryList
import com.example.pricingpal.view.ItemList
import com.example.pricingpal.view.Screen

@Composable
fun Navigation(categories: ArrayList<Category>, padding: PaddingValues) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.CategoryList.route) {
        composable(route = Screen.CategoryList.route) {
            CategoryList(categories = categories, navController = navController, padding = padding)
        }
        composable(route = Screen.ItemList.route + "/{categoryName}",
            arguments = listOf(
                navArgument("categoryName") {
                    type = NavType.StringType
                }
            )
        ) {entry ->
            ItemList(selectedCategory = entry.arguments?.getString("categoryName"), padding = padding)
        }
    }
}