package com.example.pricingpal.model

interface CategoryItemRepository {
    //Create or get a list of all Items or a single Item
    suspend fun createItem(item: Item): Boolean
    suspend fun getItems(categoryID: Int): List<ItemDTO>?
    suspend fun getItem(id: Int): ItemDTO

    //Create or get a list of all Categories or a single Category
    suspend fun createCategory(category: Category): Boolean
    suspend fun getCategories(): List<CategoryDTO>?
    suspend fun getCategory(id: Int): CategoryDTO

    //Delete an Item or Category
    suspend fun deleteItem(id: Int)
    suspend fun deleteCategory(id: Int)

    //Update an Item or Category
    suspend fun updateItem(categoryID: Int, name: String, price: Float)
    suspend fun updateCategory(name: String)
}