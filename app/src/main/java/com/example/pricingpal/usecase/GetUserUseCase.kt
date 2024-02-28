package com.example.pricingpal.usecase

import com.example.pricingpal.model.User

/**
 * Interface: GetUserUseCase
 * @author Shianne Lesure
 *
 * This interface will take a single task of getting the user from the database that test to see
 * if the function will work within the app with a success or failure.
 */
interface GetUserUseCase: UseCase<GetUserUseCase.Input, GetUserUseCase.Output> {
    class Input(val id: String)
    sealed class Output() {
        class Success(val data: User): Output()
        object Failure : Output()
    }
}