package com.example.pricingpal.usecase

interface UpdateEmailUseCase: UseCase<UpdateEmailUseCase.Input, UpdateEmailUseCase.Output> {
    class Input(val email: String)

    sealed class Output {
        object Success : Output()
        object Failure : Output()
    }
}