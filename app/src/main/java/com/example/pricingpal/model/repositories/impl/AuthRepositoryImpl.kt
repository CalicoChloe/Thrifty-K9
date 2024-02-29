package com.example.pricingpal.model.repositories.impl
import com.example.pricingpal.model.repositories.AuthRepository
import com.example.pricingpal.usecase.SignUpUseCase
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
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
    override suspend fun signIn(email: String, password: String): Boolean {
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

    //This function will sign up a user using the given email, password, and take the full name and organization name
    // the user inputs to store it in the registered user table
    override suspend fun signUp(email: String, password: String, fullName: String, organizationName: String, isOwner: Boolean): Boolean {
        return try {
            val result =  auth.signUpWith(Email) {
                this.email = email
                this.password = password
                buildJsonObject {
                    put("fullName", fullName)
                    put("organizationName", organizationName)
                    put("isOwner", true)
                }
            }
            if (result != null) {
                if (result.equals(true)){
                    SignUpUseCase.Output.Success
                }
                else{
                    SignUpUseCase.Output.Failure
                }
            }

            true
        } catch (e: Exception) {
            false
        }
    }
}

/*
try {
            // Attempt to sign up the user through the repository
            val result = authRepository.signUp(input.email,
             input.password, input.fullName, input.organizationName, input.isOwner)
            // If sign-up is successful, return Success output
            if (result) {
                SignUpUseCase.Output.Success
            } else {
                // If sign-up fails, return Failure output
                SignUpUseCase.Output.Failure
            }
        } catch (e: Exception) {
            // If an exception occurs during sign-up, return Failure output
            SignUpUseCase.Output.Failure
        }
    }
 */