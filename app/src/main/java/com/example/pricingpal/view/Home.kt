package com.example.pricingpal.view

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pricingpal.R
import com.example.pricingpal.ui.theme.Anti_flash_white
import com.example.pricingpal.ui.theme.Cornflower_blue
import com.example.pricingpal.ui.theme.Periwinkle
import com.example.pricingpal.ui.theme.Persian_indigo

/** This is the home page. It is where the user would go after the launcher is done. They will be able to
 * navigate to the login, registration , and the volunteer section. We were only able to implement the
 * volunteer section, so the volunteer button is the only one active. There is also a button at the bottom of the page
 * that will navigate to the teams Gits docs
 *
 * @param windowSize an adjuster used to change scale of screens based on the user's device
 * @param navController allows functions to navigate to other functions
 *
 * @author Shianne Lesure
 * */
@Composable
fun StartScreen(navController: NavController, windowSize: WindowSize){
    // will scale the height of the button
    val buttonHeight by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 110 else 140) }
    // will scale the size of the text
    val textSize by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 35 else 50) }
    // will scale the space between the buttons
    val buttonSpacer by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 10 else 20) }
    // will scale the space between the volunteer button and web button
    val linkSpacer by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 182 else 170) }
    //will scale the space width between the card
    val cardSpacer by remember(key1 = windowSize) { mutableStateOf(if(windowSize.width == WindowType.Compact) 25 else 40) }
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
                .padding(start = cardSpacer.dp, end = cardSpacer.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .border(4.dp, color = Persian_indigo),
            shape = RectangleShape,
            elevation = CardDefaults.cardElevation(12.dp),
            colors = CardDefaults.cardColors(containerColor = Periwinkle)
        ) {
            /** This is the header of the pricing pal logo. */
            innerPricingBar()

            Column(
                modifier = Modifier
                    .padding(top = 90.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                //Login Button
                ElevatedButton(
                    onClick = { navController.navigate(Screen.LoginInScreen.route) },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Cornflower_blue),
                    elevation = ButtonDefaults.buttonElevation(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(buttonHeight.dp)
                        .padding(start = 25.dp, top = 15.dp, end = 25.dp, bottom = 15.dp)
                        .border(4.dp, color = Persian_indigo),

                    ) {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Login",
                        fontSize = textSize.sp,
                        color = Color.Black,
                    )
                }

                Spacer(modifier = Modifier.height(buttonSpacer.dp))

                // Register Button
                ElevatedButton(
                    onClick = { navController.navigate(Screen.RegisterScreen.route) },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Cornflower_blue),
                    elevation = ButtonDefaults.buttonElevation(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(buttonHeight.dp)
                        .padding(start = 25.dp, top = 15.dp, end = 25.dp, bottom = 15.dp)
                        .border(4.dp, color = Persian_indigo),

                    ) {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Register",
                        fontSize = textSize.sp,
                        color = Color.Black,
                    )
                }

                Spacer(modifier = Modifier.height(buttonSpacer.dp)) // allows space between buttons without having to do padding

                //Volunteer Button
                // This will navigate to the category list screen
                ElevatedButton(
                    onClick = { navController.navigate(Screen.OrganizationList.route) },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(Cornflower_blue),
                    elevation = ButtonDefaults.buttonElevation(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(buttonHeight.dp)
                        .padding(start = 25.dp, top = 15.dp, end = 25.dp, bottom = 15.dp)
                        .border(4.dp, color = Persian_indigo),

                    ) {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Volunteer",
                        fontSize = textSize.sp,
                        color = Color.Black,
                    )
                }
                Spacer(modifier = Modifier.height(linkSpacer.dp))
                WebButton()
            }
        }
    }
}

/** This is the button that will send the user to the pricing pal git docs
 * @author Shianne Lesure
 * */
@SuppressLint("SuspiciousIndentation")
@Composable
fun WebButton(){
    val context = LocalContext.current // will allow access for the app to run the website
    val webIntent: Intent = Intent(Intent.ACTION_VIEW, // will allow the use to see the website when app is running
        Uri.parse("https://calicochloe.github.io/Thrifty-K9/") ) // the link to the git docs

    ElevatedButton(
        onClick = { context.startActivity(webIntent) },
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(Cornflower_blue),
        elevation = ButtonDefaults.buttonElevation(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .border(4.dp, color = Persian_indigo),

        ) {
        Text(
            textAlign = TextAlign.Center,
            text = "About The App",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
        )
    }
}