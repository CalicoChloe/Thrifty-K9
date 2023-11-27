package com.example.pricingpal.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

//Pricing pals color palette
val Persian_indigo = Color(0xFF27187E)
val Cornflower_blue = Color(0xFF758BFD)
val Periwinkle = Color(0xFFAEB8FE)
val Anti_flash_white = Color(0xFFF1F2F6)
val Uranian_Blue = Color(0xFFBDE0FE)


//Pricing pals dark color palette
val Dark_Mode_Background = Color(0xFF)
val Dark_Mode_Middle_Ground = Color(0xFF)
//val Periwinkle = Color(0xFFAEB8FE) //  This is for buttons
//val Anti_flash_white = Color(0xFFF1F2F6) // This is for the pricing pal logo
//val Uranian_Blue = Color(0xFFBDE0FE) // this is for the border


/**
 * I added the dark theme colors here because the dark theme is going to be for customize than by
 * default. The reason I say that because not every screen is going is going to have the same set up
 * for each color. For example above, I said that the color Periwinkle was going to be used for
 * buttons which is true for some screens, but there are other screens where the colors of the button
 * will be different.
 *
 * Because of this, you will have to implement something like this within the code.
 *
 * modifier = Modifier
 *      .background(if (isSystemInDarkTheme()) Dark_Mode_Background else Anti_flash_white)
 */