package com.example.pricingpal.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pricingpal.model.Organization
import com.example.pricingpal.model.datatransferobjects.OrganizationDTO
import com.example.pricingpal.model.repositories.OrganizationRepository
import com.example.pricingpal.model.repositories.UserRepository
import com.example.pricingpal.usecase.DeleteOrganizationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrganizationViewModel @Inject constructor(
    private val organizationRepository: OrganizationRepository,
    private val userRepository: UserRepository,
    private val deleteOrganizationUseCase: DeleteOrganizationUseCase
) : ViewModel() {

    private val _organizationName = MutableStateFlow("")
    val organizationName = _organizationName
    private val _organizationMessage = MutableStateFlow("")
    val organizationMessage = _organizationMessage
    private val _ownerID = MutableStateFlow("")
    val ownerID = _ownerID
    private val _organizationID = MutableStateFlow("")
    val organizationID = _organizationID

    fun onDeleteOrganization(isOwner: Boolean, orgName: String) {
        viewModelScope.launch {
            val result = DeleteOrganizationUseCase.Input(orgName, isOwner)
            organizationRepository.deleteOrganization(orgName, isOwner)
            when(result) {
                is DeleteOrganizationUseCase.Output.Success -> {
                    _organizationMessage.emit("Organization deleted successfully")
                }

                is DeleteOrganizationUseCase.Output.Failure -> {
                    _organizationMessage.emit("Could not delete organization")
                }
        }

    }

    fun onGetOrganization(orgName: String) {
        viewModelScope.launch {
            val result = organizationRepository.getOrganization(orgName)
            _organizationName.emit(result.organizationName)
            }
        }
    }

    private fun OrganizationDTO.asDomainModel(): Organization {
        return Organization(
            organizationID = this.organizationId,
            ownerID = this.ownerId,
            organizationName = this.organizationName
        )
    }

    fun onUpdateOrganization(orgName: String) {
        viewModelScope.launch {
            _organizationName.value = orgName
        }
    }







}