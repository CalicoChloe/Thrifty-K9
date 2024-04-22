package com.example.pricingpal.model.repositories.impl

import android.renderscript.Sampler
import com.example.pricingpal.model.Category
import com.example.pricingpal.model.datatransferobjects.CategoryDTO
import com.example.pricingpal.model.repositories.CategoryRepository
import com.example.pricingpal.model.repositories.OrganizationRepository
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.query.Columns
import io.github.jan.supabase.postgrest.query.FilterOperator
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

        val selectedOrganizationName = organizationRepository.getSelectedOrganization()?.organizationName

        if (selectedOrganizationName != null) {
            return withContext(Dispatchers.IO) {
                val columns = Columns.raw("""
                category_id,
                category_name
            """.trimIndent())
                val results = postgrest["category"]
                    .select (
                        columns = columns
                    ) {
                        filter(
                            "item.organization_name",
                            FilterOperator.EQ,
                            selectedOrganizationName
                        )
                    }
                    .decodeList<CategoryDTO>()

                results
            }
        } else {
            return null // Handle case where selected organization is null
        }
    }

    override suspend fun getCategory(id: Int): CategoryDTO {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCategory(id: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun updateCategory(name: String) {
        TODO("Not yet implemented")
    }
}
