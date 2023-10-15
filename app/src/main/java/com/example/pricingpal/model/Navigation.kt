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

/**
 * Composable function to set up the Navigation between screens.
 *
 * This function creates the NavHost and NavController, and handles what should happen when the navigate function is called.
 *
 * @property categories the HashMap of category objects, with category name as the key and the respective category object as the value.
 * @property padding the PaddingValue that is received from the scaffold to automatically pad the content to avoid being blocked by the app bar.
 *
 * @author Connor Murdock
 */
@Composable
fun Navigation(categories: HashMap<String, Category>, padding: PaddingValues) {
    //Initialize navController
    val navController = rememberNavController()
    //Setup the NavHost
    NavHost(navController = navController, startDestination = Screen.CategoryList.route) {
        //The route to the CategoryList. This is the start destination
        composable(route = Screen.CategoryList.route) {
            CategoryList(categories = categories, navController = navController, padding = padding)
        }
        //The route to the ItemList. This route requires a categoryName String to be passed in to get the list of items down the line
        composable(route = Screen.ItemList.route + "/{categoryName}",
            arguments = listOf(
                navArgument("categoryName") {
                    type = NavType.StringType
                }
            )
        ) {entry ->
            ItemList(selectedCategory = entry.arguments?.getString("categoryName"), padding = padding, categories)
        }
    }
}