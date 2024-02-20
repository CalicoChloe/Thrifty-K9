package com.example.pricingpal.model.repositories

/**
 * Interface: AuthRepository
 * @author Chloe Jackson
 * @version 1
 * @written 2/16/2024
 * This interface is a repository of functions that are required to authorize users through Supabase
 */
interface AuthRepository {
    suspend fun logIn(email: String, password: String): Boolean
    suspend fun signUp(email: String, password: String): Boolean

}