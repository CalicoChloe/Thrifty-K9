package com.example.pricingpal.usecase.impl

import com.example.pricingpal.model.User
import com.example.pricingpal.model.repositories.UserRepository
import com.example.pricingpal.usecase.GetUserUseCase
import javax.inject.Inject

/**
 * Class: GetUserUseCaseImpl
 * @author Shianne Lesure
 *
 * @property userRepository is the repo that is being called on to execute the getUser function
 *
 * This class acts as an implemented version of the GetUserUseCase that app can use to test whether
 * the user's data is successfully came over from the database.
 */
class GetUserUseCaseImpl @Inject constructor(private val userRepository: UserRepository): GetUserUseCase {
    override suspend fun execute(input: GetUserUseCase.Input): GetUserUseCase.Output {
        val result = userRepository.getUser(input.id)
        return GetUserUseCase.Output.Success(

            // This is coming from UserDTO file
            data = User(
                userId = result.userId,
                fullName = result.fullName,
                email = result.email,
                organizationName = result.organizationName,
                isOwner = result.isOwner
            )
        )
    }
}