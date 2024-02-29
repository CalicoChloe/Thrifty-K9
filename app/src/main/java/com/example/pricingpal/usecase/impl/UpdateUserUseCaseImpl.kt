package com.example.pricingpal.usecase.impl

import com.example.pricingpal.model.repositories.UserRepository
import com.example.pricingpal.usecase.UpdateUserUseCase
import javax.inject.Inject

/**
 * Class: UpdateUserUseCaseImpl
 * @author Shianne Lesure
 *
 * @property userRepository is the repo that is being called on to execute the updateUser function
 *
 * This class acts as an implemented version of the UpdateUserUseCase that app can use to test whether
 * the data will be successfully updated from the database.
 */
class UpdateUserUseCaseImpl @Inject constructor(private val userRepository: UserRepository): UpdateUserUseCase {
    override suspend fun execute(input: UpdateUserUseCase.Input): UpdateUserUseCase.Output {
        userRepository.updateUser(
            fullName = input.updateFullName,
            email = input.updateEmail,
            organizationName = input.updateOrganizationName
        )
        return UpdateUserUseCase.Output.Success
    }
}