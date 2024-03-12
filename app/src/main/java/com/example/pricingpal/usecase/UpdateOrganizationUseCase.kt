package com.example.pricingpal.usecase

interface UpdateOrganizationUseCase: UseCase<UpdateOrganizationUseCase.Input, UpdateOrganizationUseCase.Output>  {
    class Input(val orgName: String)
    sealed class Output() {
        object Success : Output()
        object Failure: Output()
    }
}