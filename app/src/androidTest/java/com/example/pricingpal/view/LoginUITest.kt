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

    @Test
    @Composable
    fun testLoginScreen() {
        // Mock NavController
        val navController = Mockito.mock(NavController::class.java)

        // Set up UI elements inside a Composable function
        composeTestRule.setContent {
            TestLoginScreen(navController)
        }

        // Verify UI elements
        composeTestRule.onNodeWithText("Login").assertExists()
        composeTestRule.onNodeWithText("Enter email").assertExists()
        composeTestRule.onNodeWithText("Enter password").assertExists()
        composeTestRule.onNodeWithText("Forgot Password?").assertExists()
        composeTestRule.onNodeWithText("Register Here").assertExists()

        // You can perform interactions and assertions as needed
    }

    @Composable
    private fun TestLoginScreen(navController: NavController) {
        val windowSize = rememberSize()
        LoginHeader(navController, windowSize) // Pass appropriate window size
    }
}
