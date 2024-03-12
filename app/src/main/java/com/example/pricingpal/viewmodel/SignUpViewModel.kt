package com.example.pricingpal.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pricingpal.model.Organization
import com.example.pricingpal.model.User
import com.example.pricingpal.model.datatransferobjects.OrganizationDTO
import com.example.pricingpal.model.datatransferobjects.UserDTO
import com.example.pricingpal.model.repositories.OrganizationRepository
import com.example.pricingpal.model.repositories.UserRepository
import com.example.pricingpal.usecase.SignUpUseCase
import com.example.pricingpal.utilites.ErrorMessages.SIGN_UP_FAILED
import com.example.pricingpal.utilites.SuccessMessages.SIGN_UP_SUCCESSFUL
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

/**
 * Class: SignUpViewModel
 * @author Abdoulie NJie
 * @version 1
 * @written 03/06/2024
 * This class is the ViewModel for the information that correlate with the sign up process. When this ViewModel is created it will connect
 * to the SupaBase database, pull the information , then turn them into usable data for the app.
 */

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val organizationRepository: OrganizationRepository,
    private val userRepository: UserRepository,
    private val signUpUseCase : SignUpUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    //list of the organizations from the database
    private val _organizationsList = MutableStateFlow<List<Organization>?>(listOf())

    //list of the organizations from the database
    private val _userList = MutableStateFlow<List<User>?>(listOf())

    val organizations: MutableStateFlow<List<Organization>?> = _organizationsList

    val users: MutableStateFlow<List<User>?> = _userList

    //val used to store the user's input for their email
    private val _email = MutableStateFlow("")
    val email = _email

    //val used to store the user's input for their password
    private val _password = MutableStateFlow("")
    val password = _password

    //val used to store the user's input for their full name
    private val _fullName = MutableStateFlow("")
    val fullName = _fullName

    //val used to store the user's input for their organization name
    private val _organizationName = MutableStateFlow("")
    val organizationName = _organizationName

    //val used to store the message that will be displayed when the sign up process fails or succeeds
    private val _message = MutableStateFlow("")
    val message = _message

    //function used to update user's input for their email
    fun onEmailChange(email: String) {
        _email.value = email
    }

    //function used to update user's input for their password
    fun onPasswordChange(password: String) {
        _password.value = password
    }

    //function used to update user's input for their full name
    fun onNameChange(fullName: String) {
        _fullName.value = fullName
    }

    //function used to update user's input for their organization name
    fun onOrganizationChange(organizationName: String) {
        _organizationName.value = organizationName
    }

    // Is the value use for the input of UseCase functions for the user's id.
    private val userID = saveUUID(getUUID())

    /**
     * This holds the UUID key that will be coming from the database. It is put inside a companion object
     * because it associates the constant value to the user's ViewModel and ensures it is scoped to the class.
     */
    companion object {private const val UUID_KEY = "uuid_key"}

    /**
     * Function: saveUUID
     * @author Shianne Lesure
     *
     * @param uuid is the id that is coming from the user's table from the database
     *
     * This will take the UUID and converted into a string so it can be saved into the state handle.
     */
    fun saveUUID(uuid: UUID) {
        savedStateHandle[UUID_KEY] = uuid.toString()
    }

    /**
     * Function: getUUID
     * @author Shianne Lesure
     *
     * This will get the string UUID value and return it back to a UUID object using fromString().
     */
    fun getUUID(): UUID {
        val uuidString = savedStateHandle.get<String>(UUID_KEY)
        return uuidString.let { UUID.fromString(it) }
    }


    //Gets the list of organizations from the database and emits it to _organizationsList, then returns it
    fun getOrganizations () {
        viewModelScope.launch {
            val organizations = organizationRepository.getOrganizations()
            _organizationsList.emit(organizations?.map { it -> it.asDomainModel() })
        }
    }

    //When the Organization data from the database is pulled, this function will translate it from a DTO to the real object
    private fun OrganizationDTO.asDomainModel(): Organization {
        return Organization(
            organizationID = this.organizationID.toString(),
            ownerID = this.ownerID.toString(),
            organizationName = this.organizationName
        )
    }

    //Gets the list of user from the database and emits it to _userList, then returns it
     fun getUsers(){
        viewModelScope.launch {
            val users = userRepository.getUsers()
            _userList.emit(users?.map { it -> it.asDomainModel() })
        }
    }
    //When the User data from the database is pulled, this function will translate it from a DTO to the real object
    private fun UserDTO.asDomainModel(): User {
        return User(
            userID = this.userID,
            fullName = this.fullName,
            email = this.email,
            organizationName = this.organizationName,
            isOwner = this.isOwner
        )
    }
    //This function
    fun onSignUp(isOwner : Boolean) {
            viewModelScope.launch {
                val result = signUpUseCase.execute(
                SignUpUseCase.Input(
                    email = _email.value,
                    password = _password.value,
                    fullName = _fullName.value,
                    organizationName = _organizationName.value,
                    isOwner = isOwner
                )
                )
                when (result) {
                    is SignUpUseCase.Output.Success -> {
                        _message.emit(SIGN_UP_SUCCESSFUL)
                    }
                    is SignUpUseCase.Output.Failure -> {
                        _message.emit(SIGN_UP_FAILED)
                    }
                }
            }
    }
}

