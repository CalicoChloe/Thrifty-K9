package com.example.pricingpal.model.repositories.impl

import com.example.pricingpal.model.datatransferobjects.OrganizationDTO
import com.example.pricingpal.model.repositories.OrganizationRepository
import io.github.jan.supabase.postgrest.Postgrest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class OrganizationRepositoryImpl @Inject constructor(
    private val postgrest: Postgrest
    ) : OrganizationRepository {
    override suspend fun deleteOrganization(organizationName: String, isOwner: Boolean) {
       if(isOwner) {
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
    }

    override suspend fun updateOrganization(organizationName: String) {
        withContext(Dispatchers.IO) {
            postgrest["organization"].update ({
                set("organizationName", organizationName)
            })
        }
    }

    override suspend fun getOrganization(organizationName: String): OrganizationDTO {
            return postgrest["organization"].select {
                eq("organizationName", organizationName)
            }.decodeSingle<OrganizationDTO>()

    }
    //Error for the insert command...Don't know how to do that yet....Looking into it
    override suspend fun addOrganization(organizationName: String) {
        withContext(Dispatchers.IO) {
            val organization = OrganizationDTO(organizationName) // Assuming OrganizationDTO takes organizationName as a constructor parameter
            postgrest["organization"].insert(organization)
        }
    }

}