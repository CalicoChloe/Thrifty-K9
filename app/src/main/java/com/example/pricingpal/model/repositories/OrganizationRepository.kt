package com.example.pricingpal.model.repositories

import com.example.pricingpal.model.datatransferobjects.OrganizationDTO

interface OrganizationRepository {

    suspend fun deleteOrganization(organizationName: String)
    suspend fun updateOrganization(organizationName: String)

    suspend fun getOrganizations() : List<OrganizationDTO>?
}