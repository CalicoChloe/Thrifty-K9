package com.example.pricingpal.model.repositories

import com.example.pricingpal.model.Item
import com.example.pricingpal.model.ItemDTO
import io.github.jan.supabase.postgrest.Postgrest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ItemRepositoryImpl@Inject constructor(
    private val postgrest: Postgrest
) : ItemRepository {
    //Create or get a list of all Items or a single Item
    override suspend fun createItem(item: Item): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getItems(categoryID: Int): List<ItemDTO>? {
        return withContext(Dispatchers.IO) {
            val results = postgrest["item"].select() {
                eq("category_id", categoryID)
            }.decodeList<ItemDTO>()
            results
        }
    }

    override suspend fun getItem(id: Int): ItemDTO {
        return withContext(Dispatchers.IO) {
            postgrest["item"].select {
                eq("id", id)
            }.decodeSingle<ItemDTO>()
        }
    }
    //Delete an Item
    override suspend fun deleteItem(id: Int) {
        TODO("Not yet implemented")
    }

    //Update an Item or Category
    override suspend fun updateItem(categoryID: Int, name: String, price: Float) {
        TODO("Not yet implemented")
    }


}