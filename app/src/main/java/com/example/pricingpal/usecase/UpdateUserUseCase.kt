package com.example.pricingpal.usecase

/**
 * Interface: UpdateUserUseCase
 * @author Shianne Lesure
 *
 * This interface will take a single task of updating the user from the database that test to see
 * if the function will work within the app with a success or failure.
 */
interface UpdateUserUseCase: UseCase<UpdateUserUseCase.Input, UpdateUserUseCase.Output>{
    class Input (
        val updateFullName: String,
        val updateEmail: String,
        val updateOrganizationName: String
    )
    sealed class Output() {
        object Success: Output()
        object Failure: Output()
    }
}