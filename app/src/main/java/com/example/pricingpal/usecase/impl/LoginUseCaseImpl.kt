package com.example.pricingpal.usecase.impl

import com.example.pricingpal.model.repositories.AuthRepository
import com.example.pricingpal.usecase.LoginUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginUseCaseImpl @Inject constructor(
    private val authRepository: AuthRepository
) : LoginUseCase {
    override suspend fun execute(input: LoginUseCase.Input): LoginUseCase.Output {
        return withContext(Dispatchers.IO) {
            val result = authRepository.signIn(input.email, input.password)
            if (result) {
                LoginUseCase.Output.Success
            } else {
                LoginUseCase.Output.Failure
            }
        }
    }
}