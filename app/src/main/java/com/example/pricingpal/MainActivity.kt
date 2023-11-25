package com.example.pricingpal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.pricingpal.ui.theme.PricingpalTheme
import com.example.pricingpal.view.NonScaffoldNavigateScreens
import com.example.pricingpal.view.rememberSize
import com.example.pricingpal.viewmodel.NewCategoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Initialize the viewmodel
            val viewModel: NewCategoryViewModel by viewModels()
            val window = rememberSize()
            PricingpalTheme {
                NonScaffoldNavigateScreens(categories = viewModel.categories, windowSize = window)
                //Log.e("VIEWMODEL", viewModel.categories.toString())
            }
        }
    }
}
