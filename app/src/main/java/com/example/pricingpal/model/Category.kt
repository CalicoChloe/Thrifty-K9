package com.example.pricingpal.model
/**
 * Data class for a category
 *
 * This class defines the category class properties.
 *
 * @property categoryName the name of a category.
 * @property items an array list of Item class objects
 *
 * @Abdoulie NJie
 **/

data class Category(val categoryId: Int, val categoryName: String, val items: ArrayList<Item>)