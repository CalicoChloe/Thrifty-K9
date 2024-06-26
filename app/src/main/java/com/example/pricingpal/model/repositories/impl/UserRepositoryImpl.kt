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
 * @author Shianne Lesure
 * @written 2/19/2024
 *
 * @property postgrest is the database that is being called to get the information of the user.
 *
 * This class acts as an implemented version of the UserRepository Interface the app can use to interact with the database's User
 */
class UserRepositoryImpl@Inject constructor(private val postgrest: Postgrest ): UserRepository{

    // Is calling the database and selecting the information from the user's id from the user's table.
    override suspend fun getUser(userId: String): UserDTO{
        return postgrest["registered_user"].select {
            eq("user_id", userId)
        }.decodeSingle<UserDTO>()
    }

    // Is calling the database and deleting the selected information of the user's id from the user's table.
    override suspend fun deleteUser(userId: String) {
        withContext(Dispatchers.IO) {
            postgrest["registered_user"].delete {
                eq("user_id", userId)
            }
        }
    }

    // Is calling the database and updating the selected information from the user's id from the user's table.
    override suspend fun updateUser(fullName: String, email: String, organizationName: String) {
        withContext(Dispatchers.IO) {
            postgrest["registered_user"].update({
                set("full_name", fullName)
                set("email", email)
                set("organization_name", organizationName)
            })
        }
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