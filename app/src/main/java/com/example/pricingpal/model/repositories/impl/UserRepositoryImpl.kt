package com.example.pricingpal.model.repositories.impl

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
    override suspend fun deleteUser(organizationName: String) {
        withContext(Dispatchers.IO){
            postgrest.from("user").delete{eq("organization_name", organizationName)}
        }
    }

    override suspend fun updateUser(fullName: String, email: String) {
        withContext(Dispatchers.IO) {
            postgrest.from("user").update({
                set("full_name", fullName)
                set("email", email)
            })
        }
    }


}