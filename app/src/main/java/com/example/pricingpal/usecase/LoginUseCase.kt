package com.example.pricingpal.usecase

interface LoginUseCase : UseCase<LoginUseCase.Input, LoginUseCase.Output> {
    class Input(val email: String, val password: String)
    sealed class Output() {
        object Success : Output()
        object Failure : Output()
    }
}