package com.example.pricingpal.model.repositories

import com.example.pricingpal.model.Item
import com.example.pricingpal.model.ItemDTO

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