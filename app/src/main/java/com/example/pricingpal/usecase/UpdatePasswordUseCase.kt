package com.example.pricingpal.usecase

interface UpdatePasswordUseCase: UseCase<UpdatePasswordUseCase.Input, UpdatePasswordUseCase.Output> {
    class Input (val password: String)

    sealed class Output {
        object Success : Output()
        object Failure : Output()
    }
}