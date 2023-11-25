package com.example.pricingpal


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pricingpal.model.Category
import com.example.pricingpal.ui.theme.Anti_flash_white
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.view.Navigation
import com.example.pricingpal.view.Screen

// const used to reference the custom back button for testing purposes
const val BACK_BUTTON = "Back Button"

/**
 * Composable that displays the topBar, and a back button if navigation is possible
 *
 * @param canNavigateBack Navigation Controller Boolean used to check if the current page was accessed through another page
 * @param navigateUp Navigation Controller Boolean used to navigate through the app
 *
 * @author Abdoulie NJie
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PricingPalAppBar(
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    currentScreen: String,
    modifier: Modifier = Modifier,
) {
    LargeTopAppBar(
        title = {
            Text(currentScreen)
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .height(90.dp)
                    .background(color = Cornflower_blue)
                    .padding(start = 100.dp)
                    .padding(end = 180.dp)
            )
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor =  Periwinkle
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back Button",
                        Modifier.testTag(BACK_BUTTON)

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
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen for navigate up to work properly
    val currentScreen = Screen.valueOf(
        (backStackEntry?.destination?.route ?: Screen.CategoryList.route)
    )
    val navigateUp = navController.navigateUp()

    val canNavigateBack = navController.previousBackStackEntry != null

    PricingPalAppBar(
        navigateUp = { navigateUp },
        canNavigateBack = canNavigateBack,
        currentScreen = currentScreen
    )


    Scaffold(
        //padding automatically adjusts to match the app bar size
        content = { padding ->
            Navigation(categories = categories, padding, navigateUp, canNavigateBack, currentScreen)
            Image(
                //Imports image from resource folder
                painter = painterResource(id = R.drawable.paw_background),
                //description of the image for accessibility
                contentDescription = "Pictures of paws",
                //crops the image
                contentScale = ContentScale.Crop,
                // changes the opacity of the image
                alpha = 0.1F
            )},
        //Background color for the content
        containerColor = Anti_flash_white
    )

}