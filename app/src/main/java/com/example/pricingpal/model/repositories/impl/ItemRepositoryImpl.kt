package com.example.pricingpal.model.repositories.impl

import com.example.pricingpal.model.Item
import com.example.pricingpal.model.datatransferobjects.ItemDTO
import com.example.pricingpal.model.repositories.ItemRepository
import io.github.jan.supabase.postgrest.Postgrest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Class: ItemRepositoryImpl
 * @author Connor Murdock
 * @version 1
 * @written 11/20/2023
 * This class acts as an implemented version of the ItemRepository Interface the app can use to interact with the database's Items
 */
class ItemRepositoryImpl@Inject constructor(
    private val postgrest: Postgrest
) : ItemRepository {
    //This function will create a new item and push it to the database using the given Item object
    override suspend fun createItem(item: Item): Boolean {
        TODO("Not yet implemented")
    }

    //Gets a list of all items that belong to a specific categoryID value
    override suspend fun getItems(categoryID: Int): List<ItemDTO>? {
        return withContext(Dispatchers.IO) {
            val results = postgrest["item"].select() {
                eq("category_id", categoryID)
            }.decodeList<ItemDTO>()
            results
        }
    }

    //Gets a specific item by its id value
    override suspend fun getItem(id: Int): ItemDTO {
        return withContext(Dispatchers.IO) {
            postgrest["item"].select {
                eq("id", id)
            }.decodeSingle<ItemDTO>()
        }
    }

    //This function will remove an item from the database
    override suspend fun deleteItem(id: Int) {
        TODO("Not yet implemented")
    }

    //This function will update an existing item by replacing the categoryID, name, or price (or any combination of the above)
    override suspend fun updateItem(categoryID: Int, name: String, price: Float) {
        TODO("Not yet implemented")
    }
}