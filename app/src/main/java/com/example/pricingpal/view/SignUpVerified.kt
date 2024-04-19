package com.example.pricingpal.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pricingpal.R
import com.example.pricingpal.ui.theme.Anti_flash_white

@Composable
fun SignUpVerified(
    navController: NavController,
    modifier: Modifier,
    onClick: () -> Unit = {},
) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Anti_flash_white
    ) {
        Image(
            //Imports image from resource folder
            painter = painterResource(id = R.drawable.paw_background),
            //description of the image for accessibility
            contentDescription = "Pictures of paws",
            //crops the image
            contentScale = ContentScale.Crop,
            // changes the opacity of the image
            alpha = 0.1F
        )
        Column(modifier = modifier.fillMaxWidth()) {
            Text(text = "Thank you for verifying your account! \n Please press the continue button to navigate back to the app",
                color = Color.Black)
            Button(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                onClick = onClick
            ) {
                Text(text = "Continue", color = Color.Black)
            }
        }
    }
}