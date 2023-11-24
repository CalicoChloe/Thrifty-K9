package com.example.pricingpal.model.repositories

import com.example.pricingpal.model.Category
import com.example.pricingpal.model.dto.CategoryDTO

interface CategoryRepository {
    //Create or get a list of all Categories or a single Category
    suspend fun createCategory(category: Category): Boolean
    suspend fun getCategories(): List<CategoryDTO>?
    suspend fun getCategory(id: Int): CategoryDTO

    // Delete a Category
    suspend fun deleteCategory(id: Int)

    // Update a Category
    suspend fun updateCategory(name: String)
}