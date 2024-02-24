package com.example.pricingpal.model.repositories

interface UserRepository {
    //Delete a user
    suspend fun deleteUser(organizationName: String)

    //Update a user
    suspend fun updateUser(fullName: String, email: String, organizationName: String)
}