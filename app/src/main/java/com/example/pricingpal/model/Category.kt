package com.example.pricingpal.model
/*
 * @Abdoulie J NJie
 * This class works as a skeleton that has a primary constructor that has a parameter
 * that initializes a string that will hold the name of a category, and an array list that
 * will hold a list of items, which will contain item elements such as
 * the item's category, name, and price.
 */

data class Category(
    val category: String,
    val item: ArrayList<Item>
)