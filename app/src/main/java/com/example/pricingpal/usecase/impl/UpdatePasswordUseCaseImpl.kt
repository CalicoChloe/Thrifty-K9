package com.example.pricingpal.usecase.impl

import com.example.pricingpal.model.repositories.AuthRepository
import com.example.pricingpal.usecase.UpdatePasswordUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UpdatePasswordUseCaseImpl @Inject constructor(private val authRepository: AuthRepository): UpdatePasswordUseCase{
    override suspend fun execute(input: UpdatePasswordUseCase.Input): UpdatePasswordUseCase.Output {
        return withContext(Dispatchers.IO){
            val result = authRepository.updatePassword(input.password)
            if(result){
                UpdatePasswordUseCase.Output.Success
            } else{
                UpdatePasswordUseCase.Output.Failure
            }
        }
    }
}