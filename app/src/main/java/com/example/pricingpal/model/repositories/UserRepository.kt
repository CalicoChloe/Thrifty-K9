package com.example.pricingpal.model.repositories

import com.example.pricingpal.model.datatransferobjects.UserDTO

/**
 * Interface: UserRepository
 * @author Abdoulie NJie
 * @author Shianne Lesure
 * @written 2/19/2024
 * This interface is a repository of functions that are required to interact with user from the database
 */
interface UserRepository {

    suspend fun getUsers(): List<UserDTO>?

    suspend fun getOneUser(email: String): UserDTO

    suspend fun deleteOneUser(email: String)

    //get user
    suspend fun getUser(userId: String): UserDTO

    // delete user
    suspend fun deleteUser(userId: String)

    // update user
    suspend fun updateUser(fullName: String, email: String, organizationName: String)

}