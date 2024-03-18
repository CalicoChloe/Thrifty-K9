package com.example.pricingpal.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pricingpal.model.Organization
import com.example.pricingpal.model.datatransferobjects.OrganizationDTO
import com.example.pricingpal.model.repositories.OrganizationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrganizationViewModel @Inject constructor(
    private val organizationRepository: OrganizationRepository
) : ViewModel() {
    private val _selectedOrganizationName = MutableStateFlow<String?>(null)
    val selectedOrganizationName: Flow<String?> = _selectedOrganizationName

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
            organizationName = this.organizationName,
        )
    }

    fun setSelectedOrganizationName(organizationName: String) {
        _selectedOrganizationName.value = organizationName
    }
}