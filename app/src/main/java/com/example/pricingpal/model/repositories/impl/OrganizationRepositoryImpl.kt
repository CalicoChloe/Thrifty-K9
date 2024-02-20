package com.example.pricingpal.model.repositories.impl

import com.example.pricingpal.model.repositories.OrganizationRepository
import io.github.jan.supabase.postgrest.Postgrest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Class: OrganizationRepositoryImpl
 * @author Abdoulie NJie
 * @author Shianne Lesure
 * @written 2/19/2024
 * This class acts as an implemented version of the OrganizationRepository Interface the app can use to interact with the database's Organizations
 */
class OrganizationRepositoryImpl @Inject constructor(private val postgrest: Postgrest) : OrganizationRepository {
    // This function will delete an organization from the database
    override suspend fun deleteOrganization(organizationName: String) {
        withContext(Dispatchers.IO){
            postgrest.from("user").delete{eq("organization_name", organizationName)}
        }
    }

    // This function will update an an existing organization through the organization name.
    override suspend fun updateOrganization(organizationName: String) {
        withContext(Dispatchers.IO) {
            postgrest.from("user").update({
                set("organization_name", organizationName)
            })
        }
    }

}