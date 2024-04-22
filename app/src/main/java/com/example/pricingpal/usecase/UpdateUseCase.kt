package com.example.pricingpal.usecase

interface UpdateUseCase: UseCase<UpdateUseCase.Input, UpdateUseCase.Output> {
    class Input (val fullName: String, val organizationName: String)

    sealed class Output {
        object Success : Output()
        object Failure : Output()
    }
}