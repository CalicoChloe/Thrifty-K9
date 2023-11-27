package com.example.pricingpal

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 *
 * Application class used to integrate Dagger Hilt into the application
 * The @HiltAndAndroidApp annotation triggers the generation of Dagger components
 * and sets up the infrastructure for dependency injection throughout the application's lifecycle.
 *
 * @author Abdoulie NJie
 */
@HiltAndroidApp
class PricingPalApplication : Application(){
  
}