package com.example.pricingpal.model
/**
 * Class: Category
 * @author Abdoulie NJie
 * @version 1
 * @written 11/10/2023
 * @property category the name of a category.
 * @property item an array list of Item class objects
 * This data class acts as an interface to transfer data of our Category objects to and from the database.
 *
 */

data class Category(val category: String, val item: ArrayList<Item>)