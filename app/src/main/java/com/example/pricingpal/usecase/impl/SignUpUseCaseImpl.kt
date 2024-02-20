package com.example.pricingpal.usecase.impl

import com.example.pricingpal.model.repositories.AuthRepository
import com.example.pricingpal.usecase.SignUpUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SignUpUseCaseImpl@Inject constructor(
    private val authenticationRepository: AuthRepository
) : SignUpUseCase {
    suspend fun execute(input: SignUpUseCase.Input): SignUpUseCase.Output =
        withContext(Dispatchers.IO) {
            val result = authenticationRepository.signUp(input.email, input.password)
            if (result) {
                SignUpUseCase.Output.Success
            } else {
                SignUpUseCase.Output.Failure
            }
        }
}