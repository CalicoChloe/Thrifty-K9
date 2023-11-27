package com.example.pricingpal.view

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pricingpal.R
import com.example.pricingpal.ui.theme.Periwinkle
import kotlinx.coroutines.delay

/** This is the launcher page that that will use a splash screen to load  before showing the rest of
 * the UI screens. The loading will be a little longer when connected to the the data loading
 *
 * @param navController allows functions to navigate to other functions
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 *
 * */
@Composable
fun AnimatedSlashScreen(navController: NavController, windowSize: WindowSize) {
    // the value that will allow the image to be animated
    val scale = remember { androidx.compose.animation.core.Animatable(0f) }
    //will scale the height of the image
    val imageHeight by remember(key1 = windowSize) { mutableStateOf(if (windowSize.width == WindowType.Compact) 400 else 520) }
    // will scale the width of the image
    val imageWidth by remember(key1 = windowSize) { mutableStateOf(if (windowSize.height == WindowType.Compact) 397 else 517) }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            /** tween Animation, will start the animation for the app logo */
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it) // how much the logo will scale up
                })
        )
        delay(2500) // delay the screen for 2 seconds until it navigates to the home screen
        navController.popBackStack() // will navigate completely out the app
        navController.navigate(route = Screen.HomeScreen.route)
    }
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Periwinkle
    ) {
        Image(
            painter = painterResource(id = R.drawable.paw_background),
            contentDescription = "Pictures of paws",
            //crops the image
            contentScale = ContentScale.Crop,
            // changes the opacity of the image
            alpha = 0.05F
        )

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.app_icon7),
                contentDescription = "Pictures of paws",
                modifier = Modifier
                    .scale(scale.value)
                    .width(imageHeight.dp)
                    .height(imageWidth.dp)
            )
        }
    }
}


//Just like this launcher, I hope you launch in the right direction for your success!