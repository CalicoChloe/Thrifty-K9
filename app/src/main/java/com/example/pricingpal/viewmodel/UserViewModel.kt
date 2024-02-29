package com.example.pricingpal.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pricingpal.usecase.DeleteUserUseCase
import com.example.pricingpal.usecase.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

/**
 * Class: UserViewModel
 * @author Shianne Lesure
 *
 * This class is the ViewModel for the User's information. When this ViewModel is created it will connect
 * to the SupaBase database, pull the user's information, and then turn them into usable data for the app.
 */
@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val deleteUserUseCase: DeleteUserUseCase,
    /*
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

    private val _userMessage = MutableStateFlow("")
    val userMessage = _userMessage

    // Is the value use for the input of UseCase functions for the user's id.
    private val userID = saveUUID(getUUID())

    private val savedStateHandle = savedStateHandle

    // This holds the UUID key that will be coming from the database. It is put inside a companion object
    // because it associates the constant value to the user's ViewModel and ensures it is scoped to the class.
    companion object {private const val UUID_KEY = "uuid_key"}

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
        getUser(userID = userID.toString())
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

    /**
     * Function: Delete User
     * @author Shianne Lesure
     *
     * @param deleteID is the UUID of the user, but in string form
     *
     * This function will get the deleteID's input from the DeleteUserUseCaseImpl and will execute
     * either a successful output with a message letting them know of user's deletion, while a fail output
     * will message letting them know there was an error.
     *
     * @return the deleteID from string form back to UUID form.
     */
    fun deleteUser(deleteID: String): UUID{
        viewModelScope.launch {
            when (deleteUserUseCase.execute(DeleteUserUseCase.Input(deleteId = deleteID))){
                is DeleteUserUseCase.Output.Success -> {
                    userMessage.emit("User has been deleted.")
                }
                is DeleteUserUseCase.Output.Failure -> {
                    userMessage.emit("Was not able to delete user.")
                }
            }
        }
        return UUID.fromString(deleteID)
    }

    // will take the full name of the user from the database and store it within a value.
    // Will be use in the UI screens.
    fun onNameChange(fullName: String){
        _userFullName.value = fullName
    }

    // will take the email of the user from the database and store it within a value
    // Will be use in the UI screens.
    fun onEmailChange(email: String){
        _userEmail.value = email

    }

    // will take the organization name of the user from the database and store it within a value
    // Will be use in the UI screens.
    fun onOrganizationNameChange(organizationName: String){
        _userOrganizationName.value = organizationName
    }

    // will take whether the user is an owner or not from the database and store it within a value
    // Will be use in the UI screens.
    fun onIsOwnerChange(isOwner: Boolean){
        _isOwner.value = isOwner
    }

    fun updateUser(){

    }
}