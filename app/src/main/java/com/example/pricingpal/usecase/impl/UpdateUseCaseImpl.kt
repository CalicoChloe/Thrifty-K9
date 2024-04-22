package com.example.pricingpal.usecase.impl

import com.example.pricingpal.model.repositories.AuthRepository
import com.example.pricingpal.usecase.UpdateUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UpdateUseCaseImpl @Inject constructor(private val authRepository: AuthRepository): UpdateUseCase {
    override suspend fun execute(input: UpdateUseCase.Input): UpdateUseCase.Output {
        return withContext(Dispatchers.IO){
            val result = authRepository.update(input.fullName, input.organizationName)
            if(result){
                UpdateUseCase.Output.Success
            } else{
                UpdateUseCase.Output.Failure
            }
        }
    }
}