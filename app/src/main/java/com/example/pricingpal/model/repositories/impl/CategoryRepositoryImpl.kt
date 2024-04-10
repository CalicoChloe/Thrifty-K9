package com.example.pricingpal.model.repositories.impl

import com.example.pricingpal.model.Category
import com.example.pricingpal.model.datatransferobjects.CategoryDTO
import com.example.pricingpal.model.repositories.CategoryRepository
import com.example.pricingpal.model.repositories.OrganizationRepository
import io.github.jan.supabase.postgrest.Postgrest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Class: CategoryRepositoryImpl
 * @author Connor Murdock
 * @version 1
 * @written 11/20/2023
 * This class acts as an implemented version of the CategoryRepository Interface the app can use to interact with the database's Categories
 */
class CategoryRepositoryImpl @Inject constructor (
    private val postgrest: Postgrest,
    private val organizationRepository: OrganizationRepository
    ) : CategoryRepository {
    //This function will create a new category and push it to the database using the given Category object
    override suspend fun createCategory(category: Category): Boolean {
        TODO("Not yet implemented")
    }


    //Gets a list of all categories from the database
    override suspend fun getCategories(): List<CategoryDTO>? {

        return withContext(Dispatchers.IO) {
            val results = postgrest["category"].select {
                organizationRepository.getSelectedOrganization()?.organizationName?.let {
                    eq("items:organization_name",
                        it
                    )
                }
            }.decodeList<CategoryDTO>()
            results
        }
    }

    //Gets a specific category by its id value
    override suspend fun getCategory(id: Int): CategoryDTO {
        return withContext(Dispatchers.IO) {
            postgrest["category"].select {
                eq("id", id)
            }.decodeSingle<CategoryDTO>()
        }
    }

    //This function will remove a category from the database
    override suspend fun deleteCategory(id: Int) {
        TODO("Not yet implemented")
        //This function will remove a category from the database
    }

    //This function will update an existing category's name using the given String value that will be input by the user
    override suspend fun updateCategory(name: String) {
        TODO("Not yet implemented")
    }
}
