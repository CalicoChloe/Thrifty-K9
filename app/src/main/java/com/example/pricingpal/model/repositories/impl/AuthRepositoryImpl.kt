package com.example.pricingpal.model.repositories.impl
import com.example.pricingpal.model.repositories.AuthRepository
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import javax.inject.Inject

/**
 * Class: AuthRepositoryImpl
 * @author Chloe Jackson
 * @version 1
 * @written 2/16/2024
 * This class acts as an implemented version of the AuthRepository Interface the app can use to authenticate users
 */
class AuthRepositoryImpl @Inject constructor(
    private val auth: Auth
) : AuthRepository {
    //This function will sign in a user using the given email and password
    override suspend fun logIn(email: String, password: String): Boolean {
        return try {
            auth.signInWith(Email) {
                this.email = email
                this.password = password
            }
            true
        } catch (e: Exception) {
            false
        }
    }

    //This function will sign up a user using the given email and password
    override suspend fun signUp(email: String, password: String): Boolean {
        return try {
            auth.signUpWith(Email) {
                this.email = email
                this.password = password
            }
            true
        } catch (e: Exception) {
            false
        }
    }
}