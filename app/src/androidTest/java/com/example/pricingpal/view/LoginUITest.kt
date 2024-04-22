package com.example.pricingpal.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.NavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito

@RunWith(AndroidJUnit4::class)
class LoginUITest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Composable
    @Test
    fun testLoginScreen() {
        // Mock NavController
        val navController = Mockito.mock(NavController::class.java)
        val windowSize = rememberSize()
        // Launch the Login screen
        composeTestRule.setContent {
            LoginHeader(navController, windowSize) // Pass appropriate window size
        }

        // Verify UI elements
        composeTestRule.onNodeWithText("Login").assertExists()
        composeTestRule.onNodeWithText("Enter email").assertExists()
        composeTestRule.onNodeWithText("Enter password").assertExists()
        composeTestRule.onNodeWithText("Forgot Password?").assertExists()
        composeTestRule.onNodeWithText("Register Here").assertExists()

        // You can perform interactions and assertions as needed
    }
}
