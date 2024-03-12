package com.example.pricingpal.model.repositories.impl

import com.example.pricingpal.model.repositories.OrganizationRepository
import io.github.jan.supabase.postgrest.Postgrest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class OrganizationRepositoryImpl @Inject constructor(
    private val postgrest: Postgrest
    ) : OrganizationRepository {
    override suspend fun deleteOrganization(organizationName: String) {
        withContext(Dispatchers.IO) {
            postgrest["registered_user"].delete {
                eq("organizationName", organizationName)
            }
        }
        withContext(Dispatchers.IO) {
            postgrest["items"].delete {
                eq("organizationName", organizationName)
            }
        }
        withContext(Dispatchers.IO) {
            postgrest["organization"].delete {
                eq("organizationName", organizationName)
            }
        }
    }

    override suspend fun updateOrganization(organizationName: String) {
        withContext(Dispatchers.IO) {
            postgrest["organization"].update ({
                set("organizationName", organizationName)
            })
        }
    }

}