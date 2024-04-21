package com.example.pricingpal.usecase

/**
 * Interface: DeleteUserUseCase
 * @author Shianne Lesure
 *
 * This interface will take a single task of deleting the user from the database that test to see
 * if the function will work within the app with a success or failure.
 */
interface DeleteUserUseCase: UseCase<DeleteUserUseCase.Input, DeleteUserUseCase.Output> {
    class Input(val deleteId: String)
    sealed class Output() {
        object Success : Output()
        object Failure: Output()
    }
}