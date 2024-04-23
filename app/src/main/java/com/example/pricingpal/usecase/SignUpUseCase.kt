package com.example.pricingpal.usecase

/**
 * Interface: SignUpUseCase
 * @author Abdoulie NJie
 * @version 1
 * @written 03/06/2024
 * This interface contains classes that are used to handle the input and output of the sign up use case
 */

interface SignUpUseCase : UseCase<SignUpUseCase.Input, SignUpUseCase.Output> {
    // data class that stores the information needed for the sign up process in its parameters to server as the input
    data class Input(val email: String, val password: String, val fullName : String, val organizationName : String, val isOwner : Boolean)
    // sealed class that initializes the objects that will reference the success and failure outputs of the sign up use case
    sealed class Output {
        object Success: Output()
        object Failure: Output()
    }
}
