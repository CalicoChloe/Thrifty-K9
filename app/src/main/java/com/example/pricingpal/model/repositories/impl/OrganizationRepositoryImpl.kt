package com.example.pricingpal.model.repositories.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pricingpal.model.Organization
import com.example.pricingpal.model.datatransferobjects.OrganizationDTO
import com.example.pricingpal.model.repositories.OrganizationRepository
import io.github.jan.supabase.postgrest.Postgrest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class OrganizationRepositoryImpl @Inject constructor(
    private val postgrest: Postgrest
    ) : OrganizationRepository {

        private val _selectedOrganization = MutableLiveData<Organization>()
        override val selectedOrganization: LiveData<Organization> = _selectedOrganization

        override suspend fun getSelectedOrganization(): Organization? {
            return selectedOrganization.value
        }

        override suspend fun setSelectedOrganization(org: Organization) {
            _selectedOrganization.value = org
        }

        override suspend fun getOrganization(organizationName: String): OrganizationDTO? {
        return withContext(Dispatchers.IO) {
            val results = postgrest["organization"].select {
                eq("organization_name", organizationName)
            }.decodeSingle<OrganizationDTO>()
            results
        }
    }
        override suspend fun getAllOrganizations(): List<OrganizationDTO>? {
        return withContext(Dispatchers.IO) {
            val results = postgrest["organization"].select().decodeList<OrganizationDTO>()
            results
        }
    }

    override suspend fun deleteOrganization(organizationName: String) {
        TODO("Not yet implemented")
    }

    override suspend fun updateOrganization(organizationName: String) {
        TODO("Not yet implemented")
    }

}