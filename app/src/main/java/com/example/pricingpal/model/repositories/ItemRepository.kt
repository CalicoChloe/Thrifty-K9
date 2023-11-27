package com.example.pricingpal.model.repositories

import com.example.pricingpal.model.Item
import com.example.pricingpal.model.datatransferobjects.ItemDTO

/**
 * Interface: ItemRepository
 * @author Connor Murdock
 * @version 1
 * @written 11/20/2023
 * This interface is a repository of functions that are required to interact with Items from the database
 */
interface ItemRepository {
    //Create or get a list of all Items or a single Item
    suspend fun createItem(item: Item): Boolean
    suspend fun getItems(categoryID: Int): List<ItemDTO>?
    suspend fun getItem(id: Int): ItemDTO

    //Delete an Item
    suspend fun deleteItem(id: Int)

    //Update an Item
    suspend fun updateItem(categoryID: Int, name: String, price: Float)
}