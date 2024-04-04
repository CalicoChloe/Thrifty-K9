package com.example.pricingpal.model.repositories

/**
 * Interface: UserRepository
 * @author Abdoulie NJie
 * @version 1
 * @written 03/06/2024
 * This interface is a repository of functions that are required to interact with Users from the database
 */

interface UserRepository {
    // Get a list of users
    suspend fun  getUsersEmails(): List<String>?

    //Delete a user
    suspend fun deleteUser(userID: String)

    //Update a user
    suspend fun updateUser(fullName: String, email: String, organizationName: String)
}