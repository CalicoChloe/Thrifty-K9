package com.example.pricingpal


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pricingpal.model.Category
import com.example.pricingpal.view.CategoryList
import com.example.pricingpal.view.ItemList
import com.example.pricingpal.view.Screen


/**
 * Composable that displays the topBar that contains the app's logo that can navigate back to
 * the landing page.
 * @param returnToCategoryPage boolean used to check if the current page is the category list page or not
 * @param navController Navigation controller used to navigate through the app
 *
 * @author Abdoulie NJie
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PricingPalAppBar(
    returnToCategoryPage: Boolean,
    navController: NavController,
) {
    TopAppBar(
        title = {
            /**
             * If statement that checks if returnToCategoryPage is true or false
             * The statement is set up to be false, since it is not
             * compared to anything that could change it to ture
            */
            if (!returnToCategoryPage) {
                TextButton(onClick = { navController.navigate(Screen.CategoryList.route) }) {
                    // this is where the resource needed to change the image for the app bar
                    Image(
                        painter = painterResource(id = R.drawable.picture2),
                        contentDescription = null,
                        modifier = Modifier
                            .height(90.dp)
                            .background(color = colorResource(id = R.color.pale_blue))
                            .padding(start = 100.dp)
                            .padding(end = 180.dp)
                    )

                }
            }
        }
    )
}


/**
 *
 * Composable function to set up the app's top app bar, and navigation between screens.
 *
 * This function creates the Scaffold, NavHost and NavController,
 * and handles what should happen when the PricingPalApp function is called.
 *
 * @property categories the HashMap of category objects,
 * with category name as the key and the respective category object as the value.
 *
 * @author Connor Murdock
 * @author Abdoulie NJie
 **/
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
                // bool used to indicate if the current screen is the category list screen or not
                returnToCategoryPage = currentScreen != Screen.CategoryList,
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
        containerColor = colorResource(id = R.color.grey_blue)
    )
}