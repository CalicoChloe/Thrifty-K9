package com.example.pricingpal.model.repositories

import androidx.lifecycle.LiveData
import com.example.pricingpal.model.Organization
import com.example.pricingpal.model.datatransferobjects.OrganizationDTO
import kotlinx.coroutines.flow.Flow

/**
 * Interface: OrganizationRepository
 * @author Abdoulie NJie
 * @written 2/19/2024
 * This interface is a repository of functions that are required to interact with organizations from the database
 */
interface OrganizationRepository {

    val selectedOrganization : LiveData<Organization>
    suspend fun getSelectedOrganization() : Organization?

    suspend fun setSelectedOrganization(org: Organization)
    suspend fun getOrganization(organizationName: String): OrganizationDTO?
    suspend fun getAllOrganizations(): List<OrganizationDTO>?
    // delete organization
    suspend fun deleteOrganization(organizationName: String)
    // update organization
    suspend fun updateOrganization(organizationName: String)
}