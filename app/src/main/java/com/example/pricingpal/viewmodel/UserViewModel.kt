package com.example.pricingpal.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pricingpal.usecase.GetUserUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

//@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    /*
    private val deleteUserUseCase: DeleteUserUseCase
    private val updateUserUseCase: UpdateUserUseCase
     */
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val _userFullName = MutableStateFlow("")
    val userFullName: Flow<String> = _userFullName

    private val _userEmail = MutableStateFlow("")
    val userEmail: Flow<String> = _userEmail

    private val _userOrganizationName = MutableStateFlow("")
    val userOrganizationName: Flow<String> = _userOrganizationName

    private val _isOwner = MutableStateFlow(false)
    val isOwner: Flow<Boolean> = _isOwner


    companion object {private const val UUID_KEY = "uuid_key"}

    private val savedStateHandle = savedStateHandle

    // This will take the UUID and converted into a string so it can be saved into the state handle.
    fun saveUUID(uuid: UUID) {
        savedStateHandle[UUID_KEY] = uuid.toString()
    }

    // This will get the string UUID value and return it back to a UUID object using fromString().
    fun getUUID(): UUID {
        val uuidString = savedStateHandle.get<String>(UUID_KEY)
        return uuidString.let { UUID.fromString(it) }
    }

    // When the ViewModel is called, it will start with this function
    init {
        val userID = saveUUID(getUUID())
        getUser(userID = userID.toString())
    }

    // will take the full name of the user from the database and store it within a value
    fun onNameChange(fullName: String){
        _userFullName.value = fullName
    }

    // will take the email of the user from the database and store it within a value
    fun onEmailChange(email: String){
        _userEmail.value = email

    }

    // will take the organization name of the user from the database and store it within a value
    fun onOrganizationNameChange(organizationName: String){
        _userOrganizationName.value = organizationName
    }

    // will take whether the user is an owner or not from the database and store it within a value
    fun onIsOwnerChange(isOwner: Boolean){
        _isOwner.value = isOwner
    }


    /**
     * Function: Get User
     * @author Shianne Lesure
     *
     * @param userID is the UUID of the user, but in string form
     *
     * This function will get the userID's input from the GetUserUseCaseImpl and will execute either a
     * successful output the user's full information from the DTO files or a failure output.
     *
     * @return the userID from string form back to UUID form.
     */
    fun getUser(userID: String): UUID {
         viewModelScope.launch {
             val result = getUserUseCase.execute(
                 GetUserUseCase.Input(
                     id = userID
                 )
             )
             when (result){
                 is GetUserUseCase.Output.Success -> {
                     _userFullName.emit(result.data.fullName)
                     _userEmail.emit(result.data.email)
                     _userOrganizationName.emit(result.data.organizationName)
                     _isOwner.emit(result.data.isOwner)

                 }
                 is GetUserUseCase.Output.Failure -> {

                 }
             }
         }
        return UUID.fromString(userID)
    }

    fun deleteUser(){

    }

    fun updateUser(){

    }
}