package com.example.pricingpal.model.repositories.impl

import com.example.pricingpal.model.datatransferobjects.OrganizationDTO
import com.example.pricingpal.model.repositories.OrganizationRepository
import io.github.jan.supabase.postgrest.Postgrest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class OrganizationRepositoryImpl @Inject constructor(
    private val postgrest: Postgrest
    ) : OrganizationRepository {
    override suspend fun getAllOrganizations(): List<OrganizationDTO> {
        return withContext(Dispatchers.IO) {
            val results = postgrest["organization"].select().decodeList<OrganizationDTO>()
            results
        }
    }

    override suspend fun deleteOrganization(organizationName: String) {
        TODO("Not yet implemented")
    }

    override suspend fun updateOrganization(organizationName: String) {
        TODO("Not yet implemented")
    }

}