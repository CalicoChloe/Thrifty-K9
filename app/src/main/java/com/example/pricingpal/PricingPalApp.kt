package com.example.pricingpal


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.pricingpal.model.Category
import com.example.pricingpal.ui.theme.Anti_flash_white
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.view.Navigation
import com.example.pricingpal.view.WindowSize

// const used to reference the custom back button for testing purposes
const val BACK_BUTTON = "Back Button"

/**
 * Composable that displays the topBar, and a back button if navigation is possible
 *
 * @param canNavigateBack Navigation Controller Boolean used to check if the current page was accessed through another page
 * @param navigateUp Navigation Controller Boolean used to navigate through the app
 *
 * @author Abdoulie NJie
 * @author Chloe Jackson
 * @author Shianne Lesure
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PricingPalAppBar(
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
) {
    /** I replaced the old with this one. I couldn't get the logo to look right with the UI scaling,
     * and since there is no action that is being done with the logo, I removed it. Because I remove
     * it, it allowed for the bar to be smaller since it will only have the back arrow within the bar.*/
    TopAppBar(
        title = { Text(text ="") }, // I left this in here because if I remove it, it will cause an error
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor =  Periwinkle
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back Button",
                        tint = Color.Black,
                        modifier = Modifier
                            .testTag(BACK_BUTTON)
                            .size(40.dp)
                            .padding(start = 10.dp, top = 5.dp)

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
 * @param categories the HashMap of category objects, ith category name as the key and the respective category object as the value.
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * @author Connor Murdock
 * @author Abdoulie NJie
 * @author Chloe Jackson
 * @author Shianne Lesure
 **/
@Composable
fun PricingPalApp(categories: HashMap<String, Category>, windowSize : WindowSize) {
    //Initialize navController
    val navController = rememberNavController()

    //Create an app bar of medium size at the top of the scaffold
    PricingPalAppBar(
        navigateUp =  {navController.navigateUp()},
        canNavigateBack = navController.previousBackStackEntry != null,
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

                Navigation(categories = categories, padding, windowSize)
            }
        },
        //Background color for the content
        containerColor = Anti_flash_white
    )

}
