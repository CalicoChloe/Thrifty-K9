package com.example.pricingpal


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pricingpal.model.Category
import com.example.pricingpal.ui.theme.Anti_flash_white
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
 * @param currentScreen String used to title the name of the current screen being displayed by the app
 *
 * @author Abdoulie NJie
 * @author Chloe Jackson
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PricingPalAppBar(
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    currentScreen: String,
    modifier: Modifier = Modifier,
) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor =  Periwinkle
        ),
        title = {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = currentScreen,
                modifier = Modifier
                    .fillMaxSize(0.5f)
            )
        },
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
 * @author Chloe Jackson
 **/
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

    //Create an app bar of medium size at the top of the scaffold
    PricingPalAppBar(
        navigateUp =  {navController.navigateUp()},
        canNavigateBack = navController.previousBackStackEntry != null,
        currentScreen = currentScreen
    )

    Scaffold(
        //padding automatically adjusts to match the app bar size
        content = { padding ->
            Surface(
                modifier = Modifier
                    .fillMaxSize(),
                color = Anti_flash_white
            ) {
                Image(
                    //Imports image from resource folder
                    painter = painterResource(id = R.drawable.paw_background),
                    //description of the image for accessibility
                    contentDescription = "Pictures of paws",
                    //crops the image
                    contentScale = ContentScale.Crop,
                    // changes the opacity of the image
                    alpha = 0.1F
                )
                Navigation(categories = categories, padding, currentScreen)
            }
        }
    )

}
