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
 * @param currentScreen value used to keep reference to current screen the app is on
 * @param canNavigateBack boolean used to check if the current page is the landing page or not
 * @param navController Navigation controller used to navigate back to the landing page
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
            // if statement that checks if returnToCategoryPage is true or false
            // if it is false, the user may click the logo and return to the category page
            // if it is true, the user may click the logo to refresh the category page
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
                returnToCategoryPage = currentScreen != Screen.CategoryList, // boolean is set to true
                navController = navController
            )
        },
        //padding automatically adjusts to match the app bar size
        content = { padding ->
//            //Initialize navController
//            val navController = rememberNavController()

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