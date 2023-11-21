package com.example.pricingpal.model
/*
 * Data class for a category
 *
 * This class defines the category class properties.
 *
 * @property category the name of a category.
 * @property item an array list of Item class objects
 *
 * @Abdoulie NJie
 */

data class Category(
    val categoryId: Int,
    val category: String,
    var item: ArrayList<Item>
)