package com.example.pricingpal.model

/**
 * Data class for an item.
 *
 * This class defines the item class and its properties.
 *
 * @property category the category of this item.
 * @property name the name of this item.
 * @property price the price of this item.
 *
 * @author Chloe Jackson
 */

data class Item(val id: Int, val name: String,  val price: Double, val categoryId: Int, val organizationName: String) {}

