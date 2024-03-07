package com.example.pricingpal.model.repositories


import com.example.pricingpal.model.datatransferobjects.OrganizationDTO
/**
 * Interface: OrganizationRepository
 * @author Abdoulie NJie
 * @version 1
 * @written 03/06/2024
 * This interface is a repository of functions that are required to interact with Organizations from the database
 */
interface OrganizationRepository {
    //delete an organization
    suspend fun deleteOrganization(organizationName: String)

    //update an organization
    suspend fun updateOrganization(organizationName: String)

    //get a list of all the organizations in the database
    suspend fun getOrganizations() : List<OrganizationDTO>?
}