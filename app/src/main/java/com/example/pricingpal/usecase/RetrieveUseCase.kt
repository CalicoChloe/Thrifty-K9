package com.example.pricingpal.usecase

interface RetrieveUseCase: UseCase<RetrieveUseCase.Input, RetrieveUseCase.Output> {
    class Input ()

    sealed class Output {
        object Success : Output()
        object Failure : Output()
    }


}