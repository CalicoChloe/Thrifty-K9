package com.example.pricingpal

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Test navigation features
 *
 * @constructor Create empty Test navigation features
 */


@RunWith(AndroidJUnit4::class)
class TestNavigationFeatures {

    // declaration used to access compose rules
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun test_clicking_category() {
//        val csvp = CSVParser
//        val categories = csvp.PopulateData(CSVReader.readFile(thi, "testdata.csv"))
        composeTestRule.onNodeWithText("Appliances").performClick()
        composeTestRule.onNodeWithText("Toaster").assertExists() // price $10.00
        composeTestRule.onNodeWithText("Toaster").assertExists() // price $7.00
        composeTestRule.onNodeWithText("Vacuum").assertExists() // price $20.00
        composeTestRule.onNodeWithText("Sewing Machine").assertExists() // price $15.00
        composeTestRule.onNodeWithText("Steam Cleaner").assertExists() // price $20.00


//        composeTestRule.onNodeWithText("Jewelry").performClick()
//        composeTestRule.onNodeWithText("Necklace" + "$5.00").assertExists() // price $5.00
//        composeTestRule.onNodeWithText("Earrings").assertExists() // price $3.00
//        composeTestRule.onNodeWithText("Watches").assertExists() // price $10.00
//        composeTestRule.onNodeWithText("Rings").assertExists() // price $2.00
//        composeTestRule.onNodeWithText("Bracelets").assertExists() // price $5.00
//        composeTestRule.activity.onBackPressedDispatcher.onBackPressed()
//
//        composeTestRule.onNodeWithText("Electronics").performClick()
//        composeTestRule.onNodeWithText("Computers" + "$20.00").assertExists() // price $20.00
//        composeTestRule.onNodeWithText("Tablets").assertExists() // price $50.00
//        composeTestRule.onNodeWithText("Cell Phones").assertExists() // price $50.00
//        composeTestRule.onNodeWithText("Radios").assertExists() // price $20.00
//        composeTestRule.onNodeWithText("Cameras").assertExists() // price $20.00
//        composeTestRule.activity.onBackPressedDispatcher.onBackPressed()
//
//        composeTestRule.onNodeWithText("Toys & Games").performClick()
//        composeTestRule.onNodeWithText("Stuff Animals" + "$5.00").assertExists() // price $5.00
//        composeTestRule.onNodeWithText("Action Figure").assertExists() // price $5.00
//        composeTestRule.onNodeWithText("Board Games").assertExists() // price $10.00
//        composeTestRule.onNodeWithText("Puzzles").assertExists() // price $2.00
//        composeTestRule.onNodeWithText("Card Games").assertExists() // price $5.00
//        composeTestRule.activity.onBackPressedDispatcher.onBackPressed()
//
//        composeTestRule.onNodeWithText("Accessories").performClick()
//        composeTestRule.onNodeWithText("Hat" + "$4.00").assertExists() // price $4.00
//        composeTestRule.onNodeWithText("Purses").assertExists() // price $15.00
//        composeTestRule.onNodeWithText("Headphones").assertExists() // price $5.00
//        composeTestRule.onNodeWithText("Belts").assertExists() // price 5.00
//        composeTestRule.activity.onBackPressedDispatcher.onBackPressed()
//
//        composeTestRule.onNodeWithText("Furniture").performClick()
//        composeTestRule.onNodeWithText("Chair" + "$25.00").assertExists() // price $25.00
//        composeTestRule.onNodeWithText("Couch").assertExists() // price $80.00
//        composeTestRule.onNodeWithText("Tables").assertExists() // price $50.00
//        composeTestRule.onNodeWithText("Drawer").assertExists() // price $25.00
//        composeTestRule.onNodeWithText("Rugs").assertExists() // price $12.00
//        composeTestRule.activity.onBackPressedDispatcher.onBackPressed()
//
//        composeTestRule.onNodeWithText("Clothing").performClick()
//        composeTestRule.onNodeWithText("Women's Tops" + "$10.00").assertExists() // price $10.00
//        composeTestRule.onNodeWithText("Men's Tops").assertExists() // price $12.00
//        composeTestRule.onNodeWithText("Kid's Tops").assertExists() // price $7.00
//        composeTestRule.onNodeWithText("Women's Bottom").assertExists() // price $12.00
//        composeTestRule.onNodeWithText("Men's Bottom").assertExists() // price $15.00
//        composeTestRule.onNodeWithText("Kid's Bottom").assertExists() // price $10.00
//        composeTestRule.onNodeWithText("Women's Shoes").assertExists() // price $10.00
//        composeTestRule.onNodeWithText("Men's Shoes").assertExists() // price $13.00
//        composeTestRule.onNodeWithText("Kid's Shoes").assertExists() // price $8.00
//        composeTestRule.activity.onBackPressedDispatcher.onBackPressed()
    }

}