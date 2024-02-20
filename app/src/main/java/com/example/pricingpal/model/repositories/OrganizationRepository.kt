package com.example.pricingpal.model.repositories

interface OrganizationRepository {

    suspend fun deleteOrganization(organizationName: String)
    suspend fun updateOrganization(organizationName: String)
}