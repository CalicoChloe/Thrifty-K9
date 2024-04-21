package com.example.pricingpal.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pricingpal.usecase.DeleteUserUseCase
import com.example.pricingpal.usecase.GetUserUseCase
import com.example.pricingpal.usecase.UpdateUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

/**
 * Class: UserViewModel
 * @author Shianne Lesure
 *
 * @property getUserUseCase is the UseCase that will get a success for fail with getting user from database
 * @property deleteUserUseCase is the UseCase that will get get a success or fail with deleting user from database.
 * @property updateUserUseCase is the UseCase that will get get a success or fail with updating user from database.
 * @property savedStateHandle component for the ViewModel that will save and restore data through configuration changes.
 * 
 * This class is the ViewModel for the User's information. When this ViewModel is created it will connect
 * to the SupaBase database, pull the user's information, and then turn them into usable data for the app.
 */
@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val deleteUserUseCase: DeleteUserUseCase,
    private val updateUserUseCase: UpdateUserUseCase,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _userFullName = MutableStateFlow("")
    private val _userEmail = MutableStateFlow("")
    private val _userOrganizationName = MutableStateFlow("")
    private val _isOwner = MutableStateFlow(false)
    private val _userMessage = MutableStateFlow("")

    // Is the value use for the input of UseCase functions for the user's id.
    private val userID = saveUUID(getUUID())

    /*
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
            val result = getUserUseCase.execute(GetUserUseCase.Input(id = userID))
            when (result){
                is GetUserUseCase.Output.Success -> {
                    _userFullName.emit(result.data.fullName)
                    _userEmail.emit(result.data.email)
                    _userOrganizationName.emit(result.data.organizationName)
                    _isOwner.emit(result.data.isOwner)

                }
                is GetUserUseCase.Output.Failure -> {
                    _userMessage.emit("Error. User request failed.")
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
                    _userMessage.emit("User has been deleted.")
                }
                is DeleteUserUseCase.Output.Failure -> {
                    _userMessage.emit("Was not able to delete user.")
                }
            }
        }
        return UUID.fromString(deleteID)
    }

    /**
     * Function: Update User
     * @author Shianne Lesure

     * This function will get the fullName, email, and organization's name input from the UpdateUserUseCaseImpl
     * and will execute either a successful output with a message letting them know of user's been updated,
     * while a fail output will message letting them know there was an error.
     */
    fun updateUser(){
        viewModelScope.launch {
            val result = updateUserUseCase.execute(
                UpdateUserUseCase.Input(
                    updateFullName = _userFullName.value,
                    updateEmail = _userEmail.value,
                    updateOrganizationName = _userOrganizationName.value
                )
            )
            when (result){
                is UpdateUserUseCase.Output.Success -> {
                    _userMessage.emit("User has been updated")
                }
                is UpdateUserUseCase.Output.Failure -> {
                    _userMessage.emit("Was not able to update user.")
                }
            }
        }
    }

    /*
      will take the full name of the user from the database and store it within a value.
      Will be use in the UI screens.
     */
    fun onNameChange(fullName: String){
        _userFullName.value = fullName
    }

    /*
     will take the email of the user from the database and store it within a value
     Will be use in the UI screens.
     */
    fun onEmailChange(email: String){
        _userEmail.value = email
    }

    /*
     will take the organization name of the user from the database and store it within a value
     Will be use in the UI screens.
     */
    fun onOrganizationNameChange(organizationName: String){
        _userOrganizationName.value = organizationName
    }

    /*
     will take whether the user is an owner or not from the database and store it within a value
     Will be use in the UI screens.
     */
    fun onIsOwnerChange(isOwner: Boolean){
        _isOwner.value = isOwner
    }
}