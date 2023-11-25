package com.example.pricingpal.view

import android.view.animation.OvershootInterpolator
import android.window.SplashScreenView
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pricingpal.R
import com.example.pricingpal.ui.theme.Periwinkle
import kotlinx.coroutines.delay
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.pricingpal.ui.theme.Persian_indigo
import com.example.pricingpal.ui.theme.Uranian_Blue

@Composable
fun AnimatedSlashScreen(navController: NavController){
    val scale = remember { androidx.compose.animation.core.Animatable(0f) }
    var startAnimation by remember { mutableStateOf(false) }
    val animWord = animateFloatAsState(
        targetValue = if(startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 4000),
        label = "Animating Logo",
    )
    LaunchedEffect(key1 = true){
        scale.animateTo(
            targetValue = 0.7f,
            // tween Animation
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                }))
        startAnimation = true
        delay(5000)
        navController.popBackStack()
        navController.navigate("starter_screen")
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
            alpha = 0.1F
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
                    .width(520.dp)
                    .height(517.dp)
                //.shadow(elevation = 12.dp, RoundedCornerShape(55.dp)),
            )
            Text(
                text = "Pricing Pals",
                textAlign = TextAlign.Center,
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .alpha(animWord.value)
            )

        }
    }
}
