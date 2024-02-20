package com.example.pricingpal.usecase

interface SignUpUseCase {
    class Input(val email: String, val password: String)
    sealed class Output {
        object Success: Output()
        object Failure: Output()
    }
}