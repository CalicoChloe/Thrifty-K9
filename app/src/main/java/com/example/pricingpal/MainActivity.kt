package com.example.pricingpal
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.pricingpal.ui.theme.PricingpalTheme
import com.example.pricingpal.view.rememberSize
import com.example.pricingpal.viewmodel.CategoryViewModel
import com.example.pricingpal.viewmodel.OrganizationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val organizationViewModel: OrganizationViewModel by viewModels()
            //Initialize the viewmodel
            val categoryViewModel: CategoryViewModel by viewModels()
            // Initialize the window
            val window = rememberSize()

            PricingpalTheme {
                PricingPalApp(windowSize = window)
            }
        }
    }
}
