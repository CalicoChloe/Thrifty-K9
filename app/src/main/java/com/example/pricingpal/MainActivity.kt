package com.example.pricingpal


import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pricingpal.model.CategoryItemRepositoryImpl
import com.example.pricingpal.model.Database
import com.example.pricingpal.ui.theme.PricingpalTheme
import com.example.pricingpal.viewmodel.CategoryViewModel
import com.example.pricingpal.viewmodel.NewCategoryViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.Timer


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /* Initialize the Category ViewModel
             * This ViewModel will keep the data loaded properly even when the app status is updated
             * factory is required to pass arguments to the ViewModel when instantiated (needs MainActivity context)
             */
            //val viewModel = viewModel<CategoryViewModel>(
            //    factory = object : ViewModelProvider.Factory {
            //        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            //            return CategoryViewModel(context = this@MainActivity) as T
            //        }
            //    }
            //)

            val viewModel = NewCategoryViewModel(categoryItemRepository = CategoryItemRepositoryImpl(Database.getClient()))

            for (c in viewModel.categories) {
                Log.i("Category", c.toString())
            }

                PricingpalTheme {
                    PricingPalApp(categories = viewModel.categories)
                }





        }
    }
}