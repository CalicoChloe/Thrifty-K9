package com.example.pricingpal.usecase

import com.example.pricingpal.model.User

interface GetUserUseCase: UseCase<GetUserUseCase.Input, GetUserUseCase.Output> {
    class Input(val id: String)
    sealed class Output() {
        class Success(val data: User): Output()
        object Failure : Output()
    }
}