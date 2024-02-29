package com.example.pricingpal.usecase

interface SignUpUseCase : UseCase<SignUpUseCase.Input, SignUpUseCase.Output> {
    data class Input(val email: String, val password: String, val fullName : String, val organizationName : String, val isOwner : Boolean)
    sealed class Output {
        object Success: Output()
        object Failure: Output()
    }
}
