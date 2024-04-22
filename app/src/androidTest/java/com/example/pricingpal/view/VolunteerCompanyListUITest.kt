package com.example.pricingpal.view

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.NavController
import org.junit.Rule
import org.junit.Test

class VolunteerCompanyListUITest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun volunteerCompanyListHeader_displayed() {
        composeTestRule.setContent {
            VolunteerCompanyListHeader(WindowSize(WindowType.Compact, WindowType.Compact))
        }

        // Verify the presence of the back arrow icon
        composeTestRule.onNodeWithContentDescription("Back arrow Button").assertExists()
    }

    @Test
    fun volunteerSearchBarCompany_displayed() {
        composeTestRule.setContent {
            volunteerSearchBarCompany(WindowSize(WindowType.Compact, WindowType.Compact))
        }

        // Verify the presence of the search icon
        composeTestRule.onNodeWithContentDescription("Search Icon").assertExists()
    }

    // Add similar tests for other Composable functions

    // Example:
    @Test
    fun volunteerFavoriteCompanyName_displayed() {
        composeTestRule.setContent {
            volunteerFavoriteCompanyName(WindowSize(WindowType.Compact, WindowType.Compact))
        }

        // Verify the presence of the organization name text
        composeTestRule.onNodeWithText("Organization Name").assertExists()
    }
}
