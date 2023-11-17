package com.example.pricingpal


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pricingpal.model.Category
import com.example.pricingpal.model.Navigation
import com.example.pricingpal.ui.theme.Anti_flash_white
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.PricingpalTheme
import com.example.pricingpal.view.Loading
import com.example.pricingpal.view.background
import com.example.pricingpal.view.editinglist.editLoading
import com.example.pricingpal.view.homepage.volunteer.volunteerLoading

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pricingpal.ui.theme.PricingpalTheme

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

            //Create the scaffold passing in the HashMap of categories to be used for display
            //CategoryScaffold(categories = viewModel.categories)

            /** This is what I use to show my UI designs. Loading screen is separated because it uses a different background*/
            //Loading()
            //volunteerLoading()
            //editLoading()
            background()
        }
    }
}

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
                Navigation(categories = categories, padding = padding)
            },
            //Background color for the content
            containerColor = Anti_flash_white

        )
    }


            PricingpalTheme {
                PricingPalApp(categories = viewModel.categories)
            }
        }
    }
}

