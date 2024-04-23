package com.example.pricingpal.usecase.impl

import com.example.pricingpal.model.repositories.AuthRepository
import com.example.pricingpal.usecase.SignUpUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Class: SignUpUseCaseImpl
 * @author Abdoulie NJie
 * @version 1
 * @written 03/06/2024
 * This class acts as an implemented version of the SignUpUseCase that initializes the specific
 * handling of the input and output of the sign up use case.
 */

class SignUpUseCaseImpl@Inject constructor(
    private val authRepository: AuthRepository
) : SignUpUseCase {
    override suspend fun execute(input: SignUpUseCase.Input): SignUpUseCase.Output =
        withContext(Dispatchers.IO) {
            val result = authRepository.signUp(input.email, input.password, input.fullName, input.organizationName, input.isOwner)
            if (result) {
                SignUpUseCase.Output.Success
            } else {
                SignUpUseCase.Output.Failure
            }
        }
}

