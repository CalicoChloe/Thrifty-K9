package com.example.pricingpal.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pricingpal.R
import com.example.pricingpal.view.CategoryList
import com.example.pricingpal.view.ItemList
import com.example.pricingpal.view.Screen


/**
 * Composable that displays the topBar that contains the app's logo that can navigate back to
 * the landing page.
 * @param currentScreen value used to keep reference to current screen the app is on
 * @param canNavigateBack boolean used to check if the current page is the landing page or not
 * @param navController Navigation controller used to navigate back to the landing page
 *
 * @author Abdoulie NJie
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PricingPalAppBar(
    currentScreen: Screen.CategoryList,
    canNavigateBack: Boolean,
    navController: NavController,
) {
    TopAppBar(
        title = {
            if (!canNavigateBack) {
                TextButton(onClick = { navController.navigate(Screen.CategoryList.route) }) {
                    // this is where the resource needed to change the image for the app bar
                    Image(
                        painter = painterResource(id = R.drawable.picture2),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 10.dp, start = 15.dp)
                            .width(200.dp)
                            .height(60.dp)
                    )

                }
            }
        }
    )
}

/**
 * Composable function to set up the Navigation between screens.
 *
 * This function creates the NavHost and NavController, and handles what should happen when the navigate function is called.
 * This function also creates a scaffold that calls the PricingPalAppBar to creates an app bar at the top of the application's screen.
 *
 * @property categories the HashMap of category objects, with category name as the key and the respective category object as the value.
 *
 * @author Connor Murdock
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PricingPalApp(categories: HashMap<String, Category>) {
    //Initialize navController
    val navController = rememberNavController()

    Scaffold(
        //Create an app bar of medium size at the top of the scaffold
        topBar = {
            // Get the name of the current screen
            val currentScreen = Screen.CategoryList
            PricingPalAppBar(
                currentScreen = currentScreen,
                canNavigateBack = currentScreen != Screen.CategoryList,
                navController = navController
            )
        },
        //padding automatically adjusts to match the app bar size
        content = { padding ->

            //Setup the NavHost
            NavHost(navController = navController, startDestination = Screen.CategoryList.route) {
                //The route to the CategoryList. This is the start destination
                composable(route = Screen.CategoryList.route) {
                    CategoryList(
                        categories = categories,
                        navController = navController,
                        padding = padding
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
                        categories
                    )
                }
            }
        },
        //Background color for the content
        containerColor = Color(0xFFC7F9CC)
    )
}