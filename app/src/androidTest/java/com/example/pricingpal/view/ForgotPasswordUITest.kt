package com.example.pricingpal.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.unit.dp
import org.junit.Rule
import org.junit.Test

class ForgotPasswordUITest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private val windowSize = WindowSize(WindowType.Compact, WindowType.Compact)

    @Test
    fun forgotPasswordScreenContentDisplayed() {
        // Launch the Composable function
        composeTestRule.setContent {
            forgotPassword(paddingValues = PaddingValues(0.dp), windowSize)
        }

        // Verify if the text "Forgot Password?" is displayed
        composeTestRule.onNodeWithText("Forgot Password?").assertExists()

        // Verify if the text field for entering email is displayed
        composeTestRule.onNodeWithTag("emailTextField").assertExists()
    }

    @Test
    fun emailInputForgotPasswordTest() {
        // Launch the Composable function
        composeTestRule.setContent {
            emailInputForgotPassword()
        }

        // Verify if the text field is displayed
        composeTestRule.onNodeWithTag("Email").assertExists()

        // Enter text into the email text field
        composeTestRule.onNodeWithTag("Email").performTextInput("test@example.com")

        // Verify if the entered text is displayed
        composeTestRule.onNodeWithText("test@example.com").assertExists()
    }
}
