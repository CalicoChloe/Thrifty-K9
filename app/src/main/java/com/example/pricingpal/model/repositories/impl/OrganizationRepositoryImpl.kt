package com.example.pricingpal.model.repositories.impl

import com.example.pricingpal.model.datatransferobjects.OrganizationDTO
import com.example.pricingpal.model.repositories.OrganizationRepository
import io.github.jan.supabase.postgrest.Postgrest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Class: OrganizationRepositoryImpl
 * @author Abdoulie NJie
 * @version 1
 * @written 03/06/2024
 * This class acts as an implemented version of the Organization Repository Interface the app can use to interact with the database's Organizations
 */

class OrganizationRepositoryImpl @Inject constructor(
    private val postgrest: Postgrest
    ) : OrganizationRepository {
    override suspend fun deleteOrganization(organizationName: String) {
        TODO("Not yet implemented")
    }

    override suspend fun updateOrganization(organizationName: String) {
        TODO("Not yet implemented")
    }

    //Gets a list of all organizations from the database
    override suspend fun getOrganizations() : List<OrganizationDTO>? {
        return withContext(Dispatchers.IO) {
            val results = postgrest["organization"].select().decodeList<OrganizationDTO>()
            results
        }
    }

}