package com.example.pricingpal.model

import com.example.pricingpal.model.dto.CategoryDTO
import com.example.pricingpal.model.dto.ItemDTO
import io.github.jan.supabase.postgrest.Postgrest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CategoryItemRepositoryImpl @Inject constructor(
    private val postgrest: Postgrest
   // private val storage: Storage,
) : CategoryItemRepository {
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


    //Create or get a list of all Categories or a single Category
    override suspend fun createCategory(category: Category): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getCategories(): List<CategoryDTO>? {
        return withContext(Dispatchers.IO) {
            val results = postgrest["category"].select().decodeList<CategoryDTO>()
            results
        }
        
    }

    override suspend fun getCategory(id: Int): CategoryDTO {
        return withContext(Dispatchers.IO) {
            postgrest["category"].select {
                eq("id", id)
            }.decodeSingle<CategoryDTO>()
        }
    }


    //Delete an Item or Category
    override suspend fun deleteItem(id: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCategory(id: Int) {
        TODO("Not yet implemented")
    }


    //Update an Item or Category
    override suspend fun updateItem(categoryID: Int, name: String, price: Float) {
        TODO("Not yet implemented")
    }

    override suspend fun updateCategory(name: String) {
        TODO("Not yet implemented")
    }
}