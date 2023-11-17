package com.example.pricingpal.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.pricingpal.R
import com.example.pricingpal.ui.theme.Anti_flash_white
import com.example.pricingpal.view.homepage.volunteer.volunteerCategoryList


/** This is a background that holds all the other screens because they share the same background.
 * This is what you will use to see the screens until the navigation is set up,
 * so please don't delete this file. Also when you do, make sure the surface background is still attach
 * to the screens, or it will be a blank background.
 *
 * Note: when you are looking at each screen, you can only import it one at a time. I don't why it does that.
 * Maybe is it just on my computer, but if it does happen that's why.*/
@Composable
fun background(){
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
        //startScreen()

        //login()
        //forgotPassword()
        //createPassword()

        //ownerOrGuess()
        //ownerRegistration()
        //guestCompanyList()
        //guestRegistration()

        //volunteerCompanyList()
        volunteerCategoryList()
        //volunteerItemList()

        //chooseList()
        //uploadCSV()
        //viewEditList()
        //addCategories()
        //viewEditItemList()
        //addItems()
        //addImage()
        //editCategoryList()
        //editItemList()

        //settings()
        //accountSetting()
        //changeEmail()
        //changePassword()

        //guestAccountSetting()
        //displaySetting()
        //accessibilitySetting()
    }
}
