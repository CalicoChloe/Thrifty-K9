package com.example.pricingpal.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pricingpal.model.Category

/**
 *
 * Composable function to set up the app's top app bar, and navigation between screens.
 *
 * This function creates the NavHost and NavController,
 * and handles the application's navigation  function is call.
 *
 * @property categories the HashMap of category objects,
 * @param  padding value used to store padding values of content
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 *
 *
 *
 * @author Connor Murdock
 * @author Abdoulie NJie
 * @author Shianne Lesure
 **/

@Composable
fun Navigation(
    categories: HashMap<String, Category>,
    padding: PaddingValues,
    windowSize: WindowSize
) {
    //Initialize navController
    val navController = rememberNavController()
    //Setup the NavHost
    NavHost(navController = navController, startDestination = Screen.LoadingScreen.route) {
        composable(route = Screen.LoadingScreen.route){
            AnimatedSlashScreen(navController = navController,windowSize = windowSize)
        }
        composable(route = Screen.HomeScreen.route){
            StartScreen(navController = navController,windowSize = windowSize)
        }
        composable(route = Screen.LoginScreen.route){
            LoginHeader(navController = navController,windowSize = windowSize)
        }
        //The route to the CategoryList. This is the start destination
        composable(route = Screen.CategoryList.route) {
            CategoryList(
                categories = categories,
                navController = navController,
                windowSize = windowSize
            )
        }
        //The route to the ItemList. This route requires a categoryName String to be passed in to get the list of items down the line
        composable(route = Screen.ItemList.route + "/{categoryName}",
            arguments = listOf(
                navArgument("categoryName") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            ItemList(
                selectedCategory = entry.arguments?.getString("categoryName"),
                categories,
                navController = navController,
                windowSize = windowSize
            )
        }
    }
}

//We hope future students enjoy navigating this project as much as we did!
//Happy coding!
