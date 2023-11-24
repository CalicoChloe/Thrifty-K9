package com.example.pricingpal


//import com.example.pricingpal.viewmodel.CategoryViewModel
//import com.example.pricingpal.model.Database
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.pricingpal.ui.theme.Anti_flash_white
import com.example.pricingpal.ui.theme.PricingpalTheme
import com.example.pricingpal.view.background
import com.example.pricingpal.view.settings.guestaccount.guestAccountSetting
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
            /** This is what I use to show my UI designs. Loading screen is separated because it uses a different background*/
            //Loading()
            //volunteerLoading()
            //editLoading()
            //background()
            PricingpalTheme {
                PricingPalApp(categories = viewModel.categories)
                //PricingPalApp(categories = viewModel.categories)
                //Log.e("VIEWMODEL", viewModel.categories.toString())
            }
        }
    }
}
