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
import com.example.pricingpal.view.settings.guestaccount.guestAccountSetting


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
        //startScreen()    // Located within the homepage/ starter screen file

        //login()   //Located within the homepage/ login/ Login file
        //forgotPassword()  //Located within the homepage/ login/ forgot password file
        //createPassword()   //Located within the homepage/ login/ create password file

        //ownerOrGuess()     //Located within the homepage/ guest/ choose registration file
        //ownerRegistration()   //Located within the homepage/ guest/ owner registration file
        //guestCompanyList()   //Located within the homepage/ guest/ guest company list file
        //guestRegistration()   //Located within the homepage/ guest/ guest registration file

        //volunteerCompanyList()     //Located within the homepage/ volunteer/ volunteer search company file
        //volunteerCategoryList()     //Located within the homepage/ volunteer/ volunteer category list file
        //volunteerItemList()       //Located within the homepage/ volunteer/ volunteer item list file

        //chooseList()     //Located within the editing list/ edit upload file
        //uploadCSV()     //Located within the editing list/ upload CSV/  add csv file file
        //viewEditList()     //Located within the editing list/  make list/ edit list file
        //addCategories()     //Located within the editing list/ make list/ add category file
        //viewEditItemList()     //Located within the editing list/ make list/ edit item list file
        //addItems()     //Located within the editing list/ make list/ add item file
        //addImage()     //Located within the editing list/ make list/ add image file
        //editCategoryList()     //Located within the editing list/ make list/ owner category list file
        //editItemList()     //Located within the editing list/ make list/ owner item list file

        //settings()     //Located within the settings/ setting home page file
        //accountSetting()     //Located within the settings/ account/ account setting file
        //changeEmail()     //Located within the settings/ account/ change email file
        //changePassword()     //Located within the settings/ account/ change password file

        guestAccountSetting() //Located within the settings/ guest account/ guest account file
        //displaySetting()     //Located within the settings/ display setting file
        //accessibilitySetting()     //Located within the settings/ accessibility setting file
    }
}
