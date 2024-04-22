package com.example.pricingpal.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pricingpal.model.Organization
import com.example.pricingpal.model.datatransferobjects.OrganizationDTO
import com.example.pricingpal.model.repositories.OrganizationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrganizationViewModel @Inject constructor(
    private val organizationRepository: OrganizationRepository
) : ViewModel() {
    private val _organizationList = MutableStateFlow<List<Organization>?>(listOf())
    val organizationList: Flow<List<Organization>?> = _organizationList

    init {
        getOrganizations()
    }

    fun getOrganizations() {
        viewModelScope.launch {
            val organizations = organizationRepository.getAllOrganizations()
            _organizationList.emit(organizations?.map { it -> it.asDomainModel() })
        }
    }

    private fun OrganizationDTO.asDomainModel(): Organization {
        return Organization(
            organizationId = this.organizationId,
            organizationName = this.organizationName,
            ownerId = this.ownerId
        )
    }

    suspend fun setSelectedOrganization(org: Organization) {
        organizationRepository.setSelectedOrganization(org)
    }

    suspend fun getSelectedOrganization(): Organization? {
        return organizationRepository.getSelectedOrganization()
    }
}