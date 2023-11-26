package com.example.pricingpal.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration

/** This file holds the UI scaling. The look of the app will change base of the size of the device as
 * well as whether the device is in portrait or landscape.
 *
 *@author Shianne Lesure
 *
 * */
data class WindowSize(
    val width: WindowType,
    val height: WindowType
)

enum class WindowType {
    Compact, // basically the size of a phone
    Medium, // basically the size of a tablet
    Expanded // basically the size of a computer
}


/**
 *  This function will return the width and height of the window size the user is currently on.
 *  @author Shianne Lesure
 */
@Composable
fun rememberSize(): WindowSize {
    val configuration = LocalConfiguration.current // change UI in real time
    val screenWidth by remember (key1 = configuration){
        mutableStateOf(configuration.screenWidthDp) // will change the width of UI in real time
    }
    val screenHeight by remember (key1 = configuration){
        mutableStateOf(configuration.screenHeightDp) // will change height of UI in real time
    }
    return WindowSize(
        width = getScreenWidth(screenWidth),
        height = getScreenHeight(screenHeight)
    )
}

fun getScreenWidth(width: Int): WindowType = when {
    width < 600 -> WindowType.Compact // if device's width is bigger than 600.dp
    width < 840 -> WindowType.Medium // if device's width is bigger than 840.dp
    else -> WindowType.Expanded
}

fun getScreenHeight(height: Int): WindowType = when {
    height < 480 -> WindowType.Compact // if device's height is bigger than 480.dp
    height < 900 -> WindowType.Medium // if device's height is bigger than 900. dp
    else -> WindowType.Expanded
}