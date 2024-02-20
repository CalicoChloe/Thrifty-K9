package com.example.pricingpal.model.repositories.impl

import com.example.pricingpal.model.repositories.UserRepository
import io.github.jan.supabase.postgrest.Postgrest
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val postgrest: Postgrest
) : UserRepository {
    //Deletes a user from the database given the organization name
    override suspend fun deleteUser(organizationName: String, userName: String): Boolean {
        /*TODO("Not yet implemented")*/
        return try {
            postgrest["users"].delete {
                eq("organizationName", organizationName)
            }
            true
        } catch (e: Exception) {
            false
        }
    }
    /*Specific function to delete an owner from the database given the organization name
    Due to RLS and trigger functions within supabase, this function also deletes all items and users
    associated with the organization*/
    override suspend fun deleteOrganization(organizationName: String): Boolean {
        return try {
            postgrest["items"].delete {
                eq("organizationName", organizationName)
            }
            postgrest["registered_user"].delete {
                eq("organizationName", organizationName)
            }
            postgrest["users"].delete {
                eq("organizationName", organizationName)
            }
            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun updateUser(fullName: String, email: String, organizationName: String) {
        //TODO("Not yet implemented")
        /*try{
            postgrest["users"].update {
                eq("organizationName", organizationName)
                set("fullName", fullName)
                set("email", email)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }*/
    }
}