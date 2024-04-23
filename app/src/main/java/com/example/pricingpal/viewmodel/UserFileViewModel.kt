package com.example.pricingpal.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pricingpal.usecase.UpdateEmailUseCase
import com.example.pricingpal.usecase.UpdatePasswordUseCase
import com.example.pricingpal.usecase.UpdateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserFileViewModel @Inject constructor(
    private val updateEmailUseCase: UpdateEmailUseCase,
    private  val updatePasswordUseCase: UpdatePasswordUseCase,
    private val updateUseCase: UpdateUseCase
): ViewModel() {
    private val _email = MutableStateFlow("")
    val email = _email

    private val _password = MutableStateFlow("")
    val password = _password

    private val _name = MutableStateFlow("")
    val name = _name

    private val _organizationName = MutableStateFlow("")
    val organizationName = _organizationName

    private val _message = MutableStateFlow("")
    val message = _message



    fun onEmailChange(email: String){ _email.value = email }
    fun onPasswordChange(password: String){ _password.value = password }
    fun onNameChange(name: String){ _name.value = name}
    fun onOrganizationChange(organization: String){ _organizationName.value = organization }




    fun updateEmail(){
        viewModelScope.launch {
            val result = updateEmailUseCase.execute(UpdateEmailUseCase.Input(email = _email.value))
            when (result){
                is UpdateEmailUseCase.Output.Success -> {
                    _message.emit("Updated Successful!")
                }
                else -> {
                    UpdateEmailUseCase.Output.Failure
                    _message.emit("Updated Failed.")
                }
            }
        }
    }

    fun updatePassword(){
        viewModelScope.launch {
            val result = updatePasswordUseCase.execute(UpdatePasswordUseCase.Input(password = _password.value))
            when (result){
                is UpdatePasswordUseCase.Output.Success -> {
                    _message.emit("Updated Successful!")
                }
                else -> {
                    UpdatePasswordUseCase.Output.Failure
                    _message.emit("Updated Failed.")
                }
            }
        }
    }

    fun updateOthers(){
        viewModelScope.launch {
            val result = updateUseCase.execute(UpdateUseCase.Input(fullName = _name.value, organizationName = _organizationName.value))
            when (result){
                is UpdateUseCase.Output.Success -> {
                    _message.emit("Updated Successful!")
                }
                else -> {
                    UpdateUseCase.Output.Failure
                    _message.emit("Updated Failed.")
                }
            }
        }
    }

}