package com.example.pricingpal.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pricingpal.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _email = MutableStateFlow<String>("")
    val email: Flow<String> = _email

    private val _password = MutableStateFlow("")
    val password = _password

    private val _message = MutableStateFlow("")
    val message = _message

    fun onEmailChange(email: String) {
        _email.value = email
    }

    fun onPasswordChange(password: String) {
        _password.value = password
    }

    fun onLogin() {
        viewModelScope.launch {
            val result = loginUseCase.execute(
                LoginUseCase.Input(
                    email = _email.value,
                    password = _password.value
                )
            )
            when (result) {
                is LoginUseCase.Output.Success -> {
                    message.emit("Login successful!")
                }
                else -> {
                    message.emit("Login failed!")
                }
            }
        }
    }
}