package com.example.pricingpal.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pricingpal.model.repositories.OrganizationRepository
import com.example.pricingpal.model.repositories.UserRepository
import com.example.pricingpal.usecase.SignUpUseCase
import com.example.pricingpal.utilites.ErrorMessages.SIGN_UP_FAILED
import com.example.pricingpal.utilites.SuccessMessages.SIGN_UP_SUCCESSFUL
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
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
) : ViewModel() {
    //list of the organizations from the database
    private val _organizationsList = MutableStateFlow<List<String>?>(listOf())

    //list of the users from the database
    private val _userList = MutableStateFlow<List<String>?>(listOf())

    val organizationsNames: MutableStateFlow<List<String>?> = _organizationsList

    val usersEmails: MutableStateFlow<List<String>?> = _userList

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

    // initial call to methods whenever a sign up view model is initialized
    init{
        getOrganizationsNames()
        getUsersEmails()
    }

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

    //Gets the list of organization names from the database and emits it to _organizationsList, then returns it
    fun getOrganizationsNames() {
        viewModelScope.launch {
            val organizationsNames= organizationRepository.getOrganizationsNames()
            _organizationsList.emit(organizationsNames?: emptyList())
        }
    }


    //Gets the list of user from the database and emits it to _userList, then returns it
     fun getUsersEmails(){
        viewModelScope.launch {
            val users = userRepository.getUsersEmails()
            _userList.emit(users?: emptyList())
        }
    }
    //This function is used to send the information the user inputs on pages relating to signing up on the app
    fun onSignUp(isOwner : Boolean) {
            viewModelScope.launch {
                val result = signUpUseCase.execute(
                SignUpUseCase.Input(
                    email = _email.value.trimEnd(),
                    password = _password.value.trimEnd(),
                    fullName = _fullName.value.trimEnd(),
                    organizationName = _organizationName.value.trimEnd(),
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

