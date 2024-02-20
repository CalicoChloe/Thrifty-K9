package com.example.pricingpal.model.repositories

interface UserRepository {
    //Delete a user
    suspend fun deleteUser(organizationName: String, userName: String): Boolean

    //Delete an owner
    suspend fun deleteOrganization(organizationName: String): Boolean

    //Update a user
    suspend fun updateUser(fullName: String, email: String, organizationName: String)
}