package com.example.pricingpal.model.repositories.impl

import com.example.pricingpal.model.Category
import com.example.pricingpal.model.dto.CategoryDTO
import com.example.pricingpal.model.repositories.CategoryRepository
import io.github.jan.supabase.postgrest.Postgrest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor (
    private val postgrest: Postgrest
    // private val storage: Storage,
    ) : CategoryRepository {
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

    // Delete a Category
    override suspend fun deleteCategory(id: Int) {
        TODO("Not yet implemented")
    }

    // Update a Category
    override suspend fun updateCategory(name: String) {
        TODO("Not yet implemented")
    }
}
