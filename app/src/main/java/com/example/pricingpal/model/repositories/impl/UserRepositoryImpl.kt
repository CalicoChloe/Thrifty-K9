package com.example.pricingpal.model.repositories.impl

import com.example.pricingpal.model.repositories.UserRepository
import io.github.jan.supabase.postgrest.Postgrest
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val postgrest: Postgrest
) : UserRepository {
    override suspend fun deleteUser(organizationName: String) {
        TODO("Not yet implemented")
    }

    override suspend fun updateUser(fullName: String, email: String, organizationName: String) {
        TODO("Not yet implemented")
    }
}