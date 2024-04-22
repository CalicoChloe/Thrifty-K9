package com.example.pricingpal.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.compose.rememberNavController
import org.junit.Rule
import org.junit.Test

class StartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private val windowSize = WindowSize(WindowType.Compact, WindowType.Compact)

    @Test
    fun startScreen_contentDisplayed() {
        composeTestRule.setContent {
            StartScreen(navController = rememberNavController(), windowSize)
        }

        // Verify the presence of the Login button
        composeTestRule.onNodeWithText("Login").assertExists()

        // Verify the presence of the Register button
        composeTestRule.onNodeWithText("Register").assertExists()

        // Verify the presence of the Volunteer button
        composeTestRule.onNodeWithText("Volunteer").assertExists()
    }

    @Composable
    @Test
    fun startScreen_navigateToLogin() {
        val navController = rememberNavController()
        composeTestRule.setContent {
            StartScreen(navController = navController, windowSize)
        }

        // Click on the Login button
        composeTestRule.onNodeWithText("Login").performClick()

        // Verify if navigation to the Login screen occurred
        assert(navController.currentDestination?.route == Screen.LoginInScreen.route)
    }

    @Composable
    @Test
    fun startScreen_navigateToRegister() {
        val navController = rememberNavController()
        composeTestRule.setContent {
            StartScreen(navController = navController, windowSize)
        }

        // Click on the Register button
        composeTestRule.onNodeWithText("Register").performClick()

        // Verify if navigation to the Register screen occurred
        assert(navController.currentDestination?.route == Screen.RegisterScreen.route)
    }

    @Composable
    @Test
    fun startScreen_navigateToVolunteer() {
        val navController = rememberNavController()
        composeTestRule.setContent {
            StartScreen(navController = navController, windowSize)
        }

        // Click on the Volunteer button
        composeTestRule.onNodeWithText("Volunteer").performClick()

        // Verify if navigation to the Volunteer screen occurred
        assert(navController.currentDestination?.route == Screen.CategoryList.route)
    }
}
