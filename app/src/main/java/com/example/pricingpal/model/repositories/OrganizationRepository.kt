package com.example.pricingpal.model.repositories

import com.example.pricingpal.model.Organization
import com.example.pricingpal.model.datatransferobjects.OrganizationDTO

/**
 * Interface: OrganizationRepository
 * @author Abdoulie NJie
 * @written 2/19/2024
 * This interface is a repository of functions that are required to interact with organizations from the database
 */
interface OrganizationRepository {

    suspend fun getSelectedOrganization() : Organization?

    suspend fun setSelectedOrganization(org: Organization)
    suspend fun getOrganization(organizationName: String): OrganizationDTO?
    suspend fun getAllOrganizations(): List<OrganizationDTO>?
    // delete organization
    suspend fun deleteOrganization(organizationName: String)
    // update organization
    suspend fun updateOrganization(organizationName: String)
}