package com.example.pricingpal.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pricingpal.model.Organization
import com.example.pricingpal.model.datatransferobjects.OrganizationDTO
import com.example.pricingpal.model.repositories.AuthRepository
import com.example.pricingpal.model.repositories.OrganizationRepository
import com.example.pricingpal.utilites.ErrorMessages.ORGANIZATION_NAME_ALREADY_TAKEN
import com.example.pricingpal.utilites.ErrorMessages.ORGANIZATION_NAME_EMPTY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val organizationRepository: OrganizationRepository
) : ViewModel() {

    //lists of the organizations from the database
    private val _organizationsList = MutableStateFlow<List<Organization>?>(listOf())

    private val _email = MutableStateFlow("")
    val email: Flow<String> = _email

    private val _password = MutableStateFlow("")
    val password = _password

    private val _fullName = MutableStateFlow("")
    val fullName = _fullName

    private val _organizationName = MutableStateFlow("")
    val organizationName = _organizationName

    fun onEmailChange(email: String) {
        _email.value = email
    }

    fun onPasswordChange(password: String) {
        _password.value = password
    }

    fun onNameChange(fullName : String){
        _fullName.value = fullName
    }

    fun  onOrganizationChange(organizationName : String){
        _organizationName.value = organizationName
    }

suspend fun OrganizationDTO.asDomainModel(): Organization {
        return Organization(
            organizationName = this.organizationName
        )
    }

    //Gets the list of organizations from the database and emits it to _organizationsList, then returns it
    fun getOrganizations () : MutableStateFlow<List<Organization>?> {
        viewModelScope.launch {
            val organizationsList = organizationRepository.getOrganizations()
            _organizationsList.emit(organizationsList?.map { it -> it.asDomainModel() })
        }
        return  _organizationsList
    }

    fun onSignUp() {
        if (organizationName.value.isBlank()) {
            ORGANIZATION_NAME_EMPTY
            return
        }
        viewModelScope.launch {
            // Check if any organization has the same name as the one entered by the user
            if (getOrganizations().value?.contains(Organization(organizationName.value)) == true) {
                // Display error message
                ORGANIZATION_NAME_ALREADY_TAKEN
                return@launch
            }
        }
        viewModelScope.launch {
            authRepository.signUp(
                email = _email.value,
                password = _password.value,
                fullName =  _fullName.value,
                organizationName = _organizationName.value,
                isOwner = true
            )
        }
    }
}

