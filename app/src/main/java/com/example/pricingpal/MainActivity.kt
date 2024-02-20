package com.example.pricingpal
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.pricingpal.ui.theme.PricingpalTheme
import com.example.pricingpal.view.rememberSize
import com.example.pricingpal.viewmodel.CategoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Initialize the viewmodel
            val viewModel: CategoryViewModel by viewModels()
            // Initialize the window
            val window = rememberSize()

            PricingpalTheme {
                PricingPalApp(categories = viewModel.categories, windowSize = window)
            }
            //LoginHeader(window)
            //ForgotPasswordHeader(window)
            //CreatePasswordHeader(window)
            //ChooseRegisterHeader(window)
            //OwnerRegisterationHeader(window)
            //GuestCompanyListHeader(window)
            //VolunteerCompanyListHeader(window)
            //GuestRegisterationHeader(window)

        }
    }
}
