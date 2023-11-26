package com.example.pricingpal

import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipeUp
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.pricingpal.view.CATEGORY_NAMES
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Test navigation features using the data from the testdata.csv file
 * As well as the UI design implemented before SupaBase backend support added to the app
 *
 * @constructor Create empty Test navigation features
 */


@RunWith(AndroidJUnit4::class)
class TestNavigationFeatures {

    // declaration used to access compose rules
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun test_clicking_categories() {
        composeTestRule.onNodeWithText("Volunteer").performClick()
        // performs click on the category name according to the text
        composeTestRule.onNodeWithText("Appliances").performClick()
        // asserts that the following information is present on the UI
        composeTestRule.onNodeWithText("Blender").assertExists()
        composeTestRule.onNodeWithText("\$10.00").assertExists()
        // asserts that the following information is present on the UI
        composeTestRule.onNodeWithText("Toaster").assertExists()
        composeTestRule.onNodeWithText("\$7.00").assertExists()
        // asserts that the following information is present on the UI
        composeTestRule.onNodeWithText("Vacuum").assertExists()
        composeTestRule.onAllNodesWithText("\$20.00")[0].assertExists()
        // asserts that the following information is present on the UI
        composeTestRule.onNodeWithText("Sewing Machine").assertExists()
        composeTestRule.onNodeWithText("\$15.00").assertExists()
        // asserts that the following information is present on the UI
        composeTestRule.onNodeWithText("Steam Cleaner").assertExists()
        composeTestRule.onAllNodesWithText("\$20.00")[1].assertExists()
        // clicks the back button located on the android device
        composeTestRule.activityRule.scenario.onActivity { activity ->
            activity.onBackPressedDispatcher.onBackPressed()
        }
        // waits until the UI is idle
        composeTestRule.waitForIdle()

        composeTestRule.onNodeWithText("Jewelry").performClick()

        composeTestRule.onNodeWithText("Necklace").assertExists()
        composeTestRule.onAllNodesWithText("\$5.00")[0].assertExists()

        composeTestRule.onNodeWithText("Earrings").assertExists()
        composeTestRule.onNodeWithText("\$3.00")

        composeTestRule.onNodeWithText("Watches").assertExists()
        composeTestRule.onNodeWithText("\$10.00")

        composeTestRule.onNodeWithText("Rings").assertExists()
        composeTestRule.onNodeWithText("\$2.00")

        composeTestRule.onNodeWithText("Bracelets").assertExists()
        composeTestRule.onAllNodesWithText("\$5.00")[1].assertExists()

        composeTestRule.activityRule.scenario.onActivity { activity ->
            activity.onBackPressedDispatcher.onBackPressed()
        }
        composeTestRule.waitForIdle()

        composeTestRule.onNodeWithText("Electronics").performClick()

        composeTestRule.onNodeWithText("Computers").assertExists()
        composeTestRule.onAllNodesWithText("\$20.00")[0].assertExists()

        composeTestRule.onNodeWithText("Tablets").assertExists()
        composeTestRule.onAllNodesWithText("\$50.00")[0].assertExists()

        composeTestRule.onNodeWithText("Cell Phones").assertExists()
        composeTestRule.onAllNodesWithText("\$50.00")[1].assertExists()

        composeTestRule.onNodeWithText("Radios").assertExists()
        composeTestRule.onAllNodesWithText("\$20.00")[1].assertExists()

        composeTestRule.onNodeWithText("Cameras").assertExists()
        composeTestRule.onAllNodesWithText("\$20.00")[2].assertExists()

        composeTestRule.activityRule.scenario.onActivity { activity ->
            activity.onBackPressedDispatcher.onBackPressed()
        }
        composeTestRule.waitForIdle()

        composeTestRule.onNodeWithText("Toys & Games").performClick()

        composeTestRule.onNodeWithText("Stuff Animals").assertExists()
        composeTestRule.onAllNodesWithText("\$5.00")[0].assertExists()

        composeTestRule.onNodeWithText("Action Figure").assertExists()
        composeTestRule.onAllNodesWithText("\$5.00")[1].assertExists()

        composeTestRule.onNodeWithText("Board Games").assertExists()
        composeTestRule.onAllNodesWithText("\$10.00")[0].assertExists()

        composeTestRule.onNodeWithText("Puzzles").assertExists()
        composeTestRule.onAllNodesWithText("\$10.00")[1].assertExists()

        composeTestRule.onNodeWithText("Card Games").assertExists()
        composeTestRule.onAllNodesWithText("\$5.00")[2].assertExists()

        composeTestRule.activityRule.scenario.onActivity { activity ->
            activity.onBackPressedDispatcher.onBackPressed()
        }
        // used to perform a swipe up action on the device
        composeTestRule.onNodeWithTag(CATEGORY_NAMES).performTouchInput { swipeUp() }
        composeTestRule.waitForIdle()


        composeTestRule.onNodeWithText("Accessories").performClick()

        composeTestRule.onNodeWithText("Hats").assertExists()
        composeTestRule.onNodeWithText("\$4.00").assertExists()

        composeTestRule.onNodeWithText("Purses").assertExists()
        composeTestRule.onNodeWithText("\$15.00").assertExists()

        composeTestRule.onNodeWithText("Headphones").assertExists()
        composeTestRule.onAllNodesWithText("\$5.00")[0].assertExists()

        composeTestRule.onNodeWithText("Belts").assertExists()
        composeTestRule.onAllNodesWithText("\$5.00")[1].assertExists()

        composeTestRule.activityRule.scenario.onActivity { activity ->
            activity.onBackPressedDispatcher.onBackPressed()
        }
        composeTestRule.waitForIdle()

        composeTestRule.onNodeWithText("Furniture").performClick()

        composeTestRule.onNodeWithText("Chair").assertExists()
        composeTestRule.onAllNodesWithText("\$25.00")[0].assertExists()

        composeTestRule.onNodeWithText("Couch").assertExists()
        composeTestRule.onNodeWithText("\$80.00").assertExists()

        composeTestRule.onNodeWithText("Table").assertExists()
        composeTestRule.onNodeWithText("\$50.00").assertExists()

        composeTestRule.onNodeWithText("Drawer").assertExists()
        composeTestRule.onAllNodesWithText("\$25.00")[1].assertExists()

        composeTestRule.onNodeWithText("Rugs").assertExists()
        composeTestRule.onNodeWithText("\$12.00").assertExists()

        composeTestRule.activityRule.scenario.onActivity { activity ->
            activity.onBackPressedDispatcher.onBackPressed()
        }
        composeTestRule.waitForIdle()

        composeTestRule.onNodeWithText("Clothing").performClick()

        composeTestRule.onNodeWithText("Women's Tops").assertExists()
        composeTestRule.onAllNodesWithText("\$10.00")[0].assertExists()

        composeTestRule.onNodeWithText("Men's Tops").assertExists()
        composeTestRule.onAllNodesWithText("\$12.00")[0].assertExists()

        composeTestRule.onNodeWithText("Kid's Tops").assertExists()
        composeTestRule.onNodeWithText("\$7.00").assertExists()

        composeTestRule.onNodeWithText("Women's Bottom").assertExists()
        composeTestRule.onAllNodesWithText("\$12.00")[1].assertExists()

        composeTestRule.onNodeWithText("Men's Bottom").assertExists()
        composeTestRule.onNodeWithText("\$15.00").assertExists()

        composeTestRule.onNodeWithText("Kid's Bottom").assertExists()
        composeTestRule.onAllNodesWithText("\$10.00")[1].assertExists()

        composeTestRule.onNodeWithText("Women's Shoes").assertExists()
        composeTestRule.onAllNodesWithText("\$10.00")[2].assertExists()

        composeTestRule.onNodeWithText("Men's Shoes").assertExists()
        composeTestRule.onNodeWithText("\$13.00").assertExists()

        composeTestRule.onNodeWithText("Kid's Shoes").assertExists()
        composeTestRule.onNodeWithText("\$8.00").assertExists()

        composeTestRule.activityRule.scenario.onActivity { activity ->
            activity.onBackPressedDispatcher.onBackPressed()
        }
        composeTestRule.activityRule.scenario.onActivity { activity ->
            activity.onBackPressedDispatcher.onBackPressed()
        }
    }

    @Test
    fun test_custom_back_button(){
        // val used to reference the back button created for the apps navigation
        val iconButton = composeTestRule.onNode(hasTestTag(BACK_BUTTON), useUnmergedTree = true)

        composeTestRule.onNodeWithText("Volunteer").performClick()
        // performs click on the category name according to the text
        composeTestRule.onNodeWithText("Appliances").performClick()
        // performs click on the custom back button
        iconButton.performClick()
        // waits until the UI is idle
        composeTestRule.waitForIdle()

        composeTestRule.onNodeWithText("Jewelry").performClick()
        iconButton.performClick()
        composeTestRule.waitForIdle()

        composeTestRule.onNodeWithText("Electronics").performClick()
        iconButton.performClick()
        composeTestRule.waitForIdle()

        composeTestRule.onNodeWithText("Toys & Games").performClick()
        iconButton.performClick()
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithTag(CATEGORY_NAMES).performTouchInput { swipeUp() }

        composeTestRule.onNodeWithText("Accessories").performClick()
        iconButton.performClick()
        composeTestRule.waitForIdle()

        composeTestRule.onNodeWithText("Furniture").performClick()
        iconButton.performClick()
        composeTestRule.waitForIdle()

        composeTestRule.onNodeWithText("Clothing").performClick()
        iconButton.performClick()

    }

}
