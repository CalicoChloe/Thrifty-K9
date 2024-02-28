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
 * This class acts as an implemented version of the UserRepository Interface the app can use to interact with the database's User
 */
class UserRepositoryImpl@Inject constructor(private val postgrest: Postgrest ): UserRepository{

    override suspend fun getUser(userId: String): UserDTO{
        return postgrest["registered_user"].select {
            eq("user_id", userId)
        }.decodeSingle<UserDTO>()

    }

    override suspend fun deleteUser(fullName: String, email: String, organizationName: String) {
        withContext(Dispatchers.IO){
            postgrest["registered_user"].delete{
                eq("full_name", fullName)
                eq("email",email)
                eq("organization_name", organizationName)
            }
        }
    }

    override suspend fun updateUser(fullName: String, email: String) {
        withContext(Dispatchers.IO) {
            postgrest["registered_user"].update({
                set("full_name", fullName)
                set("email", email)
            })
        }
    }


}