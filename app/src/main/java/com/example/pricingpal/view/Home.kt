package com.example.pricingpal.view

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pricingpal.R
import com.example.pricingpal.ui.theme.Anti_flash_white
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo
import com.example.pricingpal.ui.theme.Uranian_Blue
import com.example.pricingpal.view.repetitivefunctions.innerPricingBar
import com.example.pricingpal.view.settings.guestaccount.guestAccountSetting

@Composable
fun startScreen(navController: NavController){
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
        Card(
            modifier = Modifier
                .padding(start = 40.dp, end = 40.dp)
                .fillMaxSize()
                .border(4.dp, color = Persian_indigo),
            shape = RectangleShape,
            elevation = CardDefaults.cardElevation(12.dp),
            colors = CardDefaults.cardColors(containerColor = Periwinkle)
        ) {
            /** This is the header of the pricing pal logo. It is function is within the repetitive folder
             * under Header*/
            innerPricingBar()

            Column(
                modifier = Modifier
                    .padding(top = 90.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                //Login Button
                ElevatedButton(
                    onClick = { /*TODO*/ },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Cornflower_blue),
                    elevation = ButtonDefaults.buttonElevation(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp)
                        .padding(start = 25.dp, top = 15.dp, end = 25.dp, bottom = 15.dp)
                        .border(4.dp, color = Persian_indigo),

                    ) {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Login",
                        fontSize = 50.sp,
                        color = Color.Black,
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Register Button
                ElevatedButton(
                    onClick = { /*TODO*/ },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Cornflower_blue),
                    elevation = ButtonDefaults.buttonElevation(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp)
                        .padding(start = 25.dp, top = 15.dp, end = 25.dp, bottom = 15.dp)
                        .border(4.dp, color = Persian_indigo),

                    ) {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Register",
                        fontSize = 50.sp,
                        color = Color.Black,
                    )
                }

                Spacer(modifier = Modifier.height(20.dp)) // allows space between buttons without having to do padding

                //Volunteer Button
                ElevatedButton(
                    onClick = { navController.navigate("category_list") },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Cornflower_blue),
                    elevation = ButtonDefaults.buttonElevation(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp)
                        .padding(start = 25.dp, top = 15.dp, end = 25.dp, bottom = 15.dp)
                        .border(4.dp, color = Persian_indigo),

                    ) {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Volunteer",
                        fontSize = 50.sp,
                        color = Color.Black,
                    )
                }
                Spacer(modifier = Modifier.height(170.dp))
                volunteerHome()
            }
        }
    }
}

@Composable
fun volunteerHome(){
    val context = LocalContext.current
    val webIntent: Intent = Intent(Intent.ACTION_VIEW,
        Uri.parse("https://calicochloe.github.io/Thrifty-K9/") )

        ElevatedButton(
            onClick = { context.startActivity(webIntent) },
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(Uranian_Blue),
            elevation = ButtonDefaults.buttonElevation(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                //.padding(start = 70.dp, top = 15.dp, end = 70.dp, bottom = 15.dp)
                .border(4.dp, color = Persian_indigo),

            ) {
            Text(
                textAlign = TextAlign.Center,
                text = "About The App",
                fontSize = 30.sp,
                color = Color.Black,
            )
        }

}