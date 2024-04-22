package com.example.pricingpal.usecase.impl

import com.example.pricingpal.model.repositories.AuthRepository
import com.example.pricingpal.usecase.LoginUseCase
import com.example.pricingpal.usecase.UpdateEmailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UpdateEmailUseCaseImpl @Inject constructor(private val authRepository: AuthRepository): UpdateEmailUseCase {
    override suspend fun execute(input: UpdateEmailUseCase.Input): UpdateEmailUseCase.Output =

    }
}