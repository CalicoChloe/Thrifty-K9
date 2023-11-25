package com.example.pricingpal.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pricingpal.PricingPalApp
import com.example.pricingpal.R
import com.example.pricingpal.model.Category
import com.example.pricingpal.ui.theme.Anti_flash_white
import com.example.pricingpal.view.settings.guestaccount.guestAccountSetting

/**
 *
 * Composable function to set up the app's top app bar, and navigation between screens.
 *
 * This function creates the NavHost and NavController,
 * and handles the application's navigation  function is call.
 *
 * @property categories the HashMap of category objects,
 * @property padding the padding value of the screen
 *
 * @author Connor Murdock
 *
 **/

@Composable
fun Navigation(categories: HashMap<String, Category>, padding: PaddingValues,windowSize: WindowSize ) {
    //Initialize navController
    val navController = rememberNavController()
    //Setup the NavHost
    NavHost(navController = navController, startDestination = Screen.CategoryList.route) {
        //The route to the CategoryList. This is the start destination
        composable(route = Screen.CategoryList.route) {
            CategoryList(
                categories = categories,
                navController = navController,
                padding = padding,
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
                padding = padding,
                categories,
                windowSize = windowSize
            )
        }
    }
}

@Composable
fun NonScaffoldNavigateScreens(categories: HashMap<String, Category>, windowSize: WindowSize){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "loading_screen") {
        composable("loading_screen"){
            AnimatedSlashScreen(navController = navController,windowSize = windowSize)
        }
        composable("starter_screen"){
            startScreen(navController = navController,windowSize =  windowSize )
        }

        composable("category_list") {
            PricingPalApp(categories = categories, windowSize = windowSize)
        }
    }
}