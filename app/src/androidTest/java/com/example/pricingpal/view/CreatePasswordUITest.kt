package com.example.pricingpal.view

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.NavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito

@RunWith(AndroidJUnit4::class)
class CreatePasswordUITest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testCreatePasswordScreen() {
        val navController = Mockito.mock(NavController::class.java)

        val windowSize = WindowSize(WindowType.Compact, WindowType.Compact) // Adjust the window size as needed

        composeTestRule.setContent {
            CreatePasswordHeader(windowSize)
        }

        // Verify UI elements
        composeTestRule.onNodeWithText("Create Password").assertExists()
        composeTestRule.onNodeWithText("Enter a new password and confirm the new password below").assertExists()
        composeTestRule.onNodeWithText("Enter password").assertExists()
        composeTestRule.onNodeWithText("Enter confirm new password").assertExists()
        composeTestRule.onNodeWithText("Why?").assertExists()
        composeTestRule.onNodeWithText("Password reset").assertDoesNotExist() // Ensure the snackbar is not visible initially

        // You can perform interactions and assertions as needed
    }
}
