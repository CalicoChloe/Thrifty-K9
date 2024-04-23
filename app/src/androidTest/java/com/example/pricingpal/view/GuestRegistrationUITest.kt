package com.example.pricingpal.view

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class GuestRegistrationUITest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private val windowSize = WindowSize(WindowType.Compact, WindowType.Compact)

    @Test
    fun guestOrganizationName_Displayed() {
        // Launch the Composable function
        composeTestRule.setContent {
            GuestRegisterationHeader(windowSize)
        }

        // Verify if the organization name text is displayed
        composeTestRule.onNodeWithText("Organization Name").assertExists()
    }

    @Test
    fun usernameInputGuest_Displayed() {
        // Launch the Composable function
        composeTestRule.setContent {
            usernameInputGuest()
        }

        // Verify if the username text field is displayed
        composeTestRule.onNodeWithText("Enter name").assertExists()
    }

    @Test
    fun emailInputGuest_Displayed() {
        // Launch the Composable function
        composeTestRule.setContent {
            emailInputGuest()
        }

        // Verify if the email text field is displayed
        composeTestRule.onNodeWithText("Enter email").assertExists()
    }

    @Test
    fun passwordInputGuest_Displayed() {
        // Launch the Composable function
        composeTestRule.setContent {
            passwordInputGuest()
        }

        // Verify if the password text field is displayed
        composeTestRule.onNodeWithText("Enter password").assertExists()
    }


    @Test
    fun signSnackBarGuest_Displayed() {
        // Launch the Composable function
        composeTestRule.setContent {
            signSnackBarGuest(windowSize)
        }

        // Verify if the sign up button is displayed
        composeTestRule.onNodeWithText("Sign Up").assertExists()
    }
}
