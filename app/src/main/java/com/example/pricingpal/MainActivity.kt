package com.example.pricingpal


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.lifecycle.viewmodel.compose.viewModel

import com.example.pricingpal.ui.theme.PricingpalTheme
import com.example.pricingpal.view.background

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.example.pricingpal.viewmodel.CategoryViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /* Initialize the Category ViewModel
             * This ViewModel will keep the data loaded properly even when the app status is updated
             * factory is required to pass arguments to the ViewModel when instantiated (needs MainActivity context)
             */
            val viewModel = viewModel<CategoryViewModel>(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return CategoryViewModel(context = this@MainActivity) as T
                    }
                }
            )
            PricingpalTheme {
                PricingPalApp(categories = viewModel.categories)
            }

            //Create the scaffold passing in the HashMap of categories to be used for display
            //CategoryScaffold(categories = viewModel.categories)

            /** This is what I use to show my UI designs. Loading screen is separated because it uses a different background*/
            //Loading()
            //volunteerLoading()
            //editLoading()
            //background()
        }
    }
}

/**
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CategoryScaffold(categories: HashMap<String, Category>) {
        Scaffold(
            //Create an app bar of medium size at the top of the scaffold
            topBar = {
                LargeTopAppBar(
                    title = {
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
                    //color = Color.DarkGray,

                )
            },

            //padding automatically adjusts to match the app bar size
            content = { padding ->
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
                androidx.navigation.Navigation(categories = categories, padding = padding)
            },
            //Background color for the content
            containerColor = Anti_flash_white

        )
    }
    */



