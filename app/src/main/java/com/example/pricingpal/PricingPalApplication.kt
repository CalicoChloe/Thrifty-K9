package com.example.pricingpal

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Application class used to enable Hilt dependency injection throughout the
 * application's structure
 *
 * @author Abdoulie NJie
 */

@HiltAndroidApp
class PricingPalApplication: Application()