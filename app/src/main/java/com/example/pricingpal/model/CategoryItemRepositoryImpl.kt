package com.example.pricingpal.model

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CategoryItemRepositoryImpl @Inject constructor(
    private val supabase: SupabaseClient
) : CategoryItemRepository {
    //Create or get a list of all Items or a single Item
    override suspend fun createItem(item: Item): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getItems(categoryID: Int): List<ItemDTO>? {
        return withContext(Dispatchers.IO) {
            val results = supabase.postgrest["item"].select() {
                eq("category_id", categoryID)
            }.decodeList<ItemDTO>()
            results
        }
    }

    override suspend fun getItem(id: Int): ItemDTO {
        return withContext(Dispatchers.IO) {
            supabase.postgrest["item"].select {
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
            val results = supabase.postgrest["category"].select().decodeList<CategoryDTO>()
            results
        }
    }

    override suspend fun getCategory(id: Int): CategoryDTO {
        return withContext(Dispatchers.IO) {
            supabase.postgrest["category"].select {
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