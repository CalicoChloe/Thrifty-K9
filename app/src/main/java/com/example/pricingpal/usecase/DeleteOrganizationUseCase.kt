package com.example.pricingpal.usecase

interface DeleteOrganizationUseCase : UseCase<DeleteOrganizationUseCase.Input, DeleteOrganizationUseCase.Output> {
    class Input(val orgName: String)
    sealed class Output() {
        object Success : Output()
        object Failure: Output()
    }
}