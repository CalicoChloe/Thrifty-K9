package com.example.pricingpal.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SignUpVerified(
    navController: NavController,
    modifier: Modifier,
    onClick: () -> Unit = {},
    email: String,
    createdAt: String,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(text = "Email $email")
        Text(text = "Created at $createdAt")
        Text(text = "Thank you for verifying your account! \n Please press the continue button to navigate back to the app")
        Button(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            onClick = onClick
        ) {
            Text("Continue")
        }
    }
}