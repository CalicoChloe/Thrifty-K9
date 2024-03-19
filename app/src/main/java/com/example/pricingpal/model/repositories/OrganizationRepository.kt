package com.example.pricingpal.model.repositories

import com.example.pricingpal.model.datatransferobjects.OrganizationDTO

/**
 * Interface: OrganizationRepository
 * @author Abdoulie NJie
 * @written 2/19/2024
 * This interface is a repository of functions that are required to interact with organizations from the database
 */
interface OrganizationRepository {


    // delete organization
    suspend fun deleteOrganization(organizationName: String, isOwner: Boolean)
    // update organization
    suspend fun updateOrganization(organizationName: String)

    suspend fun getOrganization(organizationName: String): OrganizationDTO

    suspend fun addOrganization(organizationName: String)
}