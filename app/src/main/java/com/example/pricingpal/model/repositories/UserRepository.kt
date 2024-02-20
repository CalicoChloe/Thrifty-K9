package com.example.pricingpal.model.repositories

/**
 * Interface: UserRepository
 * @author Abdoulie NJie
 * @written 2/19/2024
 * This interface is a repository of functions that are required to interact with user from the database
 */
interface UserRepository {

    // delete user
    suspend fun deleteUser(organizationName: String)

    // update user
    suspend fun updateUser(fullName: String, email: String)

}