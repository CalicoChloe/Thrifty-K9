package com.example.pricingpal.model.repositories.impl

import com.example.pricingpal.model.datatransferobjects.UserDTO
import com.example.pricingpal.model.repositories.UserRepository
import io.github.jan.supabase.postgrest.Postgrest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Class: UserRepositoryImpl
 * @author Abdoulie NJie
 * @version 1
 * @written 03/06/2024
 * This class acts as an implemented version of the User Repository Interface the app can use to interact with the database's Users
 */

class UserRepositoryImpl @Inject constructor(
    private val postgrest: Postgrest
) : UserRepository {
    override suspend fun deleteUser(userID: String) {
        TODO("Not yet implemented")
    }

    override suspend fun updateUser(fullName: String, email: String, organizationName: String) {
        TODO("Not yet implemented")
    }

    //Gets a list of all users from the database
    override suspend fun getUsersEmails(): List<String>? {
        return withContext(Dispatchers.IO) {
            val results = postgrest["registered_user"].select().decodeList<UserDTO>()
            val emails = results.map { it.email };
            emails
        }
    }

}