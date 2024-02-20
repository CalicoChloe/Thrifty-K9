package com.example.pricingpal.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pricingpal.model.User
import com.example.pricingpal.model.datatransferobjects.UserDTO
import com.example.pricingpal.model.repositories.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

//@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository: UserRepository): ViewModel() {
    private val _fullName = MutableStateFlow("")
    val fullName: Flow<String> = _fullName

    private val _email = MutableStateFlow("")
    val email: Flow<String> = _email

    private val _organizationName = MutableStateFlow("")
    val organizationName: Flow<String> = _organizationName


    fun deleteUser(){

    }

    fun updateUser(){

    }

    private fun UserDTO.asDomainModel(): User {
        return  User(
            fullName = this.fullName,
            email = this.email,
            organizationName = this.organizationName
        )
    }
}