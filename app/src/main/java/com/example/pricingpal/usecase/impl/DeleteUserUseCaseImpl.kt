package com.example.pricingpal.usecase.impl

import com.example.pricingpal.model.repositories.UserRepository
import com.example.pricingpal.usecase.DeleteUserUseCase
import javax.inject.Inject

/**
 * Class: DeleteUserUseCaseImpl
 * @author Shianne Lesure
 *
 * This class acts as an implemented version of the DeleteUserUseCase that app can use to test whether
 * the data will be successfully deleted from the database.
 */
class DeleteUserUseCaseImpl @Inject constructor(private val userRepository: UserRepository): DeleteUserUseCase {
    override suspend fun execute(input: DeleteUserUseCase.Input): DeleteUserUseCase.Output {
        userRepository.deleteUser(input.deleteId)
        return DeleteUserUseCase.Output.Success
    }
}