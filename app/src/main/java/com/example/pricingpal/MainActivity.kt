package com.example.pricingpal


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pricingpal.ui.theme.PricingpalTheme
import com.example.pricingpal.view.background
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
            /** This is what I use to show my UI designs. Loading screen is separated because it uses a different background*/
            //Loading()
            //volunteerLoading()
            //editLoading()
            background()
            PricingpalTheme {
                PricingPalApp(categories = viewModel.categories)
            }
        }
    }
}
