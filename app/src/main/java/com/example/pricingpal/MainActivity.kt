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
            /* Initialize the Category ViewModel
             * This ViewModel will keep the data loaded properly even when the app status is updated
             * factory is required to pass arguments to the ViewModel when instantiated (needs MainActivity context)
             */
/*            val viewModel = viewModel<CategoryViewModel>(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return CategoryViewModel(context = this@MainActivity) as T
                    }
                }
            )*/
            val viewModel: NewCategoryViewModel by viewModels()
            val window = rememberSize()
            /** This is what I use to show my UI designs. Loading screen is separated because it uses a different background*/
            //Loading()
            //volunteerLoading()
            //editLoading()
            //background()
            PricingpalTheme {
                NonScaffoldNavigateScreens(categories = viewModel.categories, windowSize = window)
                //Log.e("VIEWMODEL", viewModel.categories.toString())
            }
        }
    }
}
