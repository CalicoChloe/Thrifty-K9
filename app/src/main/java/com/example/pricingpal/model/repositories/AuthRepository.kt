package com.example.pricingpal.model.repositories

import io.github.jan.supabase.gotrue.user.UserInfo

/**
 * Interface: AuthRepository
 * @author Chloe Jackson
 * @version 1
 * @written 2/16/2024
 * This interface is a repository of functions that are required to authorize users through Supabase
 */
interface AuthRepository {
    suspend fun signIn(email: String, password: String): Boolean
    suspend fun signUp(email: String, password: String, fullName: String, organizationName: String, isOwner: Boolean) : Boolean

    suspend fun retrieve(): Boolean

    //suspend fun userList(): Boolean

    suspend fun updateEmail(email: String): Boolean

    suspend fun updatePassword(password: String): Boolean

    suspend fun update(fullName: String, organizationName: String): Boolean

    //suspend fun delete(uid: String): Boolean

    suspend fun signOut(): Boolean

}