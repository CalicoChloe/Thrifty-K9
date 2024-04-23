package com.example.pricingpal.usecase.impl

import com.example.pricingpal.model.repositories.AuthRepository
import com.example.pricingpal.usecase.RetrieveUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RetrieveUseCaseImpl @Inject constructor(private val authRepository: AuthRepository):
    RetrieveUseCase {
    override suspend fun execute(input: RetrieveUseCase.Input): RetrieveUseCase.Output {
        return withContext(Dispatchers.IO) {
            val result = authRepository.retrieve()
            if (result) {
                RetrieveUseCase.Output.Success
            } else {
                RetrieveUseCase.Output.Failure
            }
        }
    }
}